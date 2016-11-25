package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

public class Charge extends BaseEntity {

	private static final long serialVersionUID = -2159413781324949023L;
	private String houseNo;
	private Date month;
	private double waterCharge;
	private double electricCharge;
	private double gasCharge;
	private double wuye;
	private int status;// 1已缴0未缴
	private String paymentName; // 收费人
	private int means;// 缴纳方式1现金2网银
	private Date paymentDate;// 缴纳日期

	private House house;

	public String getHouseNo() {
		return houseNo;
	}

	public Date getMonth() {
		return month;
	}

	public double getWaterCharge() {
		return waterCharge;
	}

	public double getGasCharge() {
		return gasCharge;
	}

	public int getStatus() {
		return status;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public int getMeans() {
		return means;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public House getHouse() {
		return house;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public void setWaterCharge(double waterCharge) {
		this.waterCharge = waterCharge;
	}

	public void setGasCharge(double gasCharge) {
		this.gasCharge = gasCharge;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public void setMeans(int means) {
		this.means = means;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public double getElectricCharge() {
		return electricCharge;
	}

	public void setElectricCharge(double electricCharge) {
		this.electricCharge = electricCharge;
	}

	public double getWuye() {
		return wuye;
	}

	public void setWuye(double wuye) {
		this.wuye = wuye;
	}

}
