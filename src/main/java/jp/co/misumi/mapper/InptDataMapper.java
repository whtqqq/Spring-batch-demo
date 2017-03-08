package jp.co.misumi.mapper;

import jp.co.misumi.model.InptData;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("inptDataMapper")
public interface InptDataMapper{

	public List<InptData> findInptData(@Param("name") String bind);
}