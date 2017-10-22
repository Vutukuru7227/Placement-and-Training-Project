package com.jobportal.repository;

import com.jobportal.models.RegistrationModel;

public interface ILogin {

	public RegistrationModel authenticateUser(RegistrationModel loginModel);
	
}
