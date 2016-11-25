package com.wyglxt.service;

import java.util.List;

import com.wyglxt.base.IBaseService;
import com.wyglxt.entity.House;

public interface IHouseService extends IBaseService {
	List<House> queryByPage(int currentPageNum);

	House loadByNo(String houseNo);
}
