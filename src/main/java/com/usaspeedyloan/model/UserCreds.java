package com.usaspeedyloan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection= "UserCreds")
@Data
public class UserCreds {
	
	@Id
	private String id;
	private String user;
	private String password;

}
