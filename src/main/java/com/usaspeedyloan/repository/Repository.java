package com.usaspeedyloan.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.usaspeedyloan.model.UserDetails;

public interface Repository extends MongoRepository<UserDetails, String> {
	
	@Query("{authorizationCode : ?0}")
	List<UserDetails> findByAuthorizationCode(int authorizationCode);
	
	@Query("{phoneNumber : ?0}")
	UserDetails findByPhoneNumber(String phoneNumber);
	
	@Query("{emailAddress : ?0}")
	UserDetails findByEmail(String emailAddress);
	
	@Query("{caseId : ?0}")
	List<UserDetails> findByCaseId(String caseId);
	
	@Query("{status : ?0}")
	List<UserDetails> findByStatus(String status);

	@Query("{authorizationCode: ?0,status : ?1}")
	List<UserDetails> findByAuthorizationCodeAndStatus(int authorizationCode, String status);

}
