package com.lti.opportunity.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.exception.InvalidRequestException;
import com.lti.exception.UserNotFoundException;
import com.lti.model.OpStatusDTO;
import com.lti.model.UpdateStatus;
import com.lti.model.UserStatusCount;
import com.lti.opportunity.dao.OpeningsRepository;
import com.lti.opportunity.dao.OpportunityRepository;
import com.lti.opportunity.dao.StatusMangoRepository;
import com.lti.opportunity.model.Openings;
import com.lti.opportunity.model.Opportunity;
import com.lti.opportunity.model.OpportunityDTO;
import com.lti.opportunity.model.OpportunityResponseDTO;
import com.lti.opportunity.model.OpprunitySaveDTO;
import com.lti.opportunity.model.SaveOpeningsDTO;
import com.lti.opportunity.model.UpdateOpportunityDTO;
import com.lti.opportunity.service.OpportunityService;
import com.lti.user.Dao.UserMongoRepository;
import com.lti.user.util.SequenceIdGenerator;
import com.mongodb.client.model.EstimatedDocumentCountOptions;
@Service
public class OpportunityServiceImplNew implements OpportunityService {

	
	Logger logger = LoggerFactory.getLogger(OpportunityServiceImplNew.class);

	@Autowired
	private SequenceIdGenerator sequenceId;



	

	@Autowired
	private OpportunityRepository opportunityDao;
	
	@Autowired
	
	private OpeningsRepository openingsDAO;
	
	@Override
	public UserStatusCount statusUpdate(String status) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	@Override
	@Transactional
	public String SaveOpportunity(OpprunitySaveDTO dto) throws InvalidRequestException {
		
		
		String msg=" ";
		logger.info("Entred Into Saving Opportunity");

		if(dto!=null) {
			
			Opportunity existOp=opportunityDao.findByOpportunityID(dto.getOpportunityID());
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");  
				 Calendar calendar = Calendar.getInstance();
	  			   // calendar.add(Calendar.DATE, -7);
	  			    Date newDate=calendar.getTime();
	     				String date = dateFormat.format(newDate);
	     				Opportunity op=new Opportunity();

			   if(existOp==null) {
		 	    	op.setId(Long.toString(sequenceId.nextId()));
		 	    	op.setDate(date);   
			   }else {
		 	    	op=existOp;
			   }
			   
			   
			   
			   
			op.setClientName(dto.getClientName());
			op.setCountry(dto.getCountry());
			op.setLoB(dto.getLoB());
			op.setLocation(dto.getLocation());
			op.setOpportunityID(dto.getOpportunityID());
			op.setOpportunityName(dto.getOpportunityName());
			
			if(dto.getOpeningsList()!=null) {
				List<Openings> openingList= new ArrayList<>();
				if(dto.getOpeningsList().size()>0) {
					
					for(SaveOpeningsDTO o:dto.getOpeningsList()) {
				     	 Openings existop=openingsDAO.findByRrNumber(o.getRrNumber());
				     	 if(existop!=null) {
				     	    	return existop.getRrNumber()+" "+"RRNumber is Prasent in Database";
				     	    }
					}
					
					
					for(SaveOpeningsDTO o:dto.getOpeningsList()) {
		     	 Openings existop=openingsDAO.findByRrNumber(o.getRrNumber());
	
		     	        
		     	      if(existop==null) {
		     	    	  Openings openings=new Openings();
		     	    	openings.setId(Long.toString(sequenceId.nextId()));
		     	    	openings.setRrNumber(o.getRrNumber());
		     	    	openings.setOpportunity(op.getId());
		     	    	
		     	    	 openings.setCandidateName(o.getCandidateName());
		     	    	
		     	    	openings.setDate(date);
		     				
		     	    	openings.setPrimarySkils(o.getPrimarySkils());
		     	    	
		     	    	openings.setSecondarySkills(o.getSecondarySkills());
		     				
		  		           openings.setPriority(o.getPriority());
		  		           openings.setProjectManager(o.getProjectManager());
		  		           openings.setpUdU(o.getpUdU());
		  		           openings.setStatus(o.getSubStatus());
		  		           openings.setSubStatus(o.getSubStatus());
		  		           openings.setRemarks(o.getRemarks());
		     	    	  openings.setType(o.getType());
		     	    	  
		     	    	  if(o.getEmployeeName()!=null) {
		     	    		  openings.setEmployeeName(o.getEmployeeName());
		     	    		  
		     	    	  }if(o.getPsNo()!=null) {
		     	    		  openings.setPsNumber(o.getPsNo());
		     	    	  }
		     	    	  if(o.getYtj()!=null) {
		     	    		  openings.setYtj(o.getYtj());
		     	    	  }
		     	    	  if(o.getFulfillmentDate()!=null) {
		     	    		  openings.setFulfillmentDate(o.getFulfillmentDate());
		     	    	  }
		     	    	  openingList.add(openings);
		     	    	Openings opening=  openingsDAO.save(openings);
		     	    	if(opening!=null) {
		     	    		msg=msg
		     	    				+" "+opening.getRrNumber();
		     	    	}
		     	      }	
					}
				}
				
				  if(existOp!=null) {
                openingList.addAll( existOp.getOpenings());
				  }
				op.setOpenings(openingList);
				
				opportunityDao.save(op);
				return msg;
			}
			
		}
		
		return null;
	}

