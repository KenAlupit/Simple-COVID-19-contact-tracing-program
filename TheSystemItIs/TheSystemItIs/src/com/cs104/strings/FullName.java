package com.cs104.strings;
public class FullName {
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	public FullName(){
		this.firstName = "Dummy First Name";
		this.middleName = "DummyMiddleName";
		this.lastName = "DummyLastName";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public char getMiddleInitial() {
		char middleInitial = this.middleName.charAt(0);
		return middleInitial;
	}
	
	//TODO create a method that will return the Middle Initial
}