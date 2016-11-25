package com.wyglxt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.dto.WaterElecGasDTO;
import com.wyglxt.entity.Charge;
import com.wyglxt.entity.House;
import com.wyglxt.entity.Price;
import com.wyglxt.entity.WaterElecGas;
import com.wyglxt.service.IChargeService;
import com.wyglxt.service.IHouseService;
import com.wyglxt.service.IPriceService;
import com.wyglxt.service.IWaterElecGasService;
import com.wyglxt.util.DateUtil;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class WaterElecGasAction extends BaseAction {
	private static final long serialVersionUID = -8890173403083374413L;
	private static final Logger log = Logger.getLogger(WaterElecGasAction.class);

	private WaterElecGas waterElecGas;
	private String result;
	private String date;

	// query
	public String query() {
		String str = "query_resp";
		log.info("query waterElecGas(" + date + ") start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (null == waterElecGas || null == date) {
				log.error("param is null.");
				return str;
			}
			IWaterElecGasService waterElecGasService = (IWaterElecGasService) SpringContextHolder
					.getBean("waterElecGasService");
			if (null == waterElecGasService) {
				log.error("service is null.");
				return str;
			}
			WaterElecGas temp = waterElecGasService.loadByMonthAndHouseNo(DateUtil.str2Date(date),
					waterElecGas.getHouseNo());
			if (null == temp) {
				log.warn("result is null.");
				return str;
			}
			resp.put("weg", temp);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("query waterElecGas(" + date + ") end.");
		}
		return str;
	}

	// create
	public String create() {
		String str = "create_resp";
		log.info("create waterElecGas(" + date + ") start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (null == waterElecGas || StringUtils.isBlank(date)) {
				log.error("date or waterElecGas is null.");
				return str;
			}
			waterElecGas.setMonth(DateUtil.str2Date(date));
			String floorId = waterElecGas.getHouseNo().substring(0, 1);
			waterElecGas.setFloorId(floorId);

			IChargeService chargeService = (IChargeService) SpringContextHolder.getBean("chargeService");
			IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
			IPriceService priceService = (IPriceService) SpringContextHolder.getBean("priceService");
			IWaterElecGasService waterElecGasService = (IWaterElecGasService) SpringContextHolder
					.getBean("waterElecGasService");
			if (null == chargeService || null == houseService || null == priceService || null == waterElecGasService) {
				log.error("service is null.");
				return str;
			}

			House house = houseService.loadByNo(waterElecGas.getHouseNo());
			if (null == house) {
				resp.put("respCode", "01");
				log.error("house(" + waterElecGas.getHouseNo() + ") is not exist.");
				return str;
			}

			Price price = priceService.loadByMonth(waterElecGas.getMonth());
			if (null == price) {
				resp.put("respCode", "02");
				log.error("price(" + date + ") is not exist.");
				return str;
			}

			WaterElecGas temp = waterElecGasService.loadByMonthAndHouseNo(waterElecGas.getMonth(),
					waterElecGas.getHouseNo());
			if (null != temp) {
				resp.put("respCode", "03");
				log.error("waterElecGas is exist.");
				return str;
			}

			waterElecGasService.createRecord(waterElecGas);
			Charge charge = new Charge();
			charge.setHouseNo(waterElecGas.getHouseNo());
			charge.setMonth(waterElecGas.getMonth());
			charge.setStatus(0);
			double waterPrice = price.getWaterPrice() * waterElecGas.getWater();
			charge.setWaterCharge(Double.parseDouble(String.format("%.2f", waterPrice)));
			double elecPrice = price.getElectricPrice() * waterElecGas.getElectric();
			charge.setElectricCharge(Double.parseDouble(String.format("%.2f", elecPrice)));
			double gasPrice = price.getGasPrice() * waterElecGas.getGas();
			charge.setGasCharge(Double.parseDouble(String.format("%.2f", gasPrice)));
			double wuyePrice = price.getWuyePrice() * Double.parseDouble(house.getArea());
			charge.setWuye(Double.parseDouble(String.format("%.2f", wuyePrice)));
			chargeService.createRecord(charge);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("create waterElecGas(" + date + ") end.");
		}
		return str;
	}

	// report
	public String report() {
		String str = "report_resp";
		log.info("report(year=" + date + ") start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (StringUtils.isBlank(date)) {
				log.error("date is null.");
				resp.put("respCode", "01");
				return str;
			}

			IWaterElecGasService waterElecGasService = (IWaterElecGasService) SpringContextHolder
					.getBean("waterElecGasService");
			if (null == waterElecGasService) {
				log.error("service is null.");
				resp.put("respCode", "02");
				return str;
			}

			List<WaterElecGasDTO> dtos = waterElecGasService.loadForReport(date);
			resp.put("dtos", dtos);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("report(year=" + date + ") end.");
		}
		return str;
	}

	public WaterElecGas getWaterElecGas() {
		return waterElecGas;
	}

	public void setWaterElecGas(WaterElecGas waterElecGas) {
		this.waterElecGas = waterElecGas;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
