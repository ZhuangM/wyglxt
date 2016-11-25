package com.wyglxt.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wyglxt.AppConstants;
import com.wyglxt.base.BaseAction;
import com.wyglxt.entity.Announce;
import com.wyglxt.service.IAnnounceService;
import com.wyglxt.util.JsonUtil;
import com.wyglxt.util.SpringContextHolder;

public class AnnounceAction extends BaseAction {
	private static final long serialVersionUID = -678965146081126795L;
	private static final Logger log = Logger.getLogger(AnnounceAction.class);

	private Announce announce;
	private String result;

	// list
	@SuppressWarnings("unchecked")
	public String query() {
		String str = "query_resp";
		log.info("query announce start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();

			IAnnounceService announceService = (IAnnounceService) SpringContextHolder.getBean("announceService");
			if (null == announceService) {
				log.error("service is null.");
				resp.put("respCode", "01");
				return str;
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put(AppConstants.QUERYTYPE, "queryForShow");
			List<Announce> temp = (List<Announce>) announceService.readRecord(Announce.class, condition);
			if (temp.size() <= 0) {
				log.error("announce is null.");
				resp.put("respCode", "01");
				return str;
			}
			resp.put("announce", temp.get(0));
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("query announce end.");
		}
		return str;
	}

	// create
	public String create() {
		String str = "create_resp";
		log.info("create announce start.");
		Map<String, Object> resp = null;
		try {
			resp = new HashMap<String, Object>();
			if (null == announce) {
				log.error("announce is null.");
				resp.put("respCode", "01");
				return str;
			}

			IAnnounceService announceService = (IAnnounceService) SpringContextHolder.getBean("announceService");
			if (null == announceService) {
				log.error("service is null.");
				resp.put("respCode", "02");
				return str;
			}

			announce.setPublishDate(new Date());
			announceService.createRecord(announce);
			resp.put("respCode", "00");
		} finally {
			setResult(JsonUtil.Map2Json(resp));
			log.info("create announce end.");
		}
		return str;
	}

	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
