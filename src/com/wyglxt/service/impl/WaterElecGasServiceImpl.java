package com.wyglxt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.wyglxt.base.BaseServiceImpl;
import com.wyglxt.dao.WaterElecGasDAO;
import com.wyglxt.dto.WaterElecGasDTO;
import com.wyglxt.entity.WaterElecGas;
import com.wyglxt.service.IWaterElecGasService;
import com.wyglxt.util.DateUtil;

public class WaterElecGasServiceImpl extends BaseServiceImpl implements IWaterElecGasService {
	@Resource(name = "waterElecGasDAO")
	WaterElecGasDAO waterElecGasDAO;

	public WaterElecGasServiceImpl() {
		super();
	}

	@Override
	protected void buildAbilityDao() {
		if (!daoList.contains(waterElecGasDAO)) {
			daoList.add(waterElecGasDAO);
		}
	}

	@Override
	public WaterElecGas loadByMonthAndHouseNo(Date month, String houseNo) {
		WaterElecGas result = null;
		if (null == month || StringUtils.isBlank(houseNo)) {
			return result;
		}
		WaterElecGasDAO dao = (WaterElecGasDAO) findAbilityDAO(WaterElecGas.class);
		if (null == dao) {
			return result;
		}
		result = dao.loadByMonthAndHouseNo(month, houseNo);
		return result;
	}

	@Override
	public List<WaterElecGasDTO> loadForReport(String year) {
		List<WaterElecGasDTO> result = null;
		if (StringUtils.isBlank(year)) {
			return result;
		}
		Date start = DateUtil.str2Date(year + "-01-01");
		Long param = Long.parseLong(year);
		param++;
		Date end = DateUtil.str2Date(param + "-01-01");

		WaterElecGasDAO dao = (WaterElecGasDAO) findAbilityDAO(WaterElecGas.class);
		if (null == dao) {
			return result;
		}

		List<WaterElecGas> wegs = dao.findByYear(start, end);
		if (wegs.isEmpty()) {
			return result;
		}
		// build dto map
		result = new ArrayList<WaterElecGasDTO>();
		for (int i = 1; i <= 12; i++) {
			WaterElecGasDTO dto = new WaterElecGasDTO();
			if (i < 10) {
				dto.setMonth(year + "-0" + i + "-01");
				buildDTO(dto, wegs);
			} else {
				dto.setMonth(year + "-" + i + "-01");
				buildDTO(dto, wegs);
			}
			result.add(dto);
//			switch (i) {
//			case 1:
//				result.put("Jan", dto);
//				break;
//			case 2:
//				result.put("Feb", dto);
//				break;
//			case 3:
//				result.put("Mar", dto);
//				break;
//			case 4:
//				result.put("Apr", dto);
//				break;
//			case 5:
//				result.put("May", dto);
//				break;
//			case 6:
//				result.put("June", dto);
//				break;
//			case 7:
//				result.put("July", dto);
//				break;
//			case 8:
//				result.put("Aug", dto);
//				break;
//			case 9:
//				result.put("Sept", dto);
//				break;
//			case 10:
//				result.put("Oct", dto);
//				break;
//			case 11:
//				result.put("Nov", dto);
//				break;
//			case 12:
//				result.put("Dec", dto);
//				break;
//			default:
//				break;
//			}
		}

		return result;
	}

	private void buildDTO(WaterElecGasDTO dto, List<WaterElecGas> wegs) {
		if (null == dto || wegs.isEmpty()) {
			return;
		}
		Date month = DateUtil.str2Date(dto.getMonth());
		double water = 0;
		double elec = 0;
		double gas = 0;
		for (WaterElecGas weg : wegs) {
			if (month.compareTo(weg.getMonth()) == 0) {
				water += weg.getWater();
				elec += weg.getElectric();
				gas += weg.getGas();
			}
		}
		dto.setElec(elec);
		dto.setWater(water);
		dto.setGas(gas);
	}

}
