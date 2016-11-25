package com.wyglxt.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Charge;
import com.wyglxt.entity.WaterElecGas;
import com.wyglxt.service.IChargeService;
import com.wyglxt.service.IWaterElecGasService;
import com.wyglxt.util.DateUtil;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class ChargeAction extends BaseAction {
	private static final long serialVersionUID = 7190638291624212869L;
	private static final Logger log = Logger.getLogger(Charge.class);

	private Charge charge;
	private String date;
	private String houseNo;
	private String currentPageNum;
	private String result;

	public String jiaofei() {
		String str = "jiaofei_resp";
		log.info("jiaofei start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (null == charge || StringUtils.isBlank(houseNo) || StringUtils.isBlank(date)) {
				log.error("param is null.");
				resp.put("respCode", "01");
				return str;
			}
			IChargeService chargeService = (IChargeService) SpringContextHolder.getBean("chargeService");
			if (null == chargeService) {
				log.error("service is null.");
				resp.put("respCode", "01");
				return str;
			}
			Charge temp = chargeService.loadByHouseNoAndMonth(houseNo, DateUtil.str2Date(date));
			if (null == temp) {
				log.warn("query charge error.");
				resp.put("respCode", "02");
				return str;
			}
			temp.setStatus(1);
			temp.setMeans(1);
			temp.setPaymentName(charge.getPaymentName());
			temp.setPaymentDate(new Date());
			chargeService.updateRecord(temp);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("jiaofei end.");
		}
		return str;
	}

	public String queryBill() {
		String str = "queryBill_resp";
		log.info("query bill(" + date + "&" + houseNo + ") start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (StringUtils.isBlank(houseNo) || StringUtils.isBlank(date)) {
				log.error("houseNo | date is null.");
				resp.put("respCode", "01");
				return str;
			}

			IChargeService chargeService = (IChargeService) SpringContextHolder.getBean("chargeService");
			IWaterElecGasService waterElecGasService = (IWaterElecGasService) SpringContextHolder
					.getBean("waterElecGasService");
			if (null == chargeService || null == waterElecGasService) {
				log.error("service is null.");
				resp.put("respCode", "02");
				return str;
			}

			Charge temp = chargeService.loadByHouseNoAndMonth(houseNo, DateUtil.str2Date(date));
			WaterElecGas weg = waterElecGasService.loadByMonthAndHouseNo(DateUtil.str2Date(date), houseNo);
			if (null == temp || null == weg) {
				log.info("charge | weg is null.");
				resp.put("respCode", "03");
				return str;
			}
			resp.put("charge", temp);
			resp.put("weg", weg);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("query bill(" + date + "&" + houseNo + ") end.");
		}
		return str;
	}

	@SuppressWarnings("unchecked")
	public String queryByDate() {
		log.info("query by date start.");
		String str = "queryByDate_resp";
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (!StringUtils.isNotBlank(date) || !StringUtils.isNotBlank(currentPageNum)) {
				log.error("date || currentPageNum is null.");
				resp.put("respCode", "01");
				return str;
			}

			IChargeService chargeService = (IChargeService) SpringContextHolder.getBean("chargeService");
			if (null == chargeService) {
				log.error("charge || wuye service is null.");
				resp.put("respCode", "01");
				return str;
			}

			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put(AppConstants.QUERYTYPE, "queryByDate");
			condition.put("currentPageNum", currentPageNum);
			condition.put("shortDate", DateUtil.str2Date(date));
			condition.put("longDate", DateUtil.str2Date(DateUtil.getNextMonth(date)));
			if (!StringUtils.isBlank(houseNo)) {
				condition.put("houseNo", houseNo);
			}

			List<Charge> charges = (List<Charge>) chargeService.readRecord(Charge.class, condition);
			resp.put("charges", charges);
			if (charges.size() > 0) {
				resp.put("respCode", "00");
			} else {
				resp.put("respCode", "01");
			}
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("query by date end.");
		}
		return str;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(String currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

}
