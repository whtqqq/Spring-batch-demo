package jp.co.sysevo.batch;


import java.util.List;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jp.co.sysevo.model.Customer;

@Component("itemWiter")
@Scope("step")
public class EntryItemWriter extends MyBatisBatchItemWriter<Customer> {

	@Override
	public void write(List<? extends Customer> items) {
		System.out.println("------------------EntryItemWriter---------------------");
		for (Customer item : items) {
			System.out.println(item.toString());
		}
		
	}

}