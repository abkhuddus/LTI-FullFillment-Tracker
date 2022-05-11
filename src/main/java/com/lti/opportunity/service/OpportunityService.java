package com.lti.opportunity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.exception.InvalidRequestException;
import com.lti.model.OpStatusDTO;
import com.lti.model.UpdateStatus;
import com.lti.model.UserStatusCount;
import com.lti.opportunity.model.OpportunityDTO;
import com.lti.opportunity.model.OpportunityResponseDTO;
import com.lti.opportunity.model.OpprunitySaveDTO;
import com.lti.opportunity.model.UpdateOpportunityDTO;

@Service
public interface OpportunityService {

	
public UserStatusCount statusUpdate(String status) throws InvalidRequestException;
	
	
	public String SaveOpportunity(OpprunitySaveDTO op) throws InvalidRequestException;
	
	
	public List<OpportunityResponseDTO>getAllOpportunity() throws InvalidRequestException;
	
	public List<OpStatusDTO> getOpBasedOnStatus();
	
	
//	public List<Opportunity> getOPPById(Integer id);
	
	
	public String UpdateStatusById(UpdateStatus s);

	public String update(UpdateOpportunityDTO dto);
	
	public OpportunityResponseDTO getByRRNumber(float rrNumber);
	
	public List<OpportunityResponseDTO> getByOpportunityId(String opportunity);

	
	public List<OpportunityResponseDTO> getallYTJ() throws InvalidRequestException ;
	
	
	public OpportunityDTO getOpportunity(String opId);
	
}
