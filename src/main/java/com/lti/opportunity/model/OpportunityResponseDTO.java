package com.lti.opportunity.model;

import java.util.Date;

public class OpportunityResponseDTO {
	
	
	private String id;

	private String loB;
	private float rrNumber;

	private String pUdU;
	
	private String employeeName;
	
	private String psNumber;
	
	
	private String clientName;
	
	private String ProjectManager;
	
	
	private String primarySkils;
	
	private String secondarySkills;
	
	private String country;
	
	private String location;
	
	
	
	private String candidateName;//

	private String priority;

	
	private String ytj;

	private String fulfillmentDate;

	private long ageing;	
	
	
	private String status;//
	
	private String subStatus;

	private String date;	
	
	
	private String remarks;
	private String type;

	private String opportunityID;
	private String OpportunityName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoB() {
		return loB;
	}
	public void setLoB(String loB) {
		this.loB = loB;
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
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getYtj() {
		return ytj;
	}
	public void setYtj(String ytj) {
		this.ytj = ytj;
	}
	public String getFulfillmentDate() {
		return fulfillmentDate;
	}
	public void setFulfillmentDate(String fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
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
	public String getOpportunityID() {
		return opportunityID;
	}
	public void setOpportunityID(String opportunityID) {
		this.opportunityID = opportunityID;
	}
	public String getOpportunityName() {
		return OpportunityName;
	}
	public void setOpportunityName(String opportunityName) {
		OpportunityName = opportunityName;
	}
	@Override
	public String toString() {
		return "OpportunityResponseDTO [id=" + id + ", loB=" + loB + ", rrNumber=" + rrNumber + ", pUdU=" + pUdU
				+ ", employeeName=" + employeeName + ", psNumber=" + psNumber + ", clientName=" + clientName
				+ ", ProjectManager=" + ProjectManager + ", primarySkils=" + primarySkils + ", secondarySkills="
				+ secondarySkills + ", country=" + country + ", location=" + location + ", candidateName="
				+ candidateName + ", priority=" + priority + ", ytj=" + ytj + ", fulfillmentDate=" + fulfillmentDate
				+ ", ageing=" + ageing + ", status=" + status + ", subStatus=" + subStatus + ", date=" + date
				+ ", remarks=" + remarks + ", type=" + type + ", opportunityID=" + opportunityID + ", OpportunityName="
				+ OpportunityName + "]";
	}

}
