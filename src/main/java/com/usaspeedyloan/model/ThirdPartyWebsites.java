package com.usaspeedyloan.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import lombok.Data;

@Document(collection="ThirdPartyWebsites")
@Data
public class ThirdPartyWebsites {
	
	@Id
	private String id;
	private Long webId;
	private String webUrl;
	private Binary webImage;
	private String status;
	
}
