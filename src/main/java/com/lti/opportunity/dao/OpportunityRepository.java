package com.lti.opportunity.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.opportunity.model.Opportunity;

@Repository
public interface OpportunityRepository extends MongoRepository<Opportunity, String> {
	
	
	

	// @Query(value ="{status: ?0}",count=true)           //SQL Equivalent : select count(*) from book where author=?
//	    Integer getclosedOp(String close);

//	    @Query(value ="{status: ?0}",count=true)           //SQL Equivalent : select count(*) from book where author=?
	//    Integer getOpenOp(String open);

	    
	  //  Opportunity findByRrNumber(float rrNumber);
	    
	    
	    Opportunity findByOpportunityID(String id);

   // @Query("SELECT count(*) FROM Opportunity u WHERE u.status='open' ")
    //public Integer getOpenOp();
    
    
    //@Query("SELECT count(*) FROM Opportunity u WHERE u.status='close' ")
    //public Integer getclosedOp();
    
    
   // @Query("SELECT count(*) FROM Opportunity u WHERE u.status='open' ")
    //public Integer getOpenOp();
    
    
  

}
