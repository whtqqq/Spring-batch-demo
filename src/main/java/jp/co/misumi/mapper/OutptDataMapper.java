package jp.co.misumi.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.misumi.model.OutptData;

@Component("outptDataMapper")
public interface OutptDataMapper{

	public void updateTable(List<OutptData> list);
}