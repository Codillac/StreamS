package com.streamsoft.currencies.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.domain.RatesFromTableDto;

@Component
public class NBPClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(NBPClient.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Optional<RatesFromCurrencyDto> getCurrencyRates(String url) {
		try {
			Optional<RatesFromCurrencyDto> rate = Optional.of(restTemplate.getForObject(url, RatesFromCurrencyDto.class));
			return rate;
		} catch (RestClientException e) {
			LOGGER.error(e.getMessage());
		} 
		return null;
	}
	
	public Optional<RatesFromTableDto[]> getTableRates(String url) {
		try {
			Optional<RatesFromTableDto[]> rates = Optional.of(restTemplate.getForObject(url, RatesFromTableDto[].class));
			return rates;
		} catch (RestClientException e) {
			LOGGER.error(e.getMessage());
		} 
		return null;
	}
}