package com.wyglxt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Account;
import com.wyglxt.entity.Demo;
import com.wyglxt.entity.House;
import com.wyglxt.entity.Owner;
import com.wyglxt.service.IAccountService;
import com.wyglxt.service.IDemoService;
import com.wyglxt.service.IHouseService;
import com.wyglxt.service.IOwnerService;
import com.wyglxt.util.DateUtil;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class DemoAction extends BaseAction {
	private static final long serialVersionUID = -4036412526678781546L;
	private static final Logger log = Logger.getLogger(DemoAction.class);

	private Demo demo;
	private int currentPageNum;
	private String enterDate;
	private String result;

	// query all records
	public String list() {
		log.info("list demo(currentPageNum = " + currentPageNum + ") start.");
		if (currentPageNum < 1) {
			currentPageNum = 1;
		} else if (currentPageNum > 10) {
			currentPageNum = 10;
		}
		IDemoService demoService = (IDemoService) SpringContextHolder.getBean("demoService");
		if (null == demoService) {
			log.error("demoService is null.");
			return ERROR;
		}
		List<Owner> demos = demoService.queryByPage(currentPageNum);
		if (demos != null) {
			request.put("demos", demos);
			request.put("currentPageNum", currentPageNum);
			log.info("list demo end.");
			return "list_success";
		}
		log.error("demo is null.");
		return ERROR;
	}

	// load by id
	public String load() {
		log.info("load owner(id = " + demo.getId() + ") start.");
		IDemoService demoService = (IDemoService) SpringContextHolder.getBean("demoService");
		if (demoService == null) {
			log.error("ownerService is null.");
			return ERROR;
		}
		Demo temp = (Demo) demoService.loadRecord(Demo.class, demo.getId());
		if (temp != null) {
			request.put("owner", temp);
			request.put("currentPageNum", currentPageNum);
			log.info("load demo end.");
			return "load_success";
		}
		log.error("load owner is null.");
		return ERROR;
	}

	//
	// delete by id
	public String delete() {
		log.info("delete owner(id = " + demo.getId() + ") start.");
		IDemoService demoService = (IDemoService) SpringContextHolder.getBean("demoService");
		if (demoService == null) {
			return ERROR;
		}
		Demo temp = (Demo) demoService.loadRecord(Demo.class, demo.getId());
		if (temp != null) {
			boolean isSuccess = demoService.deleteRecord(Demo.class, demo.getId());
			if (isSuccess == true) {
				log.info("delete owner end.");
				return "delete_success";
			}
		}
		log.error("delete owner failed.");
		return ERROR;
	}

	// create record
	public String add() {
		String str = "add_resp";
		log.info("create demo(name = " + demo.getMingcheng() + ") start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			IDemoService demoService = (IDemoService) SpringContextHolder.getBean("demoService");
			if (demoService == null) {
				log.error("demo service is null.");
				resp.put("respCode", "9999");
				return str;
			}

			// create owner
			demo.setQiyong(DateUtil.str2Date(enterDate));
			demoService.createRecord(demo);

			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("create demo end.");
		}
		return str;
	}
	//
	// // update record
	// public String update() {
	// String str = "update_resp";
	// log.info("update owner(id = " + owner.getId() + ") start.");
	// Map<String, Object> resp = new HashMap<String, Object>();
	// try {
	// if (enterDate.length() <= 0) {
	// log.info("enter date is null.");
	// return str;
	// }
	//
	// IOwnerService ownerService = (IOwnerService)
	// SpringContextHolder.getBean("ownerService");
	// IHouseService houseService = (IHouseService)
	// SpringContextHolder.getBean("houseService");
	// if (ownerService == null || houseService == null) {
	// log.error("owner || house service is null.");
	// return str;
	// }
	//
	// House house = houseService.loadByNo(owner.getHouseNo());
	// if (house == null) {
	// log.error("house no is not exist.");
	// resp.put("respCode", "02");
	// return str;
	// }
	//
	// Owner temp = (Owner) ownerService.loadRecord(Owner.class, owner.getId());
	// if (temp != null) {
	// // update owner
	// temp.setEnterDate(DateUtil.str2Date(enterDate));
	// temp.setHouseNo(owner.getHouseNo());
	// temp.setPopulation(owner.getPopulation());
	// temp.setTel(owner.getTel());
	// ownerService.updateRecord(temp);
	// // update house
	// house.setOwnerName(temp.getName());
	// house.setOwnerTel(temp.getTel());
	// houseService.updateRecord(house);
	// resp.put("respCode", "00");
	// } else {
	// resp.put("respCode", "01");
	// log.warn("owner(id = " + owner.getId() + ") is not exist.");
	// }
	// } finally {
	// setResult(JsonUtil.Map2Json(resp));
	// log.info("update end.");
	// }
	// return str;
	// }
	//

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

}
