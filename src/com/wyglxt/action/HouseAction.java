package com.wyglxt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.House;
import com.wyglxt.service.IHouseService;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class HouseAction extends BaseAction {
	private static final long serialVersionUID = -4555048552772446336L;
	private static final Logger log = Logger.getLogger(HouseAction.class);

	private House house;
	private int currentPageNum;
	private String result;

	public String queryByNo() {
		String str = "queryByNo_resp";
		log.info("query by houseNo start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		if ("".equals(house.getHouseNo()) || house.getHouseNo() == null) {
			log.error("houseNo is null.");
			return str;
		}
		try {
			IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
			if (houseService == null) {
				log.error("get houseService failed.");
				return str;
			}
			House temp = houseService.loadByNo(house.getHouseNo());
			if (temp == null) {
				resp.put("respCode", "01");
				log.warn("house is not exist.");
				return str;
			}
			resp.put("respCode", "00");
			resp.put("house", temp);
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("resp: " + result);
			log.info("query by no end.");
		}
		return str;
	}

	public String list() {
		if (currentPageNum < 1) {
			currentPageNum = 1;
		} else if (currentPageNum > 10) {
			currentPageNum = 10;
		}
		IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
		if (houseService == null) {
			return ERROR;
		}
		List<House> houses = houseService.queryByPage(currentPageNum);
		if (houses != null) {
			request.put("houses", houses);
			request.put("currentPageNum", currentPageNum);
			return "list_success";
		}
		return ERROR;
	}

	public String delete() {
		int id = house.getId();
		IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
		if (houseService != null) {
			if (houseService.deleteRecord(House.class, id)) {
				request.put("currentPageNum", currentPageNum);
				return "delete_success";
			}
		}
		return ERROR;
	}

	public String load() {
		int id = house.getId();
		IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
		if (houseService != null) {
			House result = (House) houseService.loadRecord(House.class, id);
			if (result != null) {
				request.put("house", result);
				request.put("currentPageNum", currentPageNum);
				return "load_success";
			}
		}
		return ERROR;
	}

	public String update() {
		String str = "update_resp";
		log.info("update start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
			if (houseService == null) {
				log.error("houseService is null.");
				return str;
			}

			House house_temp = (House) houseService.loadRecord(House.class, house.getId());
			if (house_temp == null) {
				log.error(house.getHouseNo() + " is not exist.");
				resp.put("respCode", "01");
				return str;
			}

			house_temp.setArea(house.getArea());
			house_temp.setBuildDate(house.getBuildDate());
			house_temp.setDescription(house.getDescription());
			house_temp.setShape(house.getShape());
			houseService.updateRecord(house_temp);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("update end.");
		}
		return str;
	}

	public String add() {
		String str = "add_resp";
		log.info("create house start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
			if (houseService == null) {
				log.error("get houseService failed.");
				return str;
			}

			House temp = houseService.loadByNo(house.getHouseNo());
			if (temp != null) {
				resp.put("respCode", "01");
				log.warn("repeated houseNo.");
				return str;
			}

			house.setUuid(UUID.randomUUID().toString());
			houseService.createRecord(house);
			resp.put("respCode", "00");
			log.info(result);
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("create house end.");
		}
		return str;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
