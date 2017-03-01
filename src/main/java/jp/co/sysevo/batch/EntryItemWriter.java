package jp.co.sysevo.batch;


import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemWiter")
@Scope("step")
public class EntryItemWriter implements ItemWriter<String> {

 @Override
 public void write(List<? extends String> test) throws Exception {
     System.out.println(test);
 }

}