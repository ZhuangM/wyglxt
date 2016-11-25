package com.wyglxt.entity;

import java.util.HashSet;
import java.util.Set;

import com.wyglxt.base.BaseEntity;

/**
 * 模块说明： 房屋信息
 * 
 */
public class House extends BaseEntity {

	private static final long serialVersionUID = -3874124209836061261L;
	private String houseNo;// 1#1-101
	private String uuid;
	private String description;// 主卧朝阳
	private String floorId;// 楼号
	private String cellId;// 单元号
	private String buildDate;// 建筑年代
	private String shape;// 户型
	private String area;// 面积
	private String ownerName;
	private String ownerTel;

	private Set<WaterElecGas> waterElecGas = new HashSet<WaterElecGas>();// 水电气
	private Set<Charge> charges = new HashSet<Charge>();// 收费信息
	private Set<Message> messages = new HashSet<Message>();// 消息通知

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Set<Charge> getCharges() {
		return charges;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setCharges(Set<Charge> charges) {
		this.charges = charges;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<WaterElecGas> getWaterElecGas() {
		return waterElecGas;
	}

	public void setWaterElecGas(Set<WaterElecGas> waterElecGas) {
		this.waterElecGas = waterElecGas;
	}

	public String getOwnerTel() {
		return ownerTel;
	}

	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}

	// public Set<WaterElecGas> getWaterEleGas() {
	// return waterEleGas;
	// }
	//
	// public void setWaterEleGas(Set<WaterElecGas> waterEleGas) {
	// this.waterEleGas = waterEleGas;
	// }
	//
	// public Set<Wuye> getWuyes() {
	// return wuyes;
	// }
	//
	// public void setWuyes(Set<Wuye> wuyes) {
	// this.wuyes = wuyes;
	// }
	//
	// public Set<Charge> getCharges() {
	// return charges;
	// }
	//
	// public void setCharges(Set<Charge> charges) {
	// this.charges = charges;
	// }
	//
	// public Set<Message> getMessages() {
	// return messages;
	// }
	//
	// public void setMessages(Set<Message> messages) {
	// this.messages = messages;
	// }

}
