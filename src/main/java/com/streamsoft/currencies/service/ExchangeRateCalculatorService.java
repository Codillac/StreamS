package com.streamsoft.currencies.service;

import java.math.BigDecimal;

import com.streamsoft.currencies.controller.CurrencyExchangeRateQuery;
import com.streamsoft.currencies.controller.CurrencyExchangeRateQueryResult;

public interface ExchangeRateCalculatorService {
	BigDecimal calculateExchangeRate(CurrencyExchangeRateQuery query);
}