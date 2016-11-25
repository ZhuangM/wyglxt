package com.wyglxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.DemoDAO;
import com.wyglxt.dao.OwnerDAO;
import com.wyglxt.entity.Demo;
import com.wyglxt.entity.Owner;
import com.wyglxt.service.IDemoService;
import com.wyglxt.service.IOwnerService;

public class DemoServiceImpl extends BaseServiceImpl implements IDemoService {
	private static final Logger log = Logger.getLogger(DemoServiceImpl.class);

	@Resource(name = "demoDAO")
	DemoDAO demoDAO;

	public DemoServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(demoDAO)) {
			daoList.add(demoDAO);
		}
	}

	@Override
	public boolean deleteByBianma(String bianma) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Owner> queryByPage(int currentPageNum) {
		List<Owner> result = null;
		int maxResults = 20;
		int firstResult = (currentPageNum - 1) * maxResults;
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(AppConstants.QUERYTYPE, AppConstants.QUERYFORPAGE);
		condition.put(AppConstants.PARAM_FIRST_RESULT, firstResult);
		condition.put(AppConstants.PARAM_MAX_RESULTS, maxResults);
		result = (List<Owner>) readRecord(Demo.class, condition);
		return result;
	}

}
