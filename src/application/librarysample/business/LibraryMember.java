package application.librarysample.business;

import java.io.Serializable;
import java.time.LocalDate;

public class LibraryMember implements Serializable {
	//private String name;
	private String memberId;
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNo;
	
	private CheckoutRecord record = new CheckoutRecord();
	
	public LibraryMember(String memberId, String firstName, String lastName,
			Address address, String phoneNo) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public void checkout(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		
	}
	
	public String toString() {
		return "Checkout record for library member " + firstName + ": " + record;
	}
	
	private static final long serialVersionUID = -2226197306790714013L;
	
	public String getMemberId() {
		return memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public CheckoutRecord getRecord() {
		return record;
	}
}
