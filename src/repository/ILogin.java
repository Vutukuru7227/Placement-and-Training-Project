package repository;

import models.RegistrationModel;

public interface ILogin {

	public boolean authenticateUser(String email_id, String password);
}
