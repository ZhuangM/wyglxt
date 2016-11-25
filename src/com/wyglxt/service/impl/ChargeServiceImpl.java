package com.wyglxt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.ChargeDAO;
import com.wyglxt.entity.Charge;
import com.wyglxt.service.IChargeService;

public class ChargeServiceImpl extends BaseServiceImpl implements IChargeService {
	private static final Logger log = Logger.getLogger(ChargeServiceImpl.class);

	@Resource(name = "chargeDAO")
	ChargeDAO chargeDAO;

	public ChargeServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(chargeDAO)) {
			daoList.add(chargeDAO);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Charge> queryByPage(int currentPageNum) {
		List<Charge> result = null;
		int maxResults = 20;
		int firstResult = (currentPageNum - 1) * maxResults;
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(AppConstants.QUERYTYPE, AppConstants.QUERYFORPAGE);
		condition.put(AppConstants.PARAM_FIRST_RESULT, firstResult);
		condition.put(AppConstants.PARAM_MAX_RESULTS, maxResults);
		result = (List<Charge>) readRecord(Charge.class, condition);
		return result;
	}

	@Override
	public Charge loadByHouseNo(String houseNo) {
		Charge result = null;
		if (houseNo.length() <= 0) {
			log.error("houseNo is null.");
			return result;
		}
		ChargeDAO chargeDAO = (ChargeDAO) findAbilityDAO(Charge.class);
		if (chargeDAO == null) {
			log.error("chargeDAO is null.");
			return result;
		}
		result = chargeDAO.loadByHouseNo(houseNo);
		return result;
	}

	@Override
	public Charge loadByHouseNoAndMonth(String houseNo, Date month) {
		Charge result = null;
		if (StringUtils.isBlank(houseNo) || null == month) {
			return result;
		}
		ChargeDAO chargeDAO = (ChargeDAO) findAbilityDAO(Charge.class);
		if (null == chargeDAO) {
			log.error("chargeDAO is null.");
			return result;
		}
		result = chargeDAO.loadByHouseNoAndMonth(houseNo, month);
		return result;
	}

}
