package com.jobportal.models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class ProfileModel {
	
	public ProfileModel(GeneralInfoModel generalmodel, EducationModel educationmodel, WorkExperienceModel workmodel, SkillsModel skillmodel) {
		// TODO Auto-generated constructor stub
		this.email_id = generalmodel.getEmail_id();
		this.phone_no = generalmodel.getPhone_no();
		this.address = generalmodel.getAddress();
		this.zip_code = generalmodel.getZip_code();
		
		this.institution = educationmodel.getInstitution();
		this.level = educationmodel.getLevel();
		this.gpa = educationmodel.getGpa();
		this.major = educationmodel.getMajor();
		this.edu_from = educationmodel.getEdu_from();
		this.edu_to = educationmodel.getEdu_to();
		
		this.title = workmodel.getTitle();
		this.organization_name = workmodel.getOrganization_name();
		this.location = workmodel.getLocation();
		this.exp_from = workmodel.getExp_from();
		this.exp_to = workmodel.getExp_to();
		this.achievements = workmodel.getAchievements();
		this.category = skillmodel.getCategory();
		this.skill = skillmodel.getSkill();
		
	}
	
	public ProfileModel() {
		// TODO Auto-generated constructor stub
	}
	public void storeGeneralDetails(Hashtable<Integer, GeneralInfoModel> generalInfoList) {
		Set<Integer> keys = generalInfoList.keySet();
		Iterator<Integer> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			int user_id = iterator.next();
			GeneralInfoModel generalmodel = generalInfoList.get(user_id);
			this.email_id = generalmodel.getEmail_id();
			this.phone_no = generalmodel.getPhone_no();
			this.address = generalmodel.getAddress();
			this.zip_code = generalmodel.getZip_code();
		}
	}

	public void storeEducationDetails(Hashtable<Integer, EducationModel> educationInfoList) {
		Set<Integer> keys = educationInfoList.keySet();
		Iterator<Integer> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			int user_id = iterator.next();
			EducationModel educationmodel = new EducationModel();
			educationmodel = educationInfoList.get(user_id);
			this.institution = educationmodel.getInstitution();
			this.level = educationmodel.getLevel();
			this.gpa = educationmodel.getGpa();
			this.major = educationmodel.getMajor();
			this.edu_from = educationmodel.getEdu_from();
			this.edu_to = educationmodel.getEdu_to();
			education.add(educationmodel);
		}
	}
	
	public void storeWorkExperienceDetails(Hashtable<Integer, WorkExperienceModel> workExperienceInfoList) {
		Set<Integer> keys = workExperienceInfoList.keySet();
		Iterator<Integer> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			int user_id = iterator.next();
			WorkExperienceModel workmodel = new WorkExperienceModel();
			workmodel = workExperienceInfoList.get(user_id);
			this.title = workmodel.getTitle();
			this.organization_name = workmodel.getOrganization_name();
			this.location = workmodel.getLocation();
			this.exp_from = workmodel.getExp_from();
			this.exp_to = workmodel.getExp_to();
			this.achievements = workmodel.getAchievements();
			workexperience.add(workmodel);
		}
	}
	
	public void storeSkillDetails(Hashtable<Integer, SkillsModel> skillInfoList) {
		Set<Integer> keys = skillInfoList.keySet();
		Iterator<Integer> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			int user_id = iterator.next();
			SkillsModel skillmodel = new SkillsModel();
			skillmodel = skillInfoList.get(user_id);
			this.category = skillmodel.getCategory();
			this.skill = skillmodel.getSkill();
			skills.add(skillmodel);
			
		}
	}
	
	/**
	 * @return the education
	 */
	public ArrayList<EducationModel> getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(ArrayList<EducationModel> education) {
		this.education = education;
	}

	/**
	 * @return the workexperience
	 */
	public ArrayList<WorkExperienceModel> getWorkexperience() {
		return workexperience;
	}

	/**
	 * @param workexperience the workexperience to set
	 */
	public void setWorkexperience(ArrayList<WorkExperienceModel> workexperience) {
		this.workexperience = workexperience;
	}

	private ArrayList<EducationModel> education = new ArrayList<>();
	private ArrayList<WorkExperienceModel> workexperience = new ArrayList<>();
	
	private ArrayList<SkillsModel> skills = new ArrayList<>();
	/**
	 * @return the skills
	 */
	public ArrayList<SkillsModel> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(ArrayList<SkillsModel> skills) {
		this.skills = skills;
	}

	private int user_id;
	private String email_id;
	private String address;
	private String phone_no;
	private String zip_code;
	private String institution;
	private String level;
	private String gpa;
	private String major;
	private String edu_from;
	private String edu_to;
	private String title;
	private String organization_name;
	private String location;
	private String exp_from;
	private String exp_to;
	private String achievements;
	private String category;
	private String skill;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEdu_from() {
		return edu_from;
	}
	public void setEdu_from(String edu_from) {
		this.edu_from = edu_from;
	}
	public String getEdu_to() {
		return edu_to;
	}
	public void setEdu_to(String edu_to) {
		this.edu_to = edu_to;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}