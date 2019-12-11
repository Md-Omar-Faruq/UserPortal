package com.userportal.model;

public class User {

	private static int id;
	private static String firstName;
	private static String lastName;
	private static String address;
	private static String phone;
	private static String email;
	private static String birthDate;
	private static String pass;
	
	public User(String firstName, String lastName, String address, String phone, String email, String birthDate, String pass) {
		super();
		User.firstName = firstName;
		User.lastName = lastName;
		User.address = address;
		User.phone = phone;
		User.email = email;
		User.birthDate = birthDate;
		User.pass = pass;
	}

	public User(int id, String firstName, String lastName, String address, String phone, String email, String birthDate, String pass) {
		User.id = id;
		User.firstName = firstName;
		User.lastName = lastName;
		User.address = address;
		User.phone = phone;
		User.email = email;
		User.birthDate = birthDate;
		User.pass = pass;
	}
	

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		User.id = id;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		User.lastName = lastName;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		User.address = address;
	}

	public static String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		User.phone = phone;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		User.email = email;
	}

	public static String getBirthDate() {
		return birthDate;
	}

	public static void setBirthDate(String birthDate) {
		User.birthDate = birthDate;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		User.pass = pass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", birthDate=" + birthDate + ", pass=" + pass + "]";
	}
	
	
	
}
