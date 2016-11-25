package com.wyglxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.AccountDAO;
import com.wyglxt.entity.Account;
import com.wyglxt.service.IAccountService;

public class AccountServiceImpl extends BaseServiceImpl implements IAccountService {
	private static final Logger log = Logger.getLogger(AccountServiceImpl.class);

	@Resource(name = "accountDAO")
	AccountDAO accountDAO;

	public AccountServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(accountDAO)) {
			daoList.add(accountDAO);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account login(String username, String password, String role) {
		Account result = null;
		if (username.length() == 0 || password.length() == 0 || role.length() == 0) {
			return result;
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put(AppConstants.QUERYTYPE, "queryForLogin");
		condition.put("username", username);
		condition.put("password", password);
		condition.put("role", role);
		List<Account> list = (List<Account>) accountDAO.find("queryForLogin", condition);
		if (list.size() == 1) {
			result = list.get(0);
		}
		return result;
	}

	@Override
	public boolean deleteByHouseNo(String houseNo) {
		boolean result = false;
		log.info("delete by houseno start.");
		if (StringUtils.isBlank(houseNo)) {
			log.error("houseNo is null.");
			return result;
		}
		AccountDAO ad = (AccountDAO) findAbilityDAO(Account.class);
		if (null == ad) {
			log.error("account dao is null.");
			return result;
		}
		ad.deleteByHouseNo(houseNo);
		log.info("delete by houseno end.");
		return result;
	}

}
