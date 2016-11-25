package com.wyglxt.service;

import java.util.List;

import com.wyglxt.base.IBaseService;
import com.wyglxt.entity.Account;
import com.wyglxt.entity.Owner;

public interface IDemoService extends IBaseService {
	
	boolean deleteByBianma(String bianma);
	
	public List<Owner> queryByPage(int currentPageNum);

}
