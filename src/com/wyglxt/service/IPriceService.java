package com.wyglxt.service;

import java.util.Date;

import com.wyglxt.base.IBaseService;
import com.wyglxt.entity.Price;

public interface IPriceService extends IBaseService {
	public Price loadByMonth(Date month);
}
