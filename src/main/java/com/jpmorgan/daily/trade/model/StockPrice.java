/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.model;

import java.math.BigDecimal;

public class StockPrice {

	private String currencyCode;
	private BigDecimal agreedFx;
	private int units;
	private BigDecimal pricePerUnit;
	private BigDecimal totalTradeAmt;
	
	
	
	/**
	 * @param currencyCode
	 * @param agreedFx
	 * @param units
	 * @param pricePerUnit
	 * @param totalTradeAmt
	 */
	public StockPrice(String currencyCode, BigDecimal agreedFx, int units, BigDecimal pricePerUnit) {
		super();
		this.currencyCode = currencyCode;
		this.agreedFx = agreedFx;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
		this.totalTradeAmt = computeTotalTradeAmt(agreedFx, units, pricePerUnit);
	}
	
	
	private BigDecimal computeTotalTradeAmt(BigDecimal agreedFx,int units, BigDecimal pricePerUnit) {
		return agreedFx.multiply(pricePerUnit).multiply(BigDecimal.valueOf(units));
	}


	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}
	/**
	 * @param agreedFx the agreedFx to set
	 */
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	/**
	 * @return the pricePerUnit
	 */
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	/**
	 * @return the totalTradeAmt
	 */
	public BigDecimal getTotalTradeAmt() {
		return totalTradeAmt;
	}
	/**
	 * @param totalTradeAmt the totalTradeAmt to set
	 */
	public void setTotalTradeAmt(BigDecimal totalTradeAmt) {
		this.totalTradeAmt = totalTradeAmt;
	}


	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}


	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	


	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	*/ 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockPrice [currencyCode=");
		builder.append(currencyCode);
		builder.append(", agreedFx=");
		builder.append(agreedFx);
		builder.append(", units=");
		builder.append(units);
		builder.append(", pricePerUnit=");
		builder.append(pricePerUnit);
		builder.append(", totalTradeAmt=");
		builder.append(totalTradeAmt);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
