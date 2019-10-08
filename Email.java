package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPassword = 8;
	private String email;
	private String companySuffix = "company.com";
	private String altEmail;
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDept();
		
		this.password = randomPassword(defaultPassword);
		System.out.println("Password: " + this.password);
		
		this.email = firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + companySuffix;
	}
	
	private String setDept() {
		System.out.println("New worker: " + this.firstName + ". Department codes: \n1 Sales \n2 Development \n3 Accounting \n0 none \nEnter department code: ");
		Scanner in = new Scanner(System.in);
		
		int deptCode = in.nextInt();
		
		if (deptCode == 1)
			return "Sales";
		
		else if (deptCode == 2)
			return "Dev";
		
		else if (deptCode == 3)
			return "Acct";
		
		else
			return "";
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!$*&_@";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
		
	}
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void alternateEmail (String email) {
		this.altEmail = email;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}
	
	public String getAltEmail() {
		return this.altEmail;
	} 
	
	public String getPassword() {
		return this.password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + this.firstName + " " + this.lastName +
				"\nCOMPANY EMAIL: " + this.email +
				"\nMAILBOX CAPACITY: " + this.mailboxCapacity + "mb";
	}
	
}
