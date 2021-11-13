package com.usaspeedyloan.model;

import lombok.Data;

@Data
public class ErrorMessage {
	private String errorMessage;

	@Override
	public String toString() {
		return errorMessage;
	}
}
