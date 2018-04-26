package com.streamsoft.currencies.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesFromTableDto {
	@JsonProperty("table")
	private String table;
	@JsonProperty("no")
	private String no;
	@JsonProperty("effectiveDate")
	private LocalDate effectiveDate;
	@JsonProperty("tradingDate")
	private LocalDate tradingDate;
	@JsonProperty("rates")
	private List<RateFromTableDto> rates;
	
	public String getTable() {
		return table;
	}
	public String getNo() {
		return no;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public Optional<LocalDate> getTradingDate() {
		return Optional.ofNullable(tradingDate);
	}
	public List<RateFromTableDto> getRates() {
		return rates;
	}
}
