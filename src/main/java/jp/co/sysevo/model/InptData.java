package jp.co.sysevo.model;

import org.springframework.stereotype.Component;

@Component("inptData")
public class InptData {
	
	public String id;
	public String name;
	public int age;
	public String des;


	public InptData() {
	}


	public InptData(String id, String name, int age, String des) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.des = des;
	}
	
	public InptData(String name, int age, String des) {
		this.name = name;
		this.age = age;
		this.des = des;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "InptData [id=" + id + ", name=" + name + ", age=" + age
				+ ", des=" + des + "]";
	}
	
}