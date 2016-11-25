package com.wyglxt.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wyglxt.base.BaseDAO;
import com.wyglxt.entity.WaterElecGas;

public class WaterElecGasDAO extends BaseDAO {

	public WaterElecGasDAO() {
		super();
		table = "WaterElecGas";
	}

	@Override
	public Class<?> getModelClass() {
		return WaterElecGas.class;
	}

	@Override
	protected Query getQuery(String queryType, Map<String, Object> condition) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public WaterElecGas loadByMonthAndHouseNo(Date month, String houseNo) {
		WaterElecGas result = null;
		Session session = getCurrentSession();
		StringBuilder sb = new StringBuilder();
		sb.append("From " + table + " AS record WHERE record.month= :MONTH AND record.houseNo= :HOUSENO");
		Query query = session.createQuery(sb.toString());
		query.setDate("MONTH", month);
		query.setString("HOUSENO", houseNo);
		List<WaterElecGas> list = query.list();
		if (list.isEmpty()) {
			return result;
		}
		result = list.get(0);
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<WaterElecGas> findByYear(Date start, Date end) {
		List<WaterElecGas> result = null;
		if (null == start || null == end) {
			return result;
		}
		Session session = getCurrentSession();
		StringBuilder sb = new StringBuilder();
		sb.append("FROM " + table
				+ " AS record WHERE record.month>= :START AND record.month< :END ORDER BY record.month");
		Query query = session.createQuery(sb.toString());
		query.setDate("START", start);
		query.setDate("END", end);
		result = query.list();
		return result;
	}

}
