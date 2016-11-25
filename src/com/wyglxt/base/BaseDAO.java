package com.wyglxt.base;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 模块说明： DAO基类
 * 
 */
public abstract class BaseDAO {
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	protected String table;

	protected Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public abstract Class<?> getModelClass();

	protected abstract Query getQuery(String queryType, Map<String, Object> condition);

	// create object
	public Object create(Object record) {
		Session session = getCurrentSession();

		session.save(record);
		session.flush();
		session.refresh(record);

		return record;
	}

	// update object
	public Object update(Object record) {
		Session session = getCurrentSession();

		session.update(record);
		session.flush();
		session.refresh(record);

		return record;
	}

	// evict object from cache
	public void evict(Object record) {
		Session session = getCurrentSession();

		session.evict(record);
	}

	// merge object (insert or update)
	public Object merge(Object record) {
		Session session = getCurrentSession();

		session.merge(record);

		return record;
	}

	// get object by id
	public Object get(final int id) {
		Object result = null;

		Session session = getCurrentSession();
		Class<?> clazz = getModelClass();
		if (clazz != null) {
			try {
				result = session.get(clazz, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}

		return result;
	}

	// load object by id
	public Object load(final int id) {
		Object result = null;

		Session session = getCurrentSession();
		Class<?> clazz = getModelClass();
		if (clazz != null) {
			try {
				result = session.load(clazz, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}

		return result;
	}

	// select object by id
	public Object select(int id) {
		StringBuffer sb = new StringBuffer();
		Query query = null;
		Session session = getCurrentSession();

		sb.append("FROM ");
		sb.append(table);
		sb.append(" AS record");
		sb.append(" WHERE record.id = :ID");
		query = session.createQuery(sb.toString());
		query.setInteger("ID", id);
		query.setCacheMode(CacheMode.REFRESH);

		return query.uniqueResult();
	}

	// find
	public List<?> find(String queryType, Map<String, Object> condition) {
		Query query = null;
		List<?> list = null;

		query = getQuery(queryType, condition);
		if (query != null) {
			list = query.list();
		}

		return list;
	}

	// delete object by id
	public Boolean delete(int id) {
		Boolean result = false;
		Session session = getCurrentSession();
		Class<?> clazz = getModelClass();

		try {
			session.delete(session.load(clazz, id));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// query count
	public int getTotal() {
		StringBuffer sb = new StringBuffer();
		Query query = null;
		Session session = getCurrentSession();

		sb.append("select count(*) ");
		sb.append("from ");
		sb.append(table);
		sb.append(" as record");

		query = session.createQuery(sb.toString());
		return (int) query.uniqueResult();
	}

	// query all objects
	public List<?> getALL() {
		StringBuffer sb = new StringBuffer();
		Query query = null;
		Session session = getCurrentSession();

		sb.append("from ");
		sb.append(table);
		sb.append(" as record");

		query = session.createQuery(sb.toString());
		return query.list();
	}
}
