package com.wyglxt.dao;

import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.Owner;

public class OwnerDAO extends BaseDAO {
	private static final Logger log = Logger.getLogger(OwnerDAO.class);

	public OwnerDAO() {
		super();
		table = "Owner";
	}

	@Override
	public Class<?> getModelClass() {
		return Owner.class;
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

	// load by houseNo
	public Owner loadByHouseNo(String houseNo) {
		Owner result = null;
		if (houseNo.length() <= 0) {
			return result;
		}
		Session session = getCurrentSession();
		result = (Owner) session.createCriteria(Owner.class).add(Restrictions.eq("houseNo", houseNo)).uniqueResult();
		return result;
	}

	// load by name
	public Owner loadByName(String name) {
		Owner result = null;
		if (name.length() <= 0) {
			log.error("name is null.");
			return result;
		}
		Session session = getCurrentSession();
		result = (Owner) session.createCriteria(Owner.class).add(Restrictions.eq("name", name)).uniqueResult();
		return result;
	}

}
