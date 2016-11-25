package com.wyglxt.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Price;
import com.wyglxt.service.IPriceService;
import com.wyglxt.util.DateUtil;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class PriceAction extends BaseAction {
	private static final long serialVersionUID = -1894314147080906217L;
	private static final Logger log = Logger.getLogger(PriceAction.class);

	private Price price;
	private String date;
	private String result;

	public String query() {
		String str = "query_resp";
		log.info("price query start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (StringUtils.isBlank(date)) {
				log.error("date is null.");
				return str;
			}
			IPriceService priceService = (IPriceService) SpringContextHolder.getBean("priceService");
			if (null == priceService) {
				log.error("price service is null.");
				resp.put("respCode", "01");
				return str;
			}
			price = priceService.loadByMonth(DateUtil.str2Date(date));
			if (null == price) {
				log.warn("result is null.");
				return str;
			}
			resp.put("price", price);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("price query end.");
		}
		return str;
	}

	public String create() {
		String str = "create_resp";
		log.info("price create start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();

			IPriceService priceService = (IPriceService) SpringContextHolder.getBean("priceService");
			if (null == priceService) {
				log.error("price service is null.");
				resp.put("respCode", "01");
				return str;
			}

			if (null == price) {
				log.error("price is null.");
				resp.put("respCode", "01");
				return str;
			}

			price.setMonth(DateUtil.str2Date(date));

			Price temp = priceService.loadByMonth(price.getMonth());
			if (null != temp) {
				log.error("price(" + price.getMonth() + ") is exist.");
				resp.put("respCode", "02");
				return str;
			}

			priceService.createRecord(price);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("price create end.");
		}
		return str;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
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
}
