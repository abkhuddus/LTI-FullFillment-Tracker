package com.lti.opportunity.model;

import java.util.List;

public class OpprunitySaveDTO {
	
	
	
private String	loB ;

private String opportunityID ;

private String opportunityName ;

private String clientName ;

private String country ;

private String location ;

List<SaveOpeningsDTO> openingsList;

public String getLoB() {
	return loB;
}

public void setLoB(String loB) {
	this.loB = loB;
}

public String getOpportunityID() {
	return opportunityID;
}

public void setOpportunityID(String opportunityID) {
	this.opportunityID = opportunityID;
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

public List<SaveOpeningsDTO> getOpeningsList() {
	return openingsList;
}

public void setOpeningsList(List<SaveOpeningsDTO> openingsList) {
	this.openingsList = openingsList;
}


}
