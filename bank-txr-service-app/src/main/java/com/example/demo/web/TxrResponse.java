package com.example.demo.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class TxrResponse {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
