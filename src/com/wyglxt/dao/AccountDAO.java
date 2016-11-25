package com.wyglxt.dao;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.Account;

public class AccountDAO extends BaseDAO {

	public AccountDAO() {
		super();
		table = "Account";
	}

	@Override
	public Class<?> getModelClass() {
		return Account.class;
	}

	@Override
	protected Query getQuery(String queryType, Map<String, Object> condition) {
		Query query = null;

		if (queryType == null || "".equals(queryType)) {
			return query;
		}

		if ("queryForLogin".equalsIgnoreCase(queryType)) {
			query = queryForLogin(condition);
		} else if ("queryByName".equalsIgnoreCase(queryType)) {
			query = queryByName(condition);
		}
		return query;
	}

	private Query queryByName(Map<String, Object> condition) {
		Query query = null;
		if (null == condition || condition.isEmpty()) {
			return query;
		}
		Session session = getCurrentSession();
		StringBuilder sb = new StringBuilder();
		sb.append("from " + table + " as record where record.name= :NAME");
		query = session.createQuery(sb.toString());
		query.setString("NAME", (String) condition.get("name"));
		return query;
	}

	private Query queryForLogin(Map<String, Object> condition) {
		Query query = null;

		if (condition != null && !condition.isEmpty()) {
			Session session = getCurrentSession();
			StringBuffer sb = new StringBuffer();

			sb.append("from " + table
					+ " record where record.username = :USERNAME and record.password = :PASSWORD and record.role = :ROLE");
			query = session.createQuery(sb.toString());

			String username = (String) condition.get("username");
			String password = (String) condition.get("password");
			String role = (String) condition.get("role");

			if (username != null) {
				query.setString("USERNAME", username);
			}

			if (password != null) {
				query.setString("PASSWORD", password);
			}

			if (!"".equals(role)) {
				query.setInteger("ROLE", Integer.parseInt(role));
			}
		}

		return query;
	}

	public void deleteByHouseNo(String houseNo) {
		Session session = getCurrentSession();
		Account account = (Account) session.createCriteria(Account.class).add(Restrictions.eq("username", houseNo))
				.uniqueResult();
		delete(account.getId());
	}

}
