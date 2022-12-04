package com.gl.service;

import com.gl.model.Employee;

public interface CredentialService {
	
	public void generatePassword(Employee emp);
	public void generateEmailAddress(Employee emp);
	public void showCredentials(Employee emp);
	public void setCredentials(Employee emp);
	
}
