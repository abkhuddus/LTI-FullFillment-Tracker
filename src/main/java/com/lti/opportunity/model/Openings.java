package com.lti.opportunity.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Openings {
	
	
	
	@Id
	private String id;

	@Override
	public String toString() {
		return "Openings [rrNumber=" + rrNumber + ", date=" + date + "]";
	}
	@Indexed(unique=true)
	private float rrNumber;

	private String pUdU;
	
	private String employeeName;
	
	private String psNumber;
	
	private String ProjectManager;
	
	
	public String getOpportunity() {
		return Opportunity;
	}
	public void setOpportunity(String opportunity) {
		Opportunity = opportunity;
	}
	private String primarySkils;//
	
	private String secondarySkills;
	
	private String Opportunity;
	
	
	
	
	private String candidateName;//

	private String priority;


	
	
	private String ytj;

	private Date fulfillmentDate;

	private long ageing;	
	
	
	private String status;//
	
	private String subStatus;

	public String getYtj() {
		return ytj;
	}
	public void setYtj(String ytj) {
		this.ytj = ytj;
	}
	
	public Date getFulfillmentDate() {
		return fulfillmentDate;
	}
	public void setFulfillmentDate(Date fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}
	private String date;	
	
	
	private String remarks;
	private String type;


		
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPsNumber() {
		return psNumber;
	}
	public void setPsNumber(String psNumber) {
		this.psNumber = psNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public float getRrNumber() {
		return rrNumber;
	}
	public void setRrNumber(float rrNumber) {
		this.rrNumber = rrNumber;
	}
	public String getpUdU() {
		return pUdU;
	}
	public void setpUdU(String pUdU) {
		this.pUdU = pUdU;
	}
	
	public String getProjectManager() {
		return ProjectManager;
	}
	public void setProjectManager(String projectManager) {
		ProjectManager = projectManager;
	}
	public String getPrimarySkils() {
		return primarySkils;
	}
	public void setPrimarySkils(String primarySkils) {
		this.primarySkils = primarySkils;
	}
	public String getSecondarySkills() {
		return secondarySkills;
	}
	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}
	
	
	
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	public long getAgeing() {
		return ageing;
	}
	public void setAgeing(long ageing) {
		this.ageing = ageing;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
