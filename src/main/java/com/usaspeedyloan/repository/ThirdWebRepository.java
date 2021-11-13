package com.usaspeedyloan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.usaspeedyloan.model.CodeList;
import com.usaspeedyloan.model.ThirdPartyWebsites;
import com.usaspeedyloan.model.UserDetails;

public interface ThirdWebRepository extends MongoRepository<ThirdPartyWebsites, String> {
	
	@Query("{status : ?0}")
	public List<ThirdPartyWebsites> findByStatus(String status);
	
	@Query("{webId : ?0}")
	public List<ThirdPartyWebsites> findByWebId(Long webId);
	
	@Query("{webUrl : ?0}")
	public List<ThirdPartyWebsites> findByWebUrl(String webUrl);

	@Query("{webId : ?0}")
	public ThirdPartyWebsites deleteByWebId(Long webId);
}
