package com.streamsoft.currencies.domain;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateFromTableDto {
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("code")
	private String code;
	@JsonProperty("mid")
	private BigDecimal mid;
	@JsonProperty("bid")
	private BigDecimal bid;
	@JsonProperty("ask")
	private BigDecimal ask;
	
	public String getCurrency() {
		return currency;
	}
	public String getCode() {
		return code;
	}
	public Optional<BigDecimal> getMid() {
		return Optional.ofNullable(mid);
	}
	public Optional<BigDecimal> getBid() {
		return Optional.ofNullable(bid);
	}
	public Optional<BigDecimal> getAsk() {
		return Optional.ofNullable(ask);
	}
}