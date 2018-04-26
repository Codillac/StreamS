package com.streamsoft.currencies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.domain.RatesFromTableDto;

@Component
public final class NBPGetCurrencyRatesHttpClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(NBPGetCurrencyRatesHttpClient.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public RatesFromCurrencyDto getCurrencyRates(String url) throws RestClientException {
		LOGGER.info(this.getClass().getName() + ": requesting GET for CurrencyRates.");
		return restTemplate.getForObject(url, RatesFromCurrencyDto.class);
	}
	
	public RatesFromTableDto[] getTableRates(String url) throws RestClientException {
		LOGGER.info(this.getClass().getName() + ": requesting GET for TableRates.");
		return restTemplate.getForObject(url, RatesFromTableDto[].class);
	}
}