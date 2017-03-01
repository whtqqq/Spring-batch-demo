package jp.co.sysevo.mapper;

import jp.co.sysevo.model.Customer;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("customerMapper")
public interface CustomerMapper{

	public List<Customer> getById(@Param("id") int bind);
}