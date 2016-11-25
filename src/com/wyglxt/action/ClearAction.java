package com.wyglxt.action;

import com.wyglxt.base.BaseAction;

public class ClearAction extends BaseAction {
	private static final long serialVersionUID = 3581015894247745307L;

	@Override
	public String execute() {
		session.clear();
		return SUCCESS;
	}

}
