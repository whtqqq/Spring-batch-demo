package jp.co.sysevo.batch;


import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jp.co.sysevo.mapper.OutptDataMapper;
import jp.co.sysevo.model.OutptData;
import jp.co.sysevo.model.ResultList;

@Component("updateWiter")
@Scope("step")
public class UpdateItemWriter implements ItemWriter<OutptData> {

	private static ApplicationContext applicationContext;
	private static OutptDataMapper mapper;
	
	static {
		applicationContext = new ClassPathXmlApplicationContext("batch-context.xml");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends OutptData> items) throws Exception {
		System.out.println("------------------ResultItemProcessor---------------------");
		ResultList resultL = new ResultList();
		resultL.setList((List<OutptData>)items);
		for (OutptData item : items) {
			System.out.println(item.toString());
		}
		
		applicationContext.getBean(OutptDataMapper.class);
		
		mapper.updateTable(resultL);
	}
}