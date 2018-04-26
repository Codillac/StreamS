package com.streamsoft.currencies;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.streamsoft.currencies.controller.CurrencyExchangeRateQueryParam;
import com.streamsoft.currencies.domain.CurrencyRate;
import com.streamsoft.currencies.mapper.CurrencyRatesDomainMapper;
import com.streamsoft.currencies.service.NBPGetCurrencyRatesService;
import com.streamsoft.currencies.valid.NoCurrencyRatesException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTestSuite {
	@Autowired
	NBPGetCurrencyRatesService service;
	
	@Autowired
	CurrencyRatesDomainMapper mapper;
	
	@Test
	public void testMapToExchangeRateFromCurrency() throws NoCurrencyRatesException {
		//Given
		int NUMBER_OF_REQUESTED_RATES = 5;
		CurrencyExchangeRateQueryParam param = new CurrencyExchangeRateQueryParam("A", "USD", NUMBER_OF_REQUESTED_RATES, null, null, null);

		//When
		List<CurrencyRate> resultList = service.getCurrencyRates(param);
		//Then
		Assert.assertEquals(resultList.size(), NUMBER_OF_REQUESTED_RATES);
	}
}