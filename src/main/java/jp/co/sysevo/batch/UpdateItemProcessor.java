package jp.co.sysevo.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jp.co.sysevo.model.OutptData;

@Component("updateProcessor")
@Scope("step")
public class UpdateItemProcessor implements ItemProcessor<OutptData, OutptData>{
	@Override
	public OutptData process(OutptData item) throws Exception {
		System.out.println("------------------ResultItemProcessor---------------------");
		System.out.println(item.toString());
		return item;
	}
}
