package com.wyglxt.dao;

import java.util.Date;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.Price;

public class PriceDAO extends BaseDAO {

	public PriceDAO() {
		super();
		table = "Price";
	}

	@Override
	public Class<?> getModelClass() {
		return Price.class;
	}

	@Override
	protected Query getQuery(String queryType, Map<String, Object> condition) {
		return null;
	}

	public Price loadByMonth(Date month) {
		Price price = null;
		if (null == month) {
			return price;
		}
		Session session = getCurrentSession();
		if (null == session) {
			return price;
		}
		price = (Price) session.createCriteria(getModelClass()).add(Restrictions.eq("month", month)).uniqueResult();
		return price;
	}

}
