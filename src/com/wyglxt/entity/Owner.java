package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

/**
 * 模块说明：业主
 * 
 */
public class Owner extends BaseEntity {
	private static final long serialVersionUID = -5840317287649518511L;

	private String houseNo;
	private String uuid;
	private String password;
	private String name;
	private String tel;
	private String population;// 家庭人口
	private Date enterDate;// 入住时间

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
