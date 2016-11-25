package com.wyglxt.service;

import java.util.Date;
import java.util.List;

import com.wyglxt.base.IBaseService;
import com.wyglxt.entity.Charge;

public interface IChargeService extends IBaseService {
	List<Charge> queryByPage(int currentPageNum);

	Charge loadByHouseNo(String houseNo);

	Charge loadByHouseNoAndMonth(String houseNo, Date month);
}
