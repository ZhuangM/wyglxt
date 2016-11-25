package com.wyglxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.HouseDAO;
import com.wyglxt.entity.House;
import com.wyglxt.service.IHouseService;

public class HouseServiceImpl extends BaseServiceImpl implements IHouseService {
	@Resource(name = "houseDAO")
	HouseDAO houseDAO;

	public HouseServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(houseDAO)) {
			daoList.add(houseDAO);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<House> queryByPage(int currentPageNum) {
		List<House> result = null;
		int maxResults = 20;
		int firstResult = (currentPageNum - 1) * maxResults;
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(AppConstants.QUERYTYPE, AppConstants.QUERYFORPAGE);
		condition.put(AppConstants.PARAM_FIRST_RESULT, firstResult);
		condition.put(AppConstants.PARAM_MAX_RESULTS, maxResults);
		result = (List<House>) readRecord(House.class, condition);
		return result;
	}

	@Override
	public House loadByNo(String houseNo) {
		House result = null;
		HouseDAO houseDAO = (HouseDAO) findAbilityDAO(House.class);
		if (houseDAO == null) {
			return result;
		}
		result = houseDAO.loadByNo(houseNo);
		return result;
	}

}
