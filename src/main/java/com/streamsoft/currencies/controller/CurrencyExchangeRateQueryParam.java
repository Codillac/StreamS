package com.streamsoft.currencies.controller;

import java.time.LocalDate;
import java.util.Optional;

public class CurrencyExchangeRateQueryParam {
	private String table;
	private  String code;
	private  Integer topCount;
	private  LocalDate date;
	private  LocalDate startDate;
	private  LocalDate endDate;
	
	public CurrencyExchangeRateQueryParam(String table) {
		super();
		this.table = table;
	}
		
	public CurrencyExchangeRateQueryParam(String table, Integer topCount) {
		super();
		this.table = table;
		this.topCount = topCount;
	}
	
	public CurrencyExchangeRateQueryParam(String table, LocalDate date) {
		super();
		this.table = table;
		this.date = date;
	}
	
	public String getTable() {
		return table;
	}
	public Optional<String> getCode() {
		return Optional.ofNullable(code);
	}
	public Optional<Integer> getTopCount() {
		return Optional.ofNullable(topCount);
	}
	public Optional<LocalDate> getDate() {
		return Optional.ofNullable(date);
	}
	public Optional<LocalDate> getStartDate() {
		return Optional.ofNullable(startDate);
	}
	public Optional<LocalDate> getEndDate() {
		return Optional.ofNullable(endDate);
	}
}
