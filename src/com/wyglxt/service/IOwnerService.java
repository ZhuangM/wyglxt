package com.wyglxt.service;

import java.util.List;

import com.wyglxt.base.IBaseService;
import com.wyglxt.entity.Owner;

public interface IOwnerService extends IBaseService {
	List<Owner> queryByPage(int currentPageNum);

	Owner loadByName(String name);

	Owner loadByHouseNo(String houseNo);
}
