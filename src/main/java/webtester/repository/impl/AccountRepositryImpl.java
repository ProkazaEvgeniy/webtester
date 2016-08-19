package webtester.repository.impl;

public class AccountRepositryImpl {/* implements AccountRepositry {

	public Account findByLogin(String login) {
		Connection c = getCurrentConnection();
		try {
			return (Account) new QueryRunner().query(c, "select * from account where login=?",
					new DefaultResultSetHandler(Account.class, false), login);
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}

	@Override
	public List<Account> findAll() {
		Connection c = getCurrentConnection();
		try {
			return (List<Account>) new QueryRunner().query(c, "select * from account",
					new DefaultResultSetHandler(Account.class, true));
		} catch (SQLException e) {
			throw new WebtesterApplicationException(e);
		}
	}*/

}
