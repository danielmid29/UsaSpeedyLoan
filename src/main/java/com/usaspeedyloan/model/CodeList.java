package com.usaspeedyloan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection="CodeList")
@Data
public class CodeList {
	
	@Id
	private String id;
	private int authorizationCode;
	private int usages;
	private String status;
	private String appliedDate;
	
}
