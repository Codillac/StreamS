package com.streamsoft.currencies.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateFromCurrencyDto {
	@JsonProperty("no")
	private String no;
	@JsonProperty("effectiveDate")
	private LocalDate effectiveDate;	
	@JsonProperty("tradingDate")
	private LocalDate tradingDate;
	@JsonProperty("mid")
	private BigDecimal mid;
	@JsonProperty("bid")
	private BigDecimal bid;
	@JsonProperty("ask")
	private BigDecimal ask;
	
	public String getNo() {
		return no;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public LocalDate getTradingDate() {
		return tradingDate;
	}
	public BigDecimal getMid() {
		return mid;
	}
	public BigDecimal getBid() {
		return bid;
	}
	public BigDecimal getAsk() {
		return ask;
	}
}