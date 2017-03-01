package jp.co.sysevo.batch;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jp.co.sysevo.mapper.CustomerMapper;
import jp.co.sysevo.model.Customer;

@Component("itemReader")
@Scope("step")
public class EntryItemReader extends MyBatisPagingItemReader<List<Customer>>{

	@Override
	public List<Customer> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		return search2();
	}
	
	
	public List<Customer> search2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("batch-context.xml");
		CustomerMapper mapper = (CustomerMapper)ctx.getBean("customerMapper");
		
		Customer bind = new Customer();
		bind.setName("han%");
		List<Customer> students = mapper.findCustomers(bind.getName());
		if (students != null) {
			System.out.println(students.toString());
		} else {
			System.out.println("没有找到。");
		}
		return students;
	}
	
	public Customer search() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("batch-context.xml");
		CustomerMapper mapper = (CustomerMapper)ctx.getBean("customerMapper");
		
		Customer bind = new Customer();
		bind.setId(1);
		Customer student = mapper.getById(bind.getId());
		if (student != null) {
			System.out.println(student.toString());
		} else {
			System.out.println("没有找到。");
		}
		return student;
	}
		
}
