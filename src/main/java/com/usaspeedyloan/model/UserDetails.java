package com.usaspeedyloan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@ToString
@Data
public class UserDetails {
	
	@Id
	private String id;	
	private String caseId;
	private String fullName;
	private String emailAddress;
	private String phoneNumber;
	private String loanAmount;
	private String appliedDate;
	private int authorizationCode;
	private String status;
}
