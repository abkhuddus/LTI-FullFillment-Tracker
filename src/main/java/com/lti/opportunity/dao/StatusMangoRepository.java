package com.lti.opportunity.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.UserStatusCount;

@Repository
public interface StatusMangoRepository extends MongoRepository<UserStatusCount, Integer> {

}
