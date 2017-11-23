package com.jobportal.repository;

import com.jobportal.models.UserModel;

public interface ILogin {

	public UserModel authenticateUser(UserModel loginModel);
	
}
