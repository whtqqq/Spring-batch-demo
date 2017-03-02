package jp.co.sysevo.mapper;

import jp.co.sysevo.model.InptData;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("inptDataMapper")
public interface InptDataMapper{

	public List<InptData> findInptData(@Param("name") String bind);
}