	@Override
	public List<OpportunityResponseDTO> getAllOpportunity()  {
	
		
		/*
		 final PatternNUMBER = Pattern.compile("\\d+");
		 String increment(String input) {
			return NUMBER.matcher(input).replaceFirst(s -> String.format("%0" + s.group().length() + "d",Integer.parseInt(s.group()) + 1));
			
		}public static void main(String args[]) 
		
		{System.out.println(increment("001"));
		
		System.out.println(increment("012345"));
		
		System.out.println(increment("ABC0123"));}
				
		System.out.println(s2);
		*/
		logger.info("Entred Into Fetching All Opportunities");
		
			List<Opportunity> listOpp=opportunityDao.findAll();
			
		
			
			List<OpportunityResponseDTO> listDto=new ArrayList<>();
			if(listOpp!=null) {
				if(listOpp.size()>0) {
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");  
					
					for(Opportunity o:listOpp) {
						System.out.println("OP="+o.getOpportunityID());
						
						
						
						for(Openings op: o.getOpenings()) {

							OpportunityResponseDTO dto=new OpportunityResponseDTO();

							
							dto.setOpportunityName(o.getOpportunityName());
							dto.setOpportunityID(o.getOpportunityID());
							dto.setAgeing(op.getAgeing());
				          
							dto.setCandidateName(op.getCandidateName());
							
							 dto.setClientName(o.getClientName());
							
                             dto.setCountry(o.getCountry());							
							
							dto.setEmployeeName(op.getEmployeeName());
							
							
							if(op.getFulfillmentDate()!=null) {
		           				String filfullmentData = dateFormat.format(op.getFulfillmentDate()); 
								dto.setFulfillmentDate(filfullmentData);
							}
							
							
							
							dto.setLoB(o.getLoB());
												
							dto.setLocation(o.getLocation());
							
							dto.setPrimarySkils(op.getPrimarySkils());
							
							dto.setPriority(op.getPriority());
							
							dto.setProjectManager(op.getProjectManager());
							
	                           dto.setPsNumber(op.getPsNumber());	
							     dto.setDate(op.getDate());

	                           dto.setAgeing(op.getAgeing());
	                           dto.setSubStatus(op.getSubStatus());
	                           

							dto.setpUdU(op.getpUdU());
							
							dto.setRemarks(op.getRemarks());
							
							dto.setRrNumber(op.getRrNumber());
							
							dto.setSecondarySkills(op.getSecondarySkills());
							
							dto.setStatus(op.getStatus());
							
							
							dto.setType(op.getType());
							if(op.getYtj()!=null) {
								dto.setYtj(op.getYtj());	
							}
							
							listDto.add(dto);
						}
						
					}
					return listDto;
				}
			}
				return null;
	}

