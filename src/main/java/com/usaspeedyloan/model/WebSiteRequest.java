package com.usaspeedyloan.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class WebSiteRequest {

	private Long webId;
	private String webUrl;
	private MultipartFile webImage;
	private String status;
}
