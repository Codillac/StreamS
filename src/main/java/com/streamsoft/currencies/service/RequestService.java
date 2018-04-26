package com.streamsoft.currencies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streamsoft.currencies.controller.Request;
import com.streamsoft.currencies.controller.RequestDto;
import com.streamsoft.currencies.controller.Result;
import com.streamsoft.currencies.domain.RatesFromCurrencyDto;
import com.streamsoft.currencies.mapper.ExchangeRateMapper;
import com.streamsoft.currencies.mapper.RequestMapper;

@Service
public class RequestService {
	@Autowired
	private RequestMapper inputMapper;
	
	@Autowired
	private NBPService service;
	
	@Autowired
	private ExchangeRateMapper outputMapper;
	
	public Result executeRequest(RequestDto dto){
		Request request = inputMapper.mapToRequest(dto);
		RatesFromCurrencyDto ratesDto = service.requestCurrencyRates(request.getRequestParam());
		return new Result(ratesDto.getRates().get(0).getMid().get(), dto.getValue());
	}
}
