package com.wyglxt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Account;
import com.wyglxt.service.IAccountService;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class AccountAction extends BaseAction {
	private static final long serialVersionUID = -4555048552772446336L;
	private static final Logger log = Logger.getLogger(AccountAction.class);

	private Account account;
	private String newPassword;
	private String result;

	@SuppressWarnings("unchecked")
	public String add() {
		String str = "add_resp";
		if (null == account) {
			log.error("account is null.");
			return str;
		}
		log.info("add account start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
			if (null == accountService) {
				log.error("account service is null.");
				return str;
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put(AppConstants.QUERYTYPE, "queryByName");
			condition.put("name", account.getName());
			List<Account> list = (List<Account>) accountService.readRecord(Account.class, condition);
			if (!list.isEmpty() && list != null) {
				resp.put("respCode", "01");
				return str;
			}
			account.setUuid(UUID.randomUUID().toString());
			accountService.createRecord(account);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("add account end.");
		}
		return str;
	}

	public String update() {
		String str = "update_resp";
		if (null == account) {
			log.error("account is null.");
			return str;
		}
		log.info("update account(" + account.getName() + ") start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
			if (null == accountService) {
				log.error("account service is null.");
				return str;
			}
			Account temp = (Account) accountService.loadRecord(Account.class, account.getId());
			temp.setName(account.getName());
			temp.setPassword(account.getPassword());
			temp.setRole(account.getRole());
			temp.setTel(account.getTel());
			temp.setUsername(account.getUsername());
			accountService.updateRecord(temp);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("update account(" + account.getName() + ") end.");
		}
		return str;
	}

	public String load() {
		String str = ERROR;
		if (null == account) {
			return str;
		}
		IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
		if (null == accountService) {
			return str;
		}
		Account temp = (Account) accountService.loadRecord(Account.class, account.getId());
		if (null != temp) {
			request.put("account", temp);
			str = "load_success";
		}
		return str;
	}

	public String delete() {
		String str = ERROR;
		log.info("delete account start.");
		if (null == account) {
			log.error("account is null.");
			return str;
		}
		IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
		if (null == accountService) {
			log.error("account service is null.");
			return str;
		}
		if (accountService.deleteRecord(Account.class, account.getId())) {
			str = "delete_success";
		}
		log.info("delete account end.");
		return str;
	}

	@SuppressWarnings("unchecked")
	public String query() {
		String str = "query_resp";
		log.info("query(" + account.getName() + ") account start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (null == account) {
				log.error("account is null.");
				return str;
			}
			IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
			if (null == accountService) {
				log.error("service is null.");
				return str;
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put(AppConstants.QUERYTYPE, "queryByName");
			condition.put("name", account.getName());
			List<Account> list = (List<Account>) accountService.readRecord(Account.class, condition);
			Account temp = null;
			if (!list.isEmpty() && list != null) {
				temp = list.get(0);
				resp.put("account", temp);
				resp.put("respCode", "00");
			}
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("query (" + account.getName() + ") account end.");
		}
		return str;
	}

	public String alter() {
		String username = ((Account) session.get("account")).getUsername();
		String password = account.getPassword();
		String role = String.valueOf(((Account) session.get("account")).getRole());
		IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
		Account acc = accountService.login(username, password, role);
		if (acc != null) {
			acc.setPassword(newPassword);
			accountService.updateRecord(acc);
			return "alter_success";
		}
		return ERROR;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
