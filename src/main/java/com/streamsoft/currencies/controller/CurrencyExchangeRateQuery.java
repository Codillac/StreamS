package com.streamsoft.currencies.controller;

import java.math.BigDecimal;

public class CurrencyExchangeRateQuery {
	BigDecimal value;
	CurrencyExchangeRateQueryParam requestParam;
	public CurrencyExchangeRateQuery(BigDecimal value, CurrencyExchangeRateQueryParam requestParam) {
		this.value = value;
		this.requestParam = requestParam;
	}
	public BigDecimal getValue() {
		return value;
	}
	public CurrencyExchangeRateQueryParam getRequestParam() {
		return requestParam;
	}
}
