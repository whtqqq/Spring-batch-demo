package jp.co.sysevo.batch;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.batch.item.ItemReader;
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
public class EntryItemReader implements ItemReader<String>{

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return search2();
	}
	
	
	public String search2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("batch-context.xml");
		CustomerMapper mapper = (CustomerMapper)ctx.getBean("customerMapper");
		
		Customer bind = new Customer();
		bind.setId(1);
		List<Customer> students = mapper.getById(bind.getId());
		if (students != null) {
			System.out.println(students.get(0).toString());
		} else {
			System.out.println("没有找到。");
		}
		return students.get(0).toString();
	}

	public void search() {
		List<Customer> students ;
		String resource = "META-INF/configuration.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建SqlSessionFactory实例。没有指定要用到的
		// environment，则使用默认的environment
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			Customer bind = new Customer();
			bind.setId(1);
			students = mapper.getById(bind.getId());
			if (students != null) {
				System.out.println(students.get(0).toString());
			} else {
				System.out.println("没有找到。");
			}
		} finally {
			sqlSession.close();
		}
	}
		
}
