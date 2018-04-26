package com.streamsoft.currencies.controller;

import java.math.BigDecimal;

public class Request {
	BigDecimal value;
	RequestParam requestParam;
	public Request(BigDecimal value, RequestParam requestParam) {
		this.value = value;
		this.requestParam = requestParam;
	}
	public BigDecimal getValue() {
		return value;
	}
	public RequestParam getRequestParam() {
		return requestParam;
	}
}
