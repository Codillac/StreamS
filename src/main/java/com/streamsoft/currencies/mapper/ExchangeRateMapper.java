package com.streamsoft.currencies.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.streamsoft.currencies.domain.Currency;
import com.streamsoft.currencies.domain.CurrencyRate;
import com.streamsoft.currencies.domain.Rate;
import com.streamsoft.currencies.domain.RateFromCurrencyDto;
import com.streamsoft.currencies.domain.RateFromTableDto;
import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.domain.RatesFromTableDto;

@Component
public class ExchangeRateMapper {
	
	public List<CurrencyRate> mapToExchangeRateFromCurrency(RatesFromCurrencyDto ratesDto){
		Currency currency = new Currency(ratesDto.getCurrency(), ratesDto.getCode());
		List<CurrencyRate> currencyRates = new ArrayList<>();
		for(RateFromCurrencyDto operationalRateForCur : ratesDto.getRates()) {
			Rate operationalRate = new Rate(operationalRateForCur.getNo(), ratesDto.getTable(), operationalRateForCur.getEffectiveDate(), operationalRateForCur.getTradingDate().orElse(null));
			currencyRates.add(new CurrencyRate(operationalRate, currency, operationalRateForCur.getMid().orElse(null), operationalRateForCur.getBid().orElse(null), operationalRateForCur.getAsk().orElse(null)));
		}
		return currencyRates;
	}
	
	public List<CurrencyRate> mapToExchangeRateFromTable(RatesFromTableDto ratesDto){
		Rate rate = new Rate(ratesDto.getNo(), ratesDto.getTable(), ratesDto.getEffectiveDate(), ratesDto.getTradingDate().orElse(null));
		List<CurrencyRate> currencyRates = new ArrayList<>();
		for(RateFromTableDto operationalRate : ratesDto.getRates()) {
			Currency currency = new Currency(operationalRate.getCurrency(), operationalRate.getCode());
			currencyRates.add(new CurrencyRate(rate, currency, operationalRate.getMid().orElse(null), operationalRate.getBid().orElse(null), operationalRate.getAsk().orElse(null)));
		}
		return currencyRates;
	}
}