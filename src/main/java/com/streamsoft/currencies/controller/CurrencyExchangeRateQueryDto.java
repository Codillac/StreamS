package com.streamsoft.currencies.controller;

import java.math.BigDecimal;

public class CurrencyExchangeRateQueryDto {
	BigDecimal value;
	CurrencyExchangeRateQueryParamDto requestParamDto;
	public CurrencyExchangeRateQueryDto(BigDecimal value, CurrencyExchangeRateQueryParamDto requestParamDto) {
		this.value = value;
		this.requestParamDto = requestParamDto;
	}
	public BigDecimal getValue() {
		return value;
	}
	public CurrencyExchangeRateQueryParamDto getRequestParamDto() {
		return requestParamDto;
	}
}
