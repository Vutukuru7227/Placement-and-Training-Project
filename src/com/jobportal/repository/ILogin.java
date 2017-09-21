package com.jobportal.repository;

import com.jobportal.models.RegistrationModel;

public interface ILogin {

	public boolean authenticateUser(String email_id, String password);
}
