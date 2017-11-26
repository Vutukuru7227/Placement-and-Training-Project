package com.jobportal.repository;

public abstract class User {
	private String email_id;
	private String first_name;
	private String last_name;
	private String password;
	private String admin_status;
	
	/**
	 * @return the admin_status
	 */
	public String getAdmin_status() {
		return admin_status;
	}
	/**
	 * @param admin_status the admin_status to set
	 */
	public void setAdmin_status(String admin_status) {
		this.admin_status = admin_status;
	}
	/**
	 * @return the member_type
	 */
	public abstract String getMember_type();
	/**
	 * @param member_type the member_type to set
	 */
	public abstract void setMember_type(String member_type);
	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
