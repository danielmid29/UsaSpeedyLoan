package com.usaspeedyloan.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.usaspeedyloan.model.CodeList;

public interface CodeRepository extends MongoRepository<CodeList, Integer> {
	
	@Query("{status : ?0}")
	public List<CodeList> findByStatus(String status);
	
	@Query("{authorizationCode : ?0}")
	public List<CodeList> findByauthorizationCode(int authorizationCode);
	
	@Query("{authorizationCode : ?0}")
	public CodeList deleteByauthorizationCode(int authorizationCode);
	
	@Query("{usages : { $ne: ?0 }}")
	public List<CodeList> findByNotZero(int usage);
}
