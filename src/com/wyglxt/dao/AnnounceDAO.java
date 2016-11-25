package com.wyglxt.dao;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.Announce;

public class AnnounceDAO extends BaseDAO {

	public AnnounceDAO() {
		super();
		table = "Announce";
	}

	@Override
	public Class<?> getModelClass() {
		return Announce.class;
	}

	@Override
	protected Query getQuery(String queryType, Map<String, Object> condition) {
		Query query = null;

		if (queryType == null || "".equals(queryType)) {
			return query;
		}

		if (queryType.equalsIgnoreCase("queryForShow")) {
			query = queryForShow(condition);
		}

		return query;
	}

	private Query queryForShow(Map<String, Object> condition) {
		Query result = null;
		if (null == condition) {
			return result;
		}
		Session session = getCurrentSession();
		StringBuilder sb = new StringBuilder();
		sb.append("FROM " + table + " AS record ORDER BY record.publishDate DESC");
		result = session.createQuery(sb.toString());
		return result;
	}

}
