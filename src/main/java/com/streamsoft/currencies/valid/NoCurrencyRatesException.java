package com.streamsoft.currencies.valid;

public class NoCurrencyRatesException extends Exception {

	public NoCurrencyRatesException(final String message) {
		super(message);
	}
}