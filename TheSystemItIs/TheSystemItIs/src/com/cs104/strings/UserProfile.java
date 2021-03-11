package com.cs104.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;

public class UserProfile {
	private final String userID;
	private Date userBirthDate;
	private String userPhoneNumber;
	private LocalDateTime currentDate = LocalDateTime.now();
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm:ss a");
	private DateTimeFormatter dateAndTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");
	private Date userEnterDateTime = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse(currentDate.format(dateAndTimeFormatter));
	private String prompt = "Invalid Input or does not exist";
	private boolean rightNumberFormat;
	private boolean lastNameAlreadyExists;
	private boolean firstNameAlreadyExists;
	private boolean phoneNumberAlreadyExists;
	private boolean birthDateAlreadyExists;
	private int indexOf;
	private int q = 0;
	private int tens = 10;
	private int numberOfSearchResult = 0;
	private LinkedList<String> userIDStorage= new LinkedList<String>();
	private LinkedList<String> userEnterDateStorage= new LinkedList<String>();
	private LinkedList<String> userEnterTimeStorage= new LinkedList<String>();
	private LinkedList<String> userEnterDateTimeStorage= new LinkedList<String>();
	private LinkedList<String> userPhoneNumberStorage= new LinkedList<String>();
	private LinkedList<String> userFirstNameStorage= new LinkedList<String>();
	private LinkedList<String> userLastNameStorage= new LinkedList<String>();
	private LinkedList<Date> userBirthDateStorage= new LinkedList<Date>();
	FullName FullName = new FullName();
	//default constructor
	public UserProfile() throws ParseException {
		this.tens = 10;
		this.q = 0;
		this.userID = NameGenerator.randomUserID();
		this.userBirthDate = new Date();
		this.currentDate = LocalDateTime.now();
		this.userEnterDateTime = new Date();
	}
	public void next() {
		this.tens = this.tens + 10;
		this.q = this.q + 10;
	}
	public void back() {
		this.q = this.q - 10;
		this.tens = this.tens - 10;
	}
	public void qReset() {
		this.q = 0;
	}
	public void tensReset() {
		this.tens = 10;
	}
	public void numberOfSearchResultReset() {
		this.numberOfSearchResult = 0;
	}
	public void searchMenu(int size) {
		if (size > 10){
			if (this.q + 10 < size && this.numberOfSearchResult >= 10) {System.out.println("[A] - Next");}
			if (this.q + 10 > 10) {System.out.println("[B] - Previous");}
			System.out.println("[C] - Back to menu");
		}
		else if (size <= 10){
			System.out.println("[C] - Back to menu");
		}	
	}
	public void searchUserEnterDateStorage(String date) {
		if (userEnterDateStorage.contains(date)) {
			for (int i = q; i <= this.userEnterDateStorage.lastIndexOf(date); i++) {
				if(i < tens) {
					if(this.userEnterDateStorage.get(i).equals(date)) {
						this.getSearchResult(i);
						this.numberOfSearchResult++;
					}
				}	
			}
			this.searchMenu(this.userEnterDateStorage.size());
		}
		else {System.out.println(prompt);}
	}
	public void searchUserEnterTimeStorage(String time) {
		if (userEnterTimeStorage.contains(time)) {
			for (int i= q; i <= this.userEnterTimeStorage.lastIndexOf(time); i++) {
				if(i < tens) {
					if(this.userEnterTimeStorage.get(i).equals(time)) {
						this.getSearchResult(i);
						this.numberOfSearchResult++;
					}
				}
			}
			this.searchMenu(this.userEnterTimeStorage.size());
		}
		else {System.out.println(prompt);}
	}
	public void searchUserEnterDateTimeStorage(String dateTime) {
		if (userEnterDateTimeStorage.contains(dateTime)) {
			for (int i= q; i <= this.userEnterDateTimeStorage.lastIndexOf(dateTime); i++) {
				if(i < tens) {
					if(this.userEnterDateTimeStorage.get(i).equals(dateTime)) {
						this.getSearchResult(i);
						this.numberOfSearchResult++;
					}
				}
			}
			this.searchMenu(this.userEnterDateTimeStorage.size());
		}
		else {System.out.println(prompt);}
	}
	public void searchUserFirstNameStorage(String firstName){
		if (userFirstNameStorage.contains(firstName)) {
			for (int i= q; i <= this.userFirstNameStorage.lastIndexOf(firstName); i++) {
				if(i < tens) {
					if(this.userFirstNameStorage.get(i).equals(firstName)) {
						this.getSearchResult(i);
						this.numberOfSearchResult++;
					}
				}
			}
			this.searchMenu(this.userFirstNameStorage.size());
		}
		else {System.out.println(this.prompt);}
	}
	public void searchUserLastNameStorage(String lastName){
		if (userLastNameStorage.contains(lastName)) {
			for (int i= q; i <= this.userLastNameStorage.lastIndexOf(lastName); i++) {
				if(i < tens) {
					if(this.userLastNameStorage.get(i).equals(lastName)) {
						this.getSearchResult(i);
						this.numberOfSearchResult++;
					}
				}
			}
			this.searchMenu(this.userLastNameStorage.size());
		}
		else {System.out.println(this.prompt);}
	}
	public void searchUserPhoneNumberStorage(String phoneNumber){
		if(userPhoneNumber.matches("\\d{4}-\\d{3}-\\d{4}")){
			this.rightNumberFormat = true;
			if (userPhoneNumberStorage.contains(phoneNumber)) {
				for (int i= q; i <= this.userPhoneNumberStorage.lastIndexOf(phoneNumber); i++) {
					if(i < tens) {
						if(this.userPhoneNumberStorage.get(i).equals(phoneNumber)) {
							this.getSearchResult(i);
							this.numberOfSearchResult++;
						}
					}
				}
				this.searchMenu(this.userPhoneNumberStorage.size());
			}
			else {System.out.println(this.prompt);}
			}
		else {
			this.rightNumberFormat = false;
			System.out.println("Invalid phone number/format");
		}
	}
	public int getUserIDStorageIndex() {
		return userIDStorage.size()-1;
	}
	public String getPrompt() {
		return this.prompt;
	}
	public String getUserEnterTimeStorage() {
		return this.userEnterTimeStorage.get(0);
	}
	public String getUserIDStorage(int index) {
		return this.userIDStorage.get(index);
	}
	public String getuserID() {
		return this.userID;
	}
	public Date getUserBirthDate() {
		return this.userBirthDate;
	}
	public Date getUserEnterDateTime() {
		return this.userEnterDateTime;
	}
	public String getUserPhoneNumber() {
		return this.userPhoneNumber;
	}
	public boolean getRightNumberFormat() {
		return this.rightNumberFormat;
	}
	public void getSearchResult(int index) {
		System.out.println("User ID: " + this.userIDStorage.get(index));
		System.out.println("Phone Number: " + this.userPhoneNumberStorage.get(index));
		System.out.println("Date and time when entered: " + this.userEnterDateStorage.get(index) + " " + this.userEnterTimeStorage.get(index));
	}
	public void setUserFirstNameStorage(String firstName) {
		if(this.userFirstNameStorage.contains(firstName)) {
			this.firstNameAlreadyExists = true;
		}
		else {
		this.firstNameAlreadyExists = false;
		}
		this.userFirstNameStorage.add(firstName);
		this.indexOf = this.userFirstNameStorage.indexOf(firstName);
	}
	public void setUserLastNameStorage(String lastName) {
		if(this.userLastNameStorage.contains(lastName)) {
			this.lastNameAlreadyExists = true;
		}
		else {
			this.lastNameAlreadyExists = false;
		}
		this.userLastNameStorage.add(lastName);
		this.indexOf = this.userLastNameStorage.indexOf(lastName);
	}
	public int getindex() {
		return this.userPhoneNumberStorage.indexOf(this.userPhoneNumber);
	}
	public void setUserIDStorage(String randomUserID) {
	if(this.phoneNumberAlreadyExists == true && this.firstNameAlreadyExists == true && this.lastNameAlreadyExists == true && this.birthDateAlreadyExists == true) {
		this.userIDStorage.add(this.userIDStorage.get(this.indexOf));
			}
		else {
		this.userIDStorage.add(randomUserID);
		}
	}
	public void setCurrentDate() throws ParseException {
		this.currentDate = LocalDateTime.now();
		this.userEnterDateTime = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse(currentDate.format(dateAndTimeFormatter));
	}
	public void setUserEnterDateStorage() {
		this.currentDate = LocalDateTime.now();
		this.userEnterDateStorage.add(currentDate.format(dateFormatter));
	}
	public void setUserEnterDateTimeStorage() {
		this.currentDate = LocalDateTime.now();
		this.userEnterDateTimeStorage.add((currentDate.format(dateAndTimeFormatter)));
	}
	public void setUserEnterTimeStorage() {
		this.currentDate = LocalDateTime.now();
		this.userEnterTimeStorage.add(currentDate.format(timeFormatter));
	}
	public void setUserPhoneNumberStorage(String phoneNumber) {
		this.userPhoneNumberStorage.add(phoneNumber);
	}
	public void setUserBirthDate(Date userBirthDate) {
		if(this.userBirthDateStorage.contains(userBirthDate)) {
			this.birthDateAlreadyExists = true;
		}
		else {
			this.birthDateAlreadyExists = false;
		}
		this.userBirthDateStorage.add(userBirthDate);
		this.userBirthDate = userBirthDate;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		if(userPhoneNumber.matches("\\d{4}-\\d{3}-\\d{4}")){
		this.rightNumberFormat = true;
		if(this.userPhoneNumberStorage.contains(userPhoneNumber)) {
			this.phoneNumberAlreadyExists = true;
		}
		else {
		this.phoneNumberAlreadyExists = false;
		}
		this.userPhoneNumber = userPhoneNumber;
		this.setUserPhoneNumberStorage(userPhoneNumber);
		}
		else {
			this.rightNumberFormat = false;
			System.out.println("Invalid phone number/format");
			}
	}
}
