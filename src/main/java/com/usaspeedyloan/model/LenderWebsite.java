package com.usaspeedyloan.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "LenderWebsite")
@Data
public class LenderWebsite {
	@Id
	private String id;
	private Long webId;
	private String webUrl;
	private Binary webImage;
	private String status;
	
}
