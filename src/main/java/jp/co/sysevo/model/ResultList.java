package jp.co.sysevo.model;

import java.util.ArrayList;
import java.util.List;

public class ResultList {
	
	private List<OutptData> list = new ArrayList<OutptData>();


	public ResultList() {
	}

	public void setList(List<OutptData> list) {
		this.list = list;
	}

	public List<OutptData> getList() {
		return list;
	}
}