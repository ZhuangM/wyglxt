package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

public class Demo extends BaseEntity {

	private static final long serialVersionUID = 3625148857543291638L;
	private String bianma;
	private String mingcheng;
	private String zerenren;
	private String yuanzhi;
	private Date qiyong;
	private String nianxian;

	public String getBianma() {
		return bianma;
	}

	public void setBianma(String bianma) {
		this.bianma = bianma;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}

	public String getYuanzhi() {
		return yuanzhi;
	}

	public void setYuanzhi(String yuanzhi) {
		this.yuanzhi = yuanzhi;
	}

	public Date getQiyong() {
		return qiyong;
	}

	public void setQiyong(Date qiyong) {
		this.qiyong = qiyong;
	}

	public String getNianxian() {
		return nianxian;
	}

	public void setNianxian(String nianxian) {
		this.nianxian = nianxian;
	}

}
