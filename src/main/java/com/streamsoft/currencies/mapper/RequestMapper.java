package com.streamsoft.currencies.mapper;

import org.springframework.stereotype.Component;

import com.streamsoft.currencies.controller.Request;
import com.streamsoft.currencies.controller.RequestDto;
import com.streamsoft.currencies.controller.RequestParam;

@Component
public class RequestMapper {
	public Request mapToRequest(RequestDto dto){
		return new Request(dto.getValue(), new RequestParam(dto.getRequestParamDto().getTable(), 
				dto.getRequestParamDto().getCode(), dto.getRequestParamDto().getTopCount(), 
				dto.getRequestParamDto().getDate(), dto.getRequestParamDto().getStartDate(),
				dto.getRequestParamDto().getEndDate()));
	}
}
