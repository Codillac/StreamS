package com.streamsoft.currencies;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.streamsoft.currencies.controller.CurrencyExchangeRateQueryParam;
import com.streamsoft.currencies.domain.CurrencyRate;
import com.streamsoft.currencies.domain.RateFromCurrencyDto;
import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.service.NBPGetCurrencyRatesService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTestSuite {
	@Autowired
	NBPGetCurrencyRatesService service;
	
	@Test
	public void testRequestCurrencyRatesForCurrentRate() {
		//Given
		CurrencyExchangeRateQueryParam param = new CurrencyExchangeRateQueryParam("A", "USD", null, null, null, null);
		//When
		List<CurrencyRate> rates = service.getCurrencyRates(param);
		System.out.println(rates.getTable() + ", " + rates.getCurrency() + ", " + rates.getCode());
		boolean result = true;
		for(RateFromCurrencyDto currentRate : rates.getRates()){
			System.out.println(currentRate.getMid().get());
			if(!(currentRate.getMid().isPresent() || currentRate.getAsk().isPresent() || currentRate.getBid().isPresent())){
				result = false;
			}
		}
		//Then
		Assert.assertTrue(result);
	}
	
	@Test
	public void testRequestCurrencyRatesForSpecifiedDate() {
		//Given
		CurrencyExchangeRateQueryParam param = new CurrencyExchangeRateQueryParam("A", "USD", null, LocalDate.of(2018, 3, 20), null, null);
		//When
		List<CurrencyRate> rates = service.getCurrencyRates(param);
		System.out.println(rates.getTable() + ", " + rates.getCurrency() + ", " + rates.getCode());
		boolean result = true;
		for(RateFromCurrencyDto currentRate : rates.getRates()){
			System.out.println(currentRate.getMid().get());
			if(!(currentRate.getMid().isPresent() || currentRate.getAsk().isPresent() || currentRate.getBid().isPresent())){
				result = false;
			}
		}
		//Then
		Assert.assertTrue(result);
	}
	
	@Test
	public void testRequestCurrencyRatesTopCount() {
		//Given
		CurrencyExchangeRateQueryParam param = new CurrencyExchangeRateQueryParam("A", "USD", 5, null, null, null);
		//When
		List<CurrencyRate> rates = service.getCurrencyRates(param);
		System.out.println(rates.getTable() + ", " + rates.getCurrency() + ", " + rates.getCode());
		boolean result = true;
		for(RateFromCurrencyDto currentRate : rates.getRates()){
			System.out.println(currentRate.getMid().get());
			if(!(currentRate.getMid().isPresent() || currentRate.getAsk().isPresent() || currentRate.getBid().isPresent())){
				result = false;
			}
		}
		//Then
		Assert.assertTrue(result);
	}
}