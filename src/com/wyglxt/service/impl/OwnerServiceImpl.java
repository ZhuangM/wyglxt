package com.wyglxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.OwnerDAO;
import com.wyglxt.entity.Owner;
import com.wyglxt.service.IOwnerService;

public class OwnerServiceImpl extends BaseServiceImpl implements IOwnerService {
	private static final Logger log = Logger.getLogger(OwnerServiceImpl.class);

	@Resource(name = "ownerDAO")
	OwnerDAO ownerDAO;

	public OwnerServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(ownerDAO)) {
			daoList.add(ownerDAO);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> queryByPage(int currentPageNum) {
		List<Owner> result = null;
		int maxResults = 20;
		int firstResult = (currentPageNum - 1) * maxResults;
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(AppConstants.QUERYTYPE, AppConstants.QUERYFORPAGE);
		condition.put(AppConstants.PARAM_FIRST_RESULT, firstResult);
		condition.put(AppConstants.PARAM_MAX_RESULTS, maxResults);
		result = (List<Owner>) readRecord(Owner.class, condition);
		return result;
	}

	@Override
	public Owner loadByName(String name) {
		Owner result = null;
		if (name.length() == 0) {
			log.error("name is null.");
			return result;
		}
		OwnerDAO ownerDAO = (OwnerDAO) findAbilityDAO(Owner.class);
		if (null == ownerDAO) {
			log.error("ownerDAO is null.");
			return result;
		}
		result = ownerDAO.loadByName(name);
		return result;
	}

	@Override
	public Owner loadByHouseNo(String houseNo) {
		Owner result = null;
		if (houseNo.length() <= 0) {
			log.error("houseNo is null.");
			return result;
		}
		OwnerDAO ownerDAO = (OwnerDAO) findAbilityDAO(Owner.class);
		if (ownerDAO == null) {
			log.error("houseDAO is null.");
			return result;
		}
		result = ownerDAO.loadByHouseNo(houseNo);
		return result;
	}

}
