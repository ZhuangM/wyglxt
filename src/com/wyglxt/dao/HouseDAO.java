package com.wyglxt.dao;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.House;

public class HouseDAO extends BaseDAO {

	public HouseDAO() {
		super();
		table = "House";
	}

	@Override
	public Class<?> getModelClass() {
		return House.class;
	}

	@Override
	protected Query getQuery(String queryType, Map<String, Object> condition) {
		Query query = null;

		if (queryType == null || "".equals(queryType)) {
			return query;
		}

		if (queryType.equalsIgnoreCase(AppConstants.QUERYFORPAGE)) {
			query = queryForPage(condition);
		}

		return query;
	}

	private Query queryForPage(Map<String, Object> condition) {
		Query query = null;
		if (condition != null && !condition.isEmpty()) {
			int firstResult = (int) condition.get(AppConstants.PARAM_FIRST_RESULT);
			int maxResults = (int) condition.get(AppConstants.PARAM_MAX_RESULTS);

			Session session = getCurrentSession();
			StringBuffer sb = new StringBuffer();
			sb.append("FROM " + table + " AS record ORDER BY record.id");
			query = session.createQuery(sb.toString());
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
		}
		return query;
	}

	public House loadByNo(String houseNo) {
		House result = null;
		if ("".equals(houseNo) || houseNo == null) {
			return result;
		}
		Session session = getCurrentSession();
		result = (House) session.createCriteria(House.class).add(Restrictions.eq("houseNo", houseNo)).uniqueResult();
		return result;
	}

}
