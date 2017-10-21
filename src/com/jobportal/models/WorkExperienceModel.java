package com.jobportal.models;

public class WorkExperienceModel {
	private int user_id;
	private String email_id;
	private String title;
	private String organization_name;
	private String location;
	private String exp_from;
	private String exp_to;
	private String achievements;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getExp_from() {
		return exp_from;
	}
	public void setExp_from(String exp_from) {
		this.exp_from = exp_from;
	}
	public String getExp_to() {
		return exp_to;
	}
	public void setExp_to(String exp_to) {
		this.exp_to = exp_to;
	}
	public String getAchievements() {
		return achievements;
	}
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	
	
}