	@Override
	public List<OpStatusDTO> getOpBasedOnStatus() {
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");  


				  Calendar calendar = Calendar.getInstance();
				    calendar.set(2022, Calendar.APRIL, 20);
				    calendar.add(Calendar.DATE, -8);
				    Date newDate=calendar.getTime();
					
				    
	   				String fromdate = dateFormat.format(newDate);  
			        
	   				String toDate=dateFormat.format(new Date());
	   				
	
	           System.out.println("FormDate="+fromdate+" "+"Todate="+toDate);
	           
	           
				Integer count=openingsDAO.countByDateBetween(fromdate,toDate);
				
				List<Openings> oplist=openingsDAO.findByDateBetween(fromdate, toDate);
				
				System.out.println("List="+oplist);
				System.out.println("Count="+count);


			List<OpStatusDTO>l1=new ArrayList<OpStatusDTO>();
			OpStatusDTO op=new OpStatusDTO();
			Integer open=openingsDAO.getOpenOp("Open");
			if(open==null) {
				op.setOpen(0);
			}
			Integer closed=openingsDAO.getclosedOp("Closed");

			if(closed==null) {
				op.setClosed(0);
			}
			Integer all=(int) openingsDAO.count();
			op.setAll(all);
			op.setClosed(closed);
			op.setOpen(open);
			l1.add(op);
			return l1;
		} catch (Exception e) {

			logger.error("Exception While Fetching count  Opportunities Based On Status");
		}
		return null;

	}



	@Override
	public String UpdateStatusById(UpdateStatus s) {

		
		return null;
	}

	@Override
	public String update(UpdateOpportunityDTO dto) {

		
		Openings op=null;
		Opportunity o=null;
		if(dto!=null) {
			
			 o=opportunityDao.findByOpportunityID(dto.getOpportunityID());
			
			if(o!=null) {
				o.setClientName(dto.getClientName());
				o.setCountry(dto.getCountry());
				o.setLoB(dto.getLoB());
				o.setLocation(dto.getLocation());
				o.setOpportunityName(dto.getOpportunityName());
			}

			 op=openingsDAO.findByRrNumber(dto.getRrNumber());
			
			if(op!=null) {
				
					op.setPrimarySkils(dto.getPrimarySkils());
					op.setSecondarySkills(dto.getSecondarySkills());
					op.setRemarks(dto.getRemarks());
			      
					op.setCandidateName(dto.getCandidateName());
					op.setPriority(dto.getPriority());
					op.setProjectManager(dto.getProjectManager());
					op.setpUdU(dto.getpUdU());
					op.setStatus(dto.getStatus());
					op.setSubStatus(dto.getSubStatus());

					op.setType(op.getType());
					
					if(dto.getPsNo()!=null) {
						op.setPsNumber(dto.getPsNo());
					}
					if(dto.getEmployeeName()!=null) {
						op.setEmployeeName(dto.getEmployeeName());
					}
					
				if(dto.getYtj()!=null) {
					op.setYtj(dto.getYtj());
				}
				
				if(dto.getFulfillmentDate()!=null) {
					try {
						op.setFulfillmentDate(dto.getFulfillmentDate());		
				LocalDate creaedDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate fillfullDate = op.getFulfillmentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				 final long days = ChronoUnit.DAYS.between(creaedDate, fillfullDate);
			       System.out.println("Days between: " + days);
			
			      op.setAgeing(days);
			  			
					} catch (Exception e) {
					
			         System.err.print("got Error in while saving ageing");		
					}

				}
				openingsDAO.save(op);
			}
			opportunityDao.save(o);
		}
		
		return null;
	}




	@Override
	public OpportunityResponseDTO getByRRNumber(float rrNumber) {
		
		Openings op=openingsDAO.findByRrNumber(rrNumber);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");  

		 if(op!=null) {
			 Opportunity oportunity=null;

			 OpportunityResponseDTO dto= new OpportunityResponseDTO();
			 if(op.getOpportunity()!=null) {
				  oportunity=opportunityDao.findById(op.getOpportunity()).get();
			 }
			 
			  if(oportunity!=null) {
				  dto.setOpportunityID(oportunity.getOpportunityID());
				  dto.setOpportunityName(oportunity.getOpportunityName());
				  dto.setClientName(oportunity.getClientName());
				  dto.setCountry(oportunity.getCountry());
				  dto.setLoB(oportunity.getLoB());
				  dto.setLocation(oportunity.getLocation());
			  }
			 dto.setAgeing(op.getAgeing());
				dto.setCandidateName(op.getCandidateName());
			
				dto.setEmployeeName(op.getEmployeeName());
				
				if(op.getFulfillmentDate()!=null) {
       				String filfullmentData = dateFormat.format(op.getFulfillmentDate()); 
					dto.setFulfillmentDate(filfullmentData);
				}
			
				
				dto.setPrimarySkils(op.getPrimarySkils());
				
				dto.setPriority(op.getPriority());
				
				dto.setProjectManager(op.getProjectManager());
				
                dto.setPsNumber(op.getPsNumber());	

                dto.setAgeing(op.getAgeing());
                dto.setSubStatus(op.getSubStatus());
				dto.setpUdU(op.getpUdU());
				
				dto.setRemarks(op.getRemarks());
				
				dto.setRrNumber(op.getRrNumber());
				
				dto.setSecondarySkills(op.getSecondarySkills());
				
				dto.setStatus(op.getStatus());
				
				dto.setSubStatus(op.getSubStatus());
				
				dto.setType(op.getType());
			
				
			 return dto;
		 }
		
		return null;
	}




	@Override
	public List<OpportunityResponseDTO> getByOpportunityId(String opportunityId) {
		
		   if(opportunityId!=null) {
			   Opportunity opportunity=opportunityDao.findByOpportunityID(opportunityId);
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");  

			   if(opportunity!=null) {
			    	
			    	List<Openings>openingsList=opportunity.getOpenings();
			    	
			    	if(openingsList!=null) {
			    		
			    		if(openingsList.size()>0) {
			    			List<OpportunityResponseDTO> dtoList=new ArrayList<>();
			    			
			    			try {
			    				for(Openings op: openingsList) {
				    				
				    				OpportunityResponseDTO dto =new OpportunityResponseDTO();
				    				
				    					 dto.setOpportunityID(opportunity.getOpportunityID());
				    					dto.setOpportunityName(opportunity.getOpportunityName());
				    				  
				    				 dto.setAgeing(op.getAgeing());
				    					dto.setCandidateName(op.getCandidateName());
				    					dto.setClientName(opportunity.getClientName());
				    					
	                                    dto.setCountry(opportunity.getCountry());			    					
				    					
				    					dto.setEmployeeName(op.getEmployeeName());
				    					
				    					if(op.getFulfillmentDate()!=null) {
				    	       				String filfullmentData = dateFormat.format(op.getFulfillmentDate()); 
				    						dto.setFulfillmentDate(filfullmentData);
				    					}				    					
				    				dto.setLoB(opportunity.getLoB());
				    					
				    					dto.setLocation(opportunity.getLocation());
				    					
				    					dto.setPrimarySkils(op.getPrimarySkils());
				    					
				    					dto.setPriority(op.getPriority());
				    					
				    					dto.setProjectManager(op.getProjectManager());
				    					
				    	                dto.setPsNumber(op.getPsNumber());	
				    	                
				    					    dto.setDate(op.getDate());
				    					     
				    					     dto.setDate(opportunity.getDate());

				    	                dto.setAgeing(op.getAgeing());
				    	                dto.setSubStatus(op.getSubStatus());
				    					dto.setpUdU(op.getpUdU());
				    					
				    					dto.setRemarks(op.getRemarks());
				    					
				    					dto.setRrNumber(op.getRrNumber());
				    					
				    					dto.setSecondarySkills(op.getSecondarySkills());
				    					
				    					dto.setStatus(op.getStatus());
				    					
				    					dto.setSubStatus(op.getSubStatus());
				    					
				    					dto.setType(op.getType());
				    				
										
										dto.setYtj(op.getYtj());			    		
										dtoList.add(dto);
				    				
				    			}
				    			return dtoList;
	
							} catch (Exception e) {
								// TODO: handle exception
							}
			    						    			
			    			return dtoList;
			    		}
			    	}
			    }
			   
		   }
		
		return null;
	}




	@Override
	public List<OpportunityResponseDTO> getallYTJ() throws InvalidRequestException {
		try {
			List<Opportunity> listOpp=opportunityDao.findAll();
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");  

			
			if(listOpp==null) 
				throw new UserNotFoundException("Opportunities Not Found");
			   
						
			List<OpportunityResponseDTO> listDto=new ArrayList<>();

			if(listOpp!=null) {
				if(listOpp.size()>0) {
					
					for(Opportunity o:listOpp) {
						
						try {
							for(Openings op: o.getOpenings()) {
								 if(op.getYtj()==null)
									 break;
								 
								OpportunityResponseDTO dto=new OpportunityResponseDTO();

								dto.setOpportunityID(o.getOpportunityID());
								
								dto.setOpportunityName(o.getOpportunityName());
								dto.setAgeing(op.getAgeing());
					          
								dto.setCandidateName(op.getCandidateName());
								
								dto.setClientName(o.getClientName());
								
								dto.setCountry(o.getCountry());
								
								dto.setEmployeeName(op.getEmployeeName());
								
								if(op.getFulfillmentDate()!=null) {
		    	       				String filfullmentData = dateFormat.format(op.getFulfillmentDate()); 
		    						dto.setFulfillmentDate(filfullmentData);
		    					}									
								dto.setLoB(o.getLoB());
								
								dto.setLocation(o.getLocation());
								
								dto.setPrimarySkils(op.getPrimarySkils());
								
								dto.setPriority(op.getPriority());
								
								dto.setProjectManager(op.getProjectManager());
								
		                           dto.setPsNumber(op.getPsNumber());	
								     dto.setDate(o.getDate());
		                           dto.setAgeing(op.getAgeing());
		                           dto.setSubStatus(op.getSubStatus());
								dto.setpUdU(op.getpUdU());
								
								dto.setRemarks(op.getRemarks());
								
								dto.setRrNumber(op.getRrNumber());
								
								dto.setSecondarySkills(op.getSecondarySkills());
								
								dto.setStatus(op.getStatus());
								
								dto.setSubStatus(op.getSubStatus());
								
								dto.setType(op.getType());
									
								dto.setYtj(op.getYtj());							
								listDto.add(dto);
							}
		
						} catch (Exception e) {
							
						}											
					}
					return listDto;
				}
			}
	
		} catch (Exception e) {
			
			
			logger.error(" Exception while feching operorunities");
			throw new InvalidRequestException("Exception while feching operorunities");
			
		}
		return null;
	}




	@Override
	public OpportunityDTO getOpportunity(String opId) {
	
		 try {
			
			 Opportunity op= opportunityDao.findByOpportunityID(opId);
			 if(op!=null){
				 OpportunityDTO dto=new OpportunityDTO();				 
				 dto.setClientName(op.getClientName());
				 dto.setCountry(op.getCountry());
				 dto.setLocation(op.getLocation());
				 dto.setOpportunityID(op.getOpportunityID());
				 dto.setOpportunityName(op.getOpportunityName());
				 dto.setLoB(op.getLoB());
				 
				 return dto;
			 }
			 else
				 return null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}




	

}
