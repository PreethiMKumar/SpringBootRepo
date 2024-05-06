package com.person.bean;

public class PersonBean {
	
	String personName;
	int age;
	String district;
	String state;
	String country;
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
@Override
public String toString() {
	return "country=" + this.country + " state=" + this.state
			+ "  age= " +this.age + "  personName=" +this.personName
			+"  district=" + this.district;
}
}
