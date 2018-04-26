package com.streamsoft.currencies.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.streamsoft.currencies.service.RequestService;

@RestController
@RequestMapping("/exchangerates")
@CrossOrigin(origins = "*")
public class CurrenciesController {
	@Autowired
	private RequestService service;
	
	@RequestMapping(value ="/table/{table}/currency/{code}/frompln/{value}", method = RequestMethod.GET )
	public BigDecimal getCurrencyCurrentRate(@PathVariable String table, @PathVariable String code, @PathVariable BigDecimal value) {
		RequestDto requestDto = new RequestDto(value, new RequestParamDto(table, code));
		return service.executeRequest(requestDto).calculateResult();
	}
}