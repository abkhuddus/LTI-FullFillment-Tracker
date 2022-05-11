package com.lti.opportunity.model;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Opportunity {
	
	
	
	
	private String id;
	
	private String	loB ;
   
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(unique=true)
	private String opportunityID ;

	private String opportunityName ;

	private String clientName ;

	private String country ;

	private String location ;
	
	@DBRef
	private List<Openings> openings;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Openings> getOpenings() {
		return openings;
	}

	public void setOpenings(List<Openings> openings) {
		this.openings = openings;
	}


	
	

	

	public String getOpportunityID() {
		return opportunityID;
	}

	public void setOpportunityID(String opportunityID) {
		this.opportunityID = opportunityID;
	}

	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", loB=" + loB + ", opportunityID=" + opportunityID + ", opportunityName="
				+ opportunityName + ", clientName=" + clientName + ", country=" + country + ", location=" + location
				+ ", openings=" + openings + "]";
	}

	public String getLoB() {
		return loB;
	}

	public void setLoB(String loB) {
		this.loB = loB;
	}

	public String getOpportunityName() {
		return opportunityName;
	}

	public void setOpportunityName(String opportunityName) {
		this.opportunityName = opportunityName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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
}
