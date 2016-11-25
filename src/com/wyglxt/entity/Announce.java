package com.wyglxt.entity;

import java.util.Date;

import com.wyglxt.base.BaseEntity;

/**
 * 模块说明： 公告
 * 
 */
public class Announce extends BaseEntity {

	private static final long serialVersionUID = -5898730036185215850L;
	private String title;
	private String content;
	private Date publishDate;

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
