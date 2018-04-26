package com.streamsoft.currencies.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streamsoft.currencies.controller.RequestParam;
import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.domain.RatesFromTableDto;
import com.streamsoft.currencies.valid.NoDataOfRatesException;

@Service
public class NBPService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NBPClient.class);
	
	@Autowired
	private NBPClient client;
	
	private final static String NBP_API_ENDPOINT = "http://api.nbp.pl/api/exchangerates/";
	private final static String TABLES = "tables/";
	private final static String RATES = "rates/";
	
	public List<RatesFromTableDto> requestTableRates(RequestParam queryParam) {
		RatesFromTableDto[] rates = client.getTableRates(buildUrl(queryParam, TABLES)).orElseThrow(() -> new NoDataOfRatesException());
		List<RatesFromTableDto> ratesList = Arrays.asList(rates);
		return ratesList;
	}
	
	public RatesFromCurrencyDto requestCurrencyRates(RequestParam queryParam) {
		RatesFromCurrencyDto rates = client.getCurrencyRates(buildUrl(queryParam, RATES)).orElseThrow(() -> new NoDataOfRatesException());
		return rates;
	}
	
	private String buildUrl(RequestParam queryParam, String methodConstant) {
		String url = NBP_API_ENDPOINT + methodConstant + queryParam.getTable() + "/";
		LOGGER.info(url);
		if(queryParam.getCode().isPresent() && methodConstant == RATES) {
			url += queryParam.getCode().get() + "/";
		}
		LOGGER.info(url);
		if(queryParam.getDate().isPresent()) {
			url += queryParam.getDate().get() + "/";
		} else if(queryParam.getStartDate().isPresent() && queryParam.getEndDate().isPresent()) {
			url += queryParam.getStartDate().get() + "/";
			url += queryParam.getEndDate().get() + "/";
		} else if(queryParam.getTopCount().isPresent()) {
			url += "last/" + queryParam.getTopCount().get() + "/";
		}
		return url;
	}
}
