package com.wyglxt.service;

import java.util.Date;
import java.util.List;

import com.wyglxt.base.IBaseService;
import com.wyglxt.dto.WaterElecGasDTO;
import com.wyglxt.entity.WaterElecGas;

public interface IWaterElecGasService extends IBaseService {
	WaterElecGas loadByMonthAndHouseNo(Date month, String houseNo);

	List<WaterElecGasDTO> loadForReport(String year);
}
