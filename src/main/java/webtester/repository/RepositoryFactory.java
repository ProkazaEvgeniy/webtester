package webtester.repository;

import static webtester.repository.ConnectionUtils.getCurrentConnection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.annotation.Update;
import webtester.exception.WebtesterApplicationException;
import webtester.handler.DefaultResultSetHandler;

public class RepositoryFactory {

	@SuppressWarnings("unchecked")
	public static <T> T createRepository(Class<T> repositoryInterface) {
		return (T) Proxy.newProxyInstance(
				RepositoryFactory.class.getClassLoader(), 
				new Class[] { repositoryInterface },
				new RepositoryInvocationHandler());
	}

	private static class RepositoryInvocationHandler implements InvocationHandler {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			try {
				Connection c = getCurrentConnection();
				Select select = method.getAnnotation(Select.class);
				if (select != null) {
					return select(c, select, method, args);
				}
				Delete delete = method.getAnnotation(Delete.class);
				if (delete != null) {
					return delete(c, delete, method, args);
				}
				Insert insetr = method.getAnnotation(Insert.class);
				if (insetr != null) {
					return insert(c, insetr, method, args);
				}
				Update update = method.getAnnotation(Update.class);
				if (update != null) {
					return update(c, update, method, args);
				}
				
			} catch (SQLException e) {
				throw new WebtesterApplicationException(e);
			}
			throw new UnsupportedOperationException("Not implemented yet: " + method);
		}
		
		private Object[] getUpdateArguments(Object[] args) throws IllegalArgumentException, IllegalAccessException {
			if (args.length == 1) {
				Object entity = args[0];
				Field fields[] = entity.getClass().getDeclaredFields();
				List<Object> resolvedArgs = new ArrayList<>();
				for (Field f : fields) {
					if (f.getName().equals("created") || f.getName().equals("active")
							|| Modifier.isStatic(f.getModifiers())|| Modifier.isTransient(f.getModifiers())) {
						continue;
					} else {
						f.setAccessible(true);
						resolvedArgs.add(f.get(entity));
					}
				}
				return resolvedArgs.toArray();
			} else {
				return args;
			}
		}
		
		public Object update(Connection c, Update update, Method method, Object[] args) throws SQLException, IllegalArgumentException, IllegalAccessException {
			Object[] updateArgs = getUpdateArguments(args);
			Object entity = new QueryRunner().update(c, update.sql(), updateArgs);
			return entity;
			
			/*String sql = update.sql();
			PreparedStatement st = c.prepareStatement(sql);
			Account account = (Account) args[0];
			st.setString(1, account.getLogin());
			st.setString(2, account.getPassword());
			st.setLong(3, account.getId());
			int n = st.executeUpdate(sql);
			st.close();
			c.close();
			return null;// new QueryRunner().update(c, sql, args);*/
			
		}

		private Object[] getInsertArguments(Object[] args) throws IllegalArgumentException, IllegalAccessException {
			if (args.length == 1) {
				Object entity = args[0];
				Field fields[] = entity.getClass().getDeclaredFields();
				List<Object> resolvedArgs = new ArrayList<>();
				for (Field f : fields) {
					if (f.getName().equals("id") || f.getName().equals("created") || f.getName().equals("active")
							|| Modifier.isStatic(f.getModifiers())|| Modifier.isTransient(f.getModifiers())) {
						continue;
					} else {
						f.setAccessible(true);
						resolvedArgs.add(f.get(entity));
					}
				}
				return resolvedArgs.toArray();
			} else {
				return args;
			}
		}

		private Object insert(Connection c, Insert insert, Method method, Object[] args)
				throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException,
				SecurityException, InstantiationException, InvocationTargetException {
			Object[] insertArgs = getInsertArguments(args);
			Class<?> returnType = args[0].getClass();
			ResultSetHandler h = build(returnType, false, insert.resultSetHandlerClass());
			Object entity = new QueryRunner().insert(c, insert.sql(), h, insertArgs);
			return entity;
		}

		private Object delete(Connection c, Delete delete, Method method, Object[] args) throws SQLException {
			int res = new QueryRunner().update(c, delete.sql(), args);
			if (method.getReturnType() == Integer.TYPE) {
				return res;
			} else if (method.getReturnType() == Void.TYPE) {
				return null;
			} else {
				throw new IllegalArgumentException("Method is delete annotation should return void or int");
			}
		}

		private Object select(Connection c, Select select, Method method, Object[] args)
				throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
				IllegalArgumentException, InvocationTargetException, SQLException {
			Class<?> returnType = findResultType(method);
			boolean isCollection = Collection.class.isAssignableFrom(method.getReturnType());
			ResultSetHandler h = build(returnType, isCollection, select.resultSetHandlerClass());
			return new QueryRunner().query(c, select.sql(), h, args);
		}

		private ResultSetHandler build(Class<?> returnType, boolean isCollection,
				Class<? extends DefaultResultSetHandler> resultSetHandlerClass)
				throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
				IllegalArgumentException, InvocationTargetException {
			if(returnType == Integer.TYPE) {
				return new ResultSetHandler<Integer>() {

					@Override
					public Integer handle(ResultSet rs) throws SQLException {
						rs.next();
						return rs.getInt(1);
					}
				};
			}
			else {
				Constructor<? extends DefaultResultSetHandler> constructor = resultSetHandlerClass
						.getConstructor(Class.class, Boolean.TYPE);
				return constructor.newInstance(returnType, isCollection);
			}
		}

		private Class<?> findResultType(Method method) {
			ReturnType returnType = method.getAnnotation(ReturnType.class);
			if (returnType != null) {
				return returnType.entityClass();
			} else {
				return method.getReturnType();
			}
		}
	}
}
