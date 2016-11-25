package com.wyglxt.dao;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.Charge;
import com.wyglxt.entity.Demo;

public class DemoDAO extends BaseDAO {
	private static final Logger log = Logger.getLogger(DemoDAO.class);

	public DemoDAO() {
		super();
		table = "Demo";
	}

	@Override
	public Class<?> getModelClass() {
		return Demo.class;
	}

	@Override
	protected Query getQuery(String queryType, Map<String, Object> condition) {
		Query query = null;

		if (queryType == null || "".equals(queryType)) {
			log.error("queryType is null.");
			return query;
		}

		if (queryType.equalsIgnoreCase(AppConstants.QUERYFORPAGE)) {
			query = queryForPage(condition);
		}
//		else if (queryType.equalsIgnoreCase("queryByDate")) {
//			query = queryByDate(condition);
//		}

		return query;
	}

//	private Query queryByDate(Map<String, Object> condition) {
//		Query query = null;
//		if (null != condition && !condition.isEmpty()) {
//			Date shortDate = (Date) condition.get("shortDate");
//			Date longDate = (Date) condition.get("longDate");
//			int currentPageNum = (Integer.parseInt((String) condition.get("currentPageNum")));
//			int firstResult = (currentPageNum - 1) * 17;
//			int maxResult = 17;
//
//			Session session = getCurrentSession();
//			StringBuilder sb = new StringBuilder();
//			if (condition.containsKey("houseNo")) {
//				sb.append("FROM " + table
//						+ " AS record WHERE record.month>= :SHORTDATE AND record.month< :LONGDATE AND record.houseNo= :HOUSENO ORDER BY record.month");
//			} else {
//				sb.append("FROM " + table
//						+ " AS record WHERE record.month>= :SHORTDATE AND record.month< :LONGDATE ORDER BY record.month");
//			}
//
//			log.info("queryByDate(" + sb.toString() + ")");
//			query = session.createQuery(sb.toString());
//			query.setDate("SHORTDATE", shortDate);
//			query.setDate("LONGDATE", longDate);
//			if (condition.containsKey("houseNo")) {
//				query.setString("HOUSENO", (String) condition.get("houseNo"));
//			}
//			query.setFirstResult(firstResult);
//			query.setMaxResults(maxResult);
//
//		}
//		return query;
//	}
//
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

//	// load by houseNo
//	public Charge loadByHouseNo(String houseNo) {
//		Charge result = null;
//		if (houseNo.length() <= 0) {
//			return result;
//		}
//		Session session = getCurrentSession();
//		result = (Charge) session.createCriteria(Charge.class).add(Restrictions.eq("houseNo", houseNo)).uniqueResult();
//		return result;
//	}
	
}
