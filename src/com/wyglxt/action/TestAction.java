package com.wyglxt.action;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.House;
import com.wyglxt.entity.Owner;
import com.wyglxt.service.IHouseService;
import com.wyglxt.service.IOwnerService;
import com.wyglxt.util.SpringContextHolder;

public class TestAction extends BaseAction {
	private static final long serialVersionUID = -418376507444288183L;
	private static final Logger log = Logger.getLogger(TestAction.class);

	public void test() {
		log.info("start test...");
		IHouseService houseService = (IHouseService) SpringContextHolder.getBean("houseService");
		IOwnerService ownerService = (IOwnerService) SpringContextHolder.getBean("ownerService");
		// houseService.deleteRecord(House.class, 1);
		House house = new House();
		house.setArea("120㎡");
		house.setBuildDate("2010年");
		house.setCellId("1单元");
		house.setDescription("主卧朝阳");
		house.setFloorId("1栋");
		house.setHouseNo("1#101");
		house.setUuid(UUID.randomUUID().toString());
		house.setShape("两室一厅一厨一卫");
		house.setOwnerName("诸葛亮");
		Owner owner = new Owner();
		owner.setUuid(UUID.randomUUID().toString());
		owner.setEnterDate(new Date());
		owner.setHouseNo("1#101");
		owner.setName("诸葛亮");
		owner.setPassword("123456");
		owner.setPopulation("5");
		owner.setTel("13888888888");
		ownerService.createRecord(owner);
		houseService.createRecord(house);
		log.info("end test");
	}
}
