package com.usaspeedyloan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.usaspeedyloan.model.LenderWebsite;

public interface LendersRepository extends MongoRepository<LenderWebsite, String> {
	
	@Query("{status : ?0}")
	public List<LenderWebsite> findByStatus(String status);
	
	@Query("{webId : ?0}")
	public List<LenderWebsite> findByWebId(Long webId);
	
	@Query("{webUrl : ?0}")
	public List<LenderWebsite> findByWebUrl(String webUrl);
}