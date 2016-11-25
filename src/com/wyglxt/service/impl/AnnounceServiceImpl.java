package com.wyglxt.service.impl;

import javax.annotation.Resource;

import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.AnnounceDAO;
import com.wyglxt.service.IAnnounceService;

public class AnnounceServiceImpl extends BaseServiceImpl implements IAnnounceService {
	@Resource(name = "announceDAO")
	AnnounceDAO announceDAO;

	public AnnounceServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(announceDAO)) {
			daoList.add(announceDAO);
		}
	}

}
