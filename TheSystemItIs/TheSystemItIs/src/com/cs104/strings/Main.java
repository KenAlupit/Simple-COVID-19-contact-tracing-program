package com.cs104.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

	public static void main(String[] args) throws IOException, ParseException{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader (input);
		FullName FullName = new FullName();
		UserProfile UserProfile = new UserProfile();
		char selection;
	do {
		System.out.println("Are you a:");
		System.out.println("[S] - Store Visitor");
		System.out.println("[A] - Administrator");
		selection = reader.readLine().charAt(0);
		switch (selection) {
		case 'S':
		case 's':
			System.out.println("First Name:");
			FullName.setFirstName(reader.readLine());
			UserProfile.setUserFirstNameStorage(FullName.getFirstName());
			System.out.println("Middle Name:");
			FullName.setMiddleName(reader.readLine());
			System.out.println("Last Name:");
			FullName.setLastName(reader.readLine());
			UserProfile.setUserLastNameStorage(FullName.getLastName());
			System.out.println("Birth Date (mm/dd/yyyy):");
			UserProfile.setUserBirthDate(new SimpleDateFormat("MM/dd/yyyy").parse(reader.readLine()));
			do {
				System.out.println("Phone Number(xxxx-xxx-xxxx):");
				UserProfile.setUserPhoneNumber(reader.readLine());
			}while(UserProfile.getRightNumberFormat() == false);
			System.out.println("Your User ID:");
			UserProfile.setUserIDStorage(NameGenerator.randomUserID());
			System.out.println(UserProfile.getUserIDStorage(UserProfile.getUserIDStorageIndex()));
			UserProfile.setCurrentDate();
			UserProfile.setUserEnterDateStorage();
			UserProfile.setUserEnterTimeStorage();
			UserProfile.setUserEnterDateTimeStorage();
			System.out.println("Fullname: " + FullName.getFirstName() + " " + FullName.getMiddleInitial() + " " + FullName.getLastName());
			System.out.println("Birthdate: " + UserProfile.getUserBirthDate());
			System.out.println("Phone Number: " + UserProfile.getUserPhoneNumber());
			System.out.println("User enter date and time: " + UserProfile.getUserEnterDateTime());
			break;
		case 'A':
		case 'a':
			System.out.println("Please enter your password:");
			//Password: admin
			String Password = reader.readLine();
			if(new String(Password).equals("admin")) {
				System.out.println("[Login Successful]");
				do {
				UserProfile.numberOfSearchResultReset();
				UserProfile.qReset();
				UserProfile.tensReset();
				System.out.println("Search:");
				System.out.println("[A] - Date and time");
				System.out.println("[B] - First Name");
				System.out.println("[C] - Last Name");
				System.out.println("[D] - Phone Number");
				System.out.println("[E] - Log out");
				selection = reader.readLine().charAt(0);
				switch (selection) {
				case 'A':
				case 'a':
					System.out.println("Select an option");
					System.out.println("[A] - Date and time");
					System.out.println("[B] - Date");
					System.out.println("[C] - Time");
					selection = reader.readLine().charAt(0);
					switch (selection) {
					case 'A':
					case 'a':
						System.out.println("Date and time format[mm/dd/yyyy HH:MM:SS am/pm]");
						String dateAndTime = reader.readLine();
						UserProfile.searchUserEnterDateTimeStorage(dateAndTime);
						selection = reader.readLine().charAt(0);
						do {
						switch (selection) {
						case 'a':
						case 'A':
							UserProfile.next();
							UserProfile.searchUserEnterDateTimeStorage(dateAndTime);
							selection = reader.readLine().charAt(0);
							break;
						case 'b':
						case 'B':
							UserProfile.back();
							UserProfile.searchUserEnterDateTimeStorage(dateAndTime);
							selection = reader.readLine().charAt(0);
							break;
						}
						}while(selection != 'c' && selection != 'C');
						break;
					case 'B':
					case 'b':
						System.out.println("Date Format [mm/dd/yyyy]");
						String date = reader.readLine();
						UserProfile.searchUserEnterDateStorage(date);
						selection = reader.readLine().charAt(0);
						do {
						switch (selection) {
						case 'a':
						case 'A':
							UserProfile.next();
							UserProfile.searchUserEnterDateStorage(date);
							selection = reader.readLine().charAt(0);
							break;
						case 'b':
						case 'B':
							UserProfile.back();
							UserProfile.searchUserEnterDateStorage(date);
							selection = reader.readLine().charAt(0);
							break;
						}
						}while(selection != 'c' && selection != 'C');
						break;
					case 'C':
					case 'c':
						System.out.println("Time Format [HH:MM:SS am/pm]");
						String time = reader.readLine();
						UserProfile.searchUserEnterTimeStorage(time);
						selection = reader.readLine().charAt(0);
						do {
						switch (selection) {
						case 'a':
						case 'A':
							UserProfile.next();
							UserProfile.searchUserEnterTimeStorage(time);
							selection = reader.readLine().charAt(0);
							break;
						case 'b':
						case 'B':
							UserProfile.back();
							UserProfile.searchUserEnterTimeStorage(time);
							selection = reader.readLine().charAt(0);
							break;
						}
						}while(selection != 'c' && selection != 'C');
						break;
					}
					break;
				case 'B':
				case 'b':
					System.out.println("First Name:");
					String Firstname = reader.readLine();
					UserProfile.searchUserFirstNameStorage(Firstname);
					selection = reader.readLine().charAt(0);
					do {
					switch (selection) {
					case 'a':
					case 'A':
						UserProfile.next();
						UserProfile.searchUserFirstNameStorage(Firstname);
						selection = reader.readLine().charAt(0);
						break;
					case 'b':
					case 'B':
						UserProfile.back();
						UserProfile.searchUserFirstNameStorage(Firstname);
						selection = reader.readLine().charAt(0);
						break;
					}
					}while(selection != 'c' && selection != 'C');
					break;
				case 'C':
				case 'c':
					System.out.println("Last Name:");
					String Lastname = reader.readLine();
					UserProfile.searchUserLastNameStorage(Lastname);
					selection = reader.readLine().charAt(0);
					do {
					switch (selection) {
					case 'a':
					case 'A':
						UserProfile.next();
						UserProfile.searchUserLastNameStorage(Lastname);
						selection = reader.readLine().charAt(0);
						break;
					case 'b':
					case 'B':
						UserProfile.back();
						UserProfile.searchUserLastNameStorage(Lastname);
						selection = reader.readLine().charAt(0);
						break;
					}
					}while(selection != 'c' && selection != 'C');
					break;
				case 'D':
				case 'd':
					System.out.println("Phone Number (xxxx-xxx-xxxx):");
					String phoneNumber = reader.readLine();
					UserProfile.searchUserPhoneNumberStorage(phoneNumber);
					selection = reader.readLine().charAt(0);
					do {
					switch (selection) {
					case 'a':
					case 'A':
						UserProfile.next();
						UserProfile.searchUserPhoneNumberStorage(phoneNumber);
						selection = reader.readLine().charAt(0);
						break;
					case 'b':
					case 'B':
						UserProfile.back();
						UserProfile.searchUserPhoneNumberStorage(phoneNumber);
						selection = reader.readLine().charAt(0);
						break;
					}
					}while(selection != 'c' && selection != 'C');
					break;
				case 'E':
				case 'e':
				}
			}while(selection != 'e' && selection != 'E');
			System.out.println("[Successfully Logged out]");
			}
			else {
			System.out.println("[Login failed] invalid input or incorrect password");
			}
			break;
		}
		
	}while(selection != 'q');
	}
}