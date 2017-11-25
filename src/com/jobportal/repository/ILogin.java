package com.jobportal.repository;

import com.jobportal.models.EmployerModel;
import com.jobportal.models.JobSeekerModel;

public interface ILogin {

	public String authenticateUserandSpecifyType(String email_id, String password);
	public EmployerModel getEmployerDetails(String email_id);
	public JobSeekerModel getJobSeekerDetails(String email_id);
}
