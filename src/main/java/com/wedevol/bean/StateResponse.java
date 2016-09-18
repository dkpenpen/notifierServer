package com.wedevol.bean;

import java.io.Serializable;

/*
 * State Response
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * State Response Bean
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("code")
	private int code;

	@JsonProperty("message")
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
