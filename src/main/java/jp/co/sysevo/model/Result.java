package jp.co.sysevo.model;

import java.util.Date;

public class Result {
	
	public String id;
	public Date updTs;
	public boolean sendFlg;


	public Result() {
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setDate(Date updTs) {
		this.updTs = updTs;
	}

	public Date getUpdTs() {
		return updTs;
	}
	
	public void setSendFlg(boolean sendFlg) {
		this.sendFlg = sendFlg;
	}

	public boolean getSendFlg() {
		return sendFlg;
	}
}