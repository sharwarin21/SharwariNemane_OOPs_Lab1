package com.gl.main;

import java.util.Scanner;

import com.gl.model.Employee;
import com.gl.service.CredentialService;
import com.gl.service.CredentialServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
			
		System.out.println("Enter First Name:");
		String firstName=sc.next();
		System.out.println("Enter Last Name:");
		String lastName=sc.next();
		Employee employee=new Employee(firstName,lastName);
		
		CredentialService service=new CredentialServiceImpl();
		service.setCredentials(employee);
		System.out.println("__________________________________________________");
		System.out.println();
		service.showCredentials(employee);
	}

}
