package com.streamsoft.currencies.controller;

import java.math.BigDecimal;

public class RequestDto {
	BigDecimal value;
	RequestParamDto requestParamDto;
	public RequestDto(BigDecimal value, RequestParamDto requestParamDto) {
		this.value = value;
		this.requestParamDto = requestParamDto;
	}
	public BigDecimal getValue() {
		return value;
	}
	public RequestParamDto getRequestParamDto() {
		return requestParamDto;
	}
}
