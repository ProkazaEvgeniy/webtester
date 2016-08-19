package webtester.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import webtester.annotation.Transactional;
import webtester.exception.WebtesterApplicationException;
import webtester.repository.ConnectionUtils;

public class ServiceFactory {

	public static Object createService(DataSource dataSource, Object realService){
		return Proxy.newProxyInstance(
				ServiceFactory.class.getClassLoader(), 
				realService.getClass().getInterfaces(), 
				new ServiceInvocationHandler(realService, dataSource));
	}
	
	private static class ServiceInvocationHandler implements InvocationHandler {
		private final Object realService;
		private final DataSource dataSource;
		
		public ServiceInvocationHandler(Object realService, DataSource dataSource) {
			super();
			this.realService = realService;
			this.dataSource = dataSource;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Method m = findMethod(method);
			Transactional transactinal = m.getAnnotation(Transactional.class);
			if(transactinal != null){
				return invokeTransactional(transactinal, m, args);
			} else{
				return m.invoke(realService, args);
			}
		}
		
		private Object invokeTransactional(Transactional transactinal, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			try (Connection c = dataSource.getConnection()) {
				c.setAutoCommit(false);
				ConnectionUtils.setCurrentConnection(c);
				if(transactinal.readOnly()){
					return method.invoke(realService, args);
				}else{
					try{
						Object result = method.invoke(realService, args);
						c.commit();
						return result;
					}catch(Exception e) {
						if(e instanceof RuntimeException){
							c.rollback();
						} else {
							c.commit();
						}
						throw e;
					}
				}
			} catch (SQLException e) {
				throw new WebtesterApplicationException(e);
			} finally {
				ConnectionUtils.removeCurrentConnection();
			}
		}
		
		private Method findMethod(Method method){
			for (Method m : realService.getClass().getDeclaredMethods()) {
				if(m.getName().equals(method.getName()) && 
						Arrays.equals(m.getParameterTypes(), method.getParameterTypes())){
					return m;
				}
			}
			throw new IllegalArgumentException("Can`t find method "+method+" in the "+realService.getClass());
		}
	}
}
