package com.jobportal.models;

import com.jobportal.repository.User;

public class JobSeekerModel extends User {
	
	private String member_type;
	
	@Override
	public String getMember_type() {
		return member_type;
	}

	@Override
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	
}
