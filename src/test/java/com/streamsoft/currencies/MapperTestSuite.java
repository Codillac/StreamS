package com.streamsoft.currencies;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.streamsoft.currencies.controller.RequestParam;
import com.streamsoft.currencies.domain.CurrencyRate;
import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.mapper.ExchangeRateMapper;
import com.streamsoft.currencies.service.NBPService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTestSuite {
	@Autowired
	NBPService service;
	
	@Autowired
	ExchangeRateMapper mapper;
	
	@Test
	public void testMapToExchangeRateFromCurrency() {
		//Given
		int NUMBER_OF_REQUESTED_RATES = 5;
		RequestParam param = new RequestParam("A", "USD", NUMBER_OF_REQUESTED_RATES, null, null, null);
		RatesFromCurrencyDto ratesDto = service.requestCurrencyRates(param);
		//When
		List<CurrencyRate> resultRates = mapper.mapToExchangeRateFromCurrency(ratesDto);
		for(CurrencyRate operationalRate : resultRates) {
			System.out.println(operationalRate.getCurrency().getName() + ": " + operationalRate.getMid());
		}
		//Then
		Assert.assertEquals(resultRates.size(), NUMBER_OF_REQUESTED_RATES);
	}
}