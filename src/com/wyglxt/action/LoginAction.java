package com.wyglxt.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Account;
import com.wyglxt.service.IAccountService;
import com.wyglxt.util.SpringContextHolder;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = -2885181786871379903L;
	private static Logger log = Logger.getLogger(LoginAction.class);

	private String username;
	private String password;
	private String role;

	@Override
	public String execute() {
		String result = "login_error";
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(role)) {
			log.error("param is null.");
			return result;
		}
		IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
		if (null == accountService) {
			log.error("service is null.");
			return result;
		}
		Account account = accountService.login(username, password, role);
		if (null != account) {
			switch (role) {
			case "2":
				session.put("account", account);
				session.put("name", account.getName());
				return "owner_success";
			case "1":
				session.put("account", account);
				session.put("name", account.getName());
				return "admin_success";
			case "0":
				session.put("account", account);
				session.put("name", account.getName());
				return "super_admin_success";
			default:
				return result;
			}

		}
		return result;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
