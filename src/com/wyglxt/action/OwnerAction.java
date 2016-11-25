package com.wyglxt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Account;
import com.wyglxt.entity.House;
import com.wyglxt.entity.Owner;
import com.wyglxt.service.IAccountService;
import com.wyglxt.service.IHouseService;
import com.wyglxt.service.IOwnerService;
import com.wyglxt.util.DateUtil;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class OwnerAction extends BaseAction {
	private static final long serialVersionUID = -4036412526678781546L;
	private static final Logger log = Logger.getLogger(OwnerAction.class);

	private Owner owner;
	private int currentPageNum;
	private String enterDate;
	private String result;

	// query by name
	public String queryByName() {
		String str = "queryByName_resp";
		if (null == owner.getName() || "".equals(owner.getName())) {
			log.error("name is null.");
			return str;
		}

		log.info("query owner by name(" + owner.getName() + ") start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
			if (null == ownerService) {
				log.error("owner service is null.");
				return str;
			}
			Owner temp = ownerService.loadByName(owner.getName());
			if (null != temp) {
				resp.put("respCode", "00");
				resp.put("owner", temp);
				setEnterDate(DateUtil.date2Str(temp.getEnterDate()));
				resp.put("enterDate", enterDate);
				return str;
			}
			log.warn("owner(name=" + owner.getName() + ") is not exist.");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("query owner by name(" + owner.getName() + ") end.");
		}
		return str;
	}

	// create record
	public String add() {
		String str = "add_resp";
		log.info("create owner(name = " + owner.getName() + ") start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
			IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
			IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
			if (ownerService == null || houseService == null || accountService == null) {
				log.error("owner || house service is null.");
				resp.put("respCode", "9999");
				return str;
			}
			Owner temp_name = ownerService.loadByName(owner.getName());
			if (temp_name != null) {
				log.error("业主名已经存在.");
				resp.put("respCode", "01");
				return str;
			}
			House house = houseService.loadByNo(owner.getHouseNo());
			if (house == null) {
				log.error("house is not exist.");
				resp.put("respCode", "02");
				return str;
			}
			Owner temp_house = ownerService.loadByHouseNo(owner.getHouseNo());
			if (temp_house != null) {
				log.error(temp_house.getHouseNo() + "已被入住.");
				resp.put("respCode", "03");
				return str;
			}
			// create owner
			owner.setEnterDate(DateUtil.str2Date(enterDate));
			owner.setUuid(String.valueOf(UUID.randomUUID()));
			owner.setPassword("123456");
			ownerService.createRecord(owner);
			// for login
			Account account = new Account();
			account.setName(owner.getName());
			account.setRole(2);
			account.setTel(owner.getTel());
			account.setUsername(owner.getHouseNo());
			account.setPassword("123456");
			account.setUuid(UUID.randomUUID().toString());
			accountService.createRecord(account);
			// update house
			house.setOwnerName(owner.getName());
			house.setOwnerTel(owner.getTel());
			houseService.updateRecord(house);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("create owner end.");
		}
		return str;
	}

	// update record
	public String update() {
		String str = "update_resp";
		log.info("update owner(id = " + owner.getId() + ") start.");
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			if (enterDate.length() <= 0) {
				log.info("enter date is null.");
				return str;
			}

			IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
			IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
			if (ownerService == null || houseService == null) {
				log.error("owner || house service is null.");
				return str;
			}

			House house = houseService.loadByNo(owner.getHouseNo());
			if (house == null) {
				log.error("house no is not exist.");
				resp.put("respCode", "02");
				return str;
			}

			Owner temp = (Owner) ownerService.loadRecord(Owner.class, owner.getId());
			if (temp != null) {
				// update owner
				temp.setEnterDate(DateUtil.str2Date(enterDate));
				temp.setHouseNo(owner.getHouseNo());
				temp.setPopulation(owner.getPopulation());
				temp.setTel(owner.getTel());
				ownerService.updateRecord(temp);
				// update house
				house.setOwnerName(temp.getName());
				house.setOwnerTel(temp.getTel());
				houseService.updateRecord(house);
				resp.put("respCode", "00");
			} else {
				resp.put("respCode", "01");
				log.warn("owner(id = " + owner.getId() + ") is not exist.");
			}
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("update end.");
		}
		return str;
	}

	// load by id
	public String load() {
		log.info("load owner(id = " + owner.getId() + ") start.");
		IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
		if (ownerService == null) {
			log.error("ownerService is null.");
			return ERROR;
		}
		Owner temp = (Owner) ownerService.loadRecord(Owner.class, owner.getId());
		if (temp != null) {
			request.put("owner", temp);
			request.put("currentPageNum", currentPageNum);
			log.info("load owner end.");
			return "load_success";
		}
		log.error("load owner is null.");
		return ERROR;
	}

	// delete by id
	public String delete() {
		log.info("delete owner(id = " + owner.getId() + ") start.");
		IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
		IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
		IAccountService accountService = (IAccountService) SpringContextHolder.getBean("accountService");
		if (ownerService == null || houseService == null || accountService == null) {
			log.error("owner || house service is null.");
			return ERROR;
		}
		Owner temp = (Owner) ownerService.loadRecord(Owner.class, owner.getId());
		if (temp != null) {
			House house = houseService.loadByNo(temp.getHouseNo());
			if (house != null) {
				house.setOwnerName("");
				house.setOwnerTel("");
				houseService.updateRecord(house);
			}
			// delete for login
			accountService.deleteByHouseNo(temp.getHouseNo());
			boolean isSuccess = ownerService.deleteRecord(Owner.class, owner.getId());
			if (isSuccess == true) {
				log.info("delete owner end.");
				return "delete_success";
			}
		}
		log.error("delete owner failed.");
		return ERROR;
	}

	// query all records
	public String list() {
		log.info("list owner(currentPageNum = " + currentPageNum + ") start.");
		if (currentPageNum < 1) {
			currentPageNum = 1;
		} else if (currentPageNum > 10) {
			currentPageNum = 10;
		}
		IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
		if (ownerService == null) {
			log.error("ownerService is null.");
			return ERROR;
		}
		List<Owner> owners = ownerService.queryByPage(currentPageNum);
		if (owners != null) {
			request.put("owners", owners);
			request.put("currentPageNum", currentPageNum);
			log.info("list owner end.");
			return "list_success";
		}
		log.error("owners is null.");
		return ERROR;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

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

}
