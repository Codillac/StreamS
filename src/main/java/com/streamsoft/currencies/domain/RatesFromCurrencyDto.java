package com.streamsoft.currencies.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesFromCurrencyDto {
	@JsonProperty("table")
	private String table;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("code")
	private String code;
	@JsonProperty("rates")
	private List<RateFromCurrencyDto> rates;
	
	public String getTable() {
		return table;
	}

	public String getCurrency() {
		return currency;
	}

	public String getCode() {
		return code;
	}

	public List<RateFromCurrencyDto> getRates() {
		return rates;
	}
}
