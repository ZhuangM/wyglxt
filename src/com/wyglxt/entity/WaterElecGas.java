package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

public class WaterElecGas extends BaseEntity {

	private static final long serialVersionUID = 5162061212691520915L;

	private String houseNo;
	private String floorId;
	private double gas;
	private double electric;
	private double water;
	private Date month;

	private House house;

	public String getHouseNo() {
		return houseNo;
	}

	public String getFloorId() {
		return floorId;
	}

	public double getGas() {
		return gas;
	}

	public double getElectric() {
		return electric;
	}

	public double getWater() {
		return water;
	}

	public Date getMonth() {
		return month;
	}

	public House getHouse() {
		return house;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public void setGas(double gas) {
		this.gas = gas;
	}

	public void setElectric(double electric) {
		this.electric = electric;
	}

	public void setWater(double water) {
		this.water = water;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}
