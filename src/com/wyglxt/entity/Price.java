package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

public class Price extends BaseEntity {

	private static final long serialVersionUID = -1303039888823772151L;

	private Date month;
	private double waterPrice;// 水价（元/吨）
	private double electricPrice;// 电价(元/度)
	private double gasPrice;// 燃气价(元/m3)
	private double wuyePrice;// 物业费（元/m2.月）

	public Date getMonth() {
		return month;
	}

	public double getWaterPrice() {
		return waterPrice;
	}

	public double getElectricPrice() {
		return electricPrice;
	}

	public double getGasPrice() {
		return gasPrice;
	}

	public double getWuyePrice() {
		return wuyePrice;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public void setWaterPrice(double waterPrice) {
		this.waterPrice = waterPrice;
	}

	public void setElectricPrice(double electricPrice) {
		this.electricPrice = electricPrice;
	}

	public void setGasPrice(double gasPrice) {
		this.gasPrice = gasPrice;
	}

	public void setWuyePrice(double wuyePrice) {
		this.wuyePrice = wuyePrice;
	}

}
