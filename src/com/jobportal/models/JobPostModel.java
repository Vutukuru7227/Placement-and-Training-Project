package com.jobportal.models;

import java.util.Date;


public class JobPostModel {
	private int job_id;
	private int emp_id;
	private String job_title;
	/**
	 * @return the job_description
	 */
	public String getJob_description() {
		return job_description;
	}
	/**
	 * @param job_description the job_description to set
	 */
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	private String job_description;
	private Date deadline;
	
	
	
	/**
	 * @return the job_id
	 */
	public int getJob_id() {
		return job_id;
	}
	/**
	 * @param job_id the job_id to set
	 */
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	/**
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}
	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	/**
	 * @return the job_title
	 */
	public String getJob_title() {
		return job_title;
	}
	/**
	 * @param job_title the job_title to set
	 */
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

}
