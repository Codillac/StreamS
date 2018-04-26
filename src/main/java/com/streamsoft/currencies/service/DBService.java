package com.streamsoft.currencies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streamsoft.currencies.domain.CurrencyRate;
import com.streamsoft.currencies.repository.ExchangeRateRepository;

@Service
public class DBService {
	@Autowired
	ExchangeRateRepository repository;
	
	public CurrencyRate saveToDB(CurrencyRate currencyRate) {
		return repository.save(currencyRate);
	}
}