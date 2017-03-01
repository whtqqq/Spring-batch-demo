package jp.co.sysevo.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jp.co.sysevo.model.Customer;

@Component("itemProcessor")
@Scope("step")
public class EntryItemProcessor implements ItemProcessor<Customer, Customer>{
	@Override
	public Customer process(Customer item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("------------------EntryItemProcessor---------------------");
		System.out.println(item.toString());
		return item;
	}

}
