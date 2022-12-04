package com.gl.service;

import java.util.Random;
import java.util.Scanner;

import com.gl.model.Employee;

public class CredentialServiceImpl implements CredentialService{
	
	@Override
	public void generatePassword(Employee emp){
		String capitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters="abcdefghijklmnopqrstuvwxyz";
		String numbers="1234567890";
		String specialCharacters="!@#$%^&*()-_=+<>,./?";
		String allCharacters=capitalLetters+smallLetters+numbers+specialCharacters;
		int totalCharacters=allCharacters.length();
		Random random=new Random();
		String password="";
		for(int i=0;i<8;i++){
			int randomIndex=random.nextInt(totalCharacters);
			char randomCharacter=allCharacters.charAt(randomIndex);
			password+=String.valueOf(randomCharacter);
		}
		emp.setPassword(password);
	}
	
	@Override
	public void generateEmailAddress(Employee emp){
		String name=emp.getFirstName().toLowerCase()+emp.getLastName().toLowerCase();
		String department=emp.getDepartment();
		String company=emp.getCompany();
		String email;
		email=name+"@"+department+"."+company+".com";
		emp.setEmail(email);
	}
	
	@Override
	public void showCredentials(Employee emp){
		System.out.println("Dear "+emp.getFirstName()+" your generated credentials are as follows:");
		//System.out.println("Full Name:"+emp.getFirstName()+" "+emp.getLastName());
		//System.out.println("Department:"+emp.getDepartment());
		System.out.println("Email Id: "+emp.getEmail());
		System.out.println("Password: "+emp.getPassword());
	}
	
	@Override
	public void setCredentials(Employee emp) {
		System.out.println("Please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		String department="";
		switch(choice) {
			case 1: department="tech";
				break;
			case 2: department="admin";
				break;
			case 3: department="hr";
				break;
			case 4: department="legal";
				break;
			default: System.out.println("Invalid Choice.");
				System.exit(0);
		}
		emp.setDepartment(department);
		generateEmailAddress(emp);
		generatePassword(emp);
	}
	
}
