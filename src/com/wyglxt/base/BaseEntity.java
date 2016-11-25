package com.wyglxt.base;

import java.io.Serializable;

/**
 * 模块说明：entity基类
 * 
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1191329513105553498L;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
