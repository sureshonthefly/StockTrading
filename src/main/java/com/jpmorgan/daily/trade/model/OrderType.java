package com.jpmorgan.daily.trade.model;

public enum OrderType {
	B("BUY"),S("SELL");
	
	private String oderTypeCode;
	
	private OrderType(String value){
		this.oderTypeCode = value;
	}
}
