package com.wyglxt.service;

import com.wyglxt.base.IBaseService;
import com.wyglxt.entity.Account;

public interface IAccountService extends IBaseService {

	Account login(String username, String password, String role);
	
	boolean deleteByHouseNo(String houseNo);

}
