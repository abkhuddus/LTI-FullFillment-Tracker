package com.lti.opportunity.dao;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.opportunity.model.Openings;
@Repository
public interface OpeningsRepository extends MongoRepository<Openings, String> {
	


	 @Query(value ="{status: ?0}",count=true)           //SQL Equivalent : select count(*) from book where author=?
      Integer getclosedOp(String close);

    @Query(value ="{status: ?0}",count=true)           //SQL Equivalent : select count(*) from book where author=?
	    Integer getOpenOp(String open);

	    
	   Openings findByRrNumber(float rrNumber);
	   
	   Integer countByDateBetween(String fromdate,String todate);
	   
	   List<Openings> findByDateBetween(String fromdate,String toDate);
	   
	   
	//   @Query("SELECT op WHERE  ")
	  // List<OpportunityResponseDTO> finAllByYtj();
	   
}
