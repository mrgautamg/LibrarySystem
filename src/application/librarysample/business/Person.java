package application.librarysample.business;

import java.io.Serializable;

public class Person implements Serializable{
	private String firstName;
	private String lastName;
	private String phoneNo;
	private Address address;
	public Person(String firstName, String lastName, String phoneNo,
			Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public Address getAddress() {
		return address;
	}
	
	
}
