package jp.co.sysevo.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemProcessor")
@Scope("step")
public class EntryItemProcessor implements ItemProcessor<String, String>{
	@Override
	public String process(String item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
