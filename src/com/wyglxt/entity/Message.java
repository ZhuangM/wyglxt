package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

/**
 * 模块说明： 消息通知
 * 
 */
public class Message extends BaseEntity {

	private static final long serialVersionUID = 1763896883814802324L;
	private String houseNo;
	private String title;
	private String content;
	private int isRead;
	private Date publishDate;

	private House house;

	public String getHouseNo() {
		return houseNo;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getIsRead() {
		return isRead;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public House getHouse() {
		return house;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}
