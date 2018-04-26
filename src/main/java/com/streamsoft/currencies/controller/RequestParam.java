package com.streamsoft.currencies.controller;

import java.time.LocalDate;
import java.util.Optional;

public class RequestParam {
	private String table;
	private  String code;
	private  Integer topCount;
	private  LocalDate date;
	private  LocalDate startDate;
	private  LocalDate endDate;
	
	
	
	public RequestParam(String table, String code, Integer topCount, LocalDate date, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.table = table;
		this.code = code;
		this.topCount = topCount;
		this.date = date;
		this.startDate = startDate;
		this.endDate = endDate;
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
