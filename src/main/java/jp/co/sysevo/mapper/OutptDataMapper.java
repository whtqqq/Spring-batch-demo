package jp.co.sysevo.mapper;

import org.springframework.stereotype.Component;

import jp.co.sysevo.model.ResultList;

@Component("outptDataMapper")
public interface OutptDataMapper{

	public void updateTable(ResultList list);
}