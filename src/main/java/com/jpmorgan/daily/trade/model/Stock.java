/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jpmorgan.daily.trade.util.GenericUtil;

/**
 * @author suresh
 *
 */
public class Stock {

	private String entity;
	private OrderType orderType;	
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private LocalDate updatedSettlementDate;
	
	private StockPrice stockPrice;
	
	public Stock(String entity, String orderType, String agreedFx, String currencyCode, String instructionDate, String settlementDate,
			String units, String pricePerUnit) {
		this( entity,  orderType,  instructionDate,	 settlementDate, currencyCode);
		this.stockPrice = createStockPrice(currencyCode, agreedFx, units, pricePerUnit);
	}

	
	public Stock(String entity, String orderType, String instructionDate, String settlementDate, String currencyCode) {
		super();
		this.entity = entity;
		this.orderType = setOrderTypeEnum(orderType);
		this.instructionDate = getDateStringIntoLocal(instructionDate);
		this.settlementDate = getDateStringIntoLocal(settlementDate);
		
	}

	private LocalDate getDateStringIntoLocal(String date){
		return GenericUtil.convertStringIntoDate(date);
	}

	private StockPrice createStockPrice(String currencyCode, String agreedFx, String units, String pricePerUnit ) {
		return new StockPrice(currencyCode, new BigDecimal(agreedFx), Integer.parseInt(units), new BigDecimal(pricePerUnit));
	}



	private OrderType setOrderTypeEnum(String orderType) {
			
		if( orderType == null){
			return null;
		}
		return OrderType.valueOf(orderType);
	
	}

	public Stock(String[] lineArray) {
		this.entity = lineArray[0]; //
		
	}


	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}
	/**
	 * @return the tradeType
	 */
	public OrderType getOrderType() {
		return orderType;
	}
	/**
	 * @param tradeType the tradeType to set
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	
	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}
	/**
	 * @return the settlementDate
	 */
	public LocalDate getSettlementDate() {
		return settlementDate;
	}
	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	/**
	 * @return the updatedSettlementDate
	 */
	public LocalDate getUpdatedSettlementDate() {
		return updatedSettlementDate;
	}
	/**
	 * @param updatedSettlementDate the weekDaySettlementDate to set
	 */
	public void setUpdatedSettlementDate(LocalDate updatedSettlementDate) {
		this.updatedSettlementDate = updatedSettlementDate;
	}



	/**
	 * @return the stockPrice
	 */
	public StockPrice getStockPrice() {
		return stockPrice;
	}



	/**
	 * @param stockPrice the stockPrice to set
	 */
	public void setStockPrice(StockPrice stockPrice) {
		this.stockPrice = stockPrice;
	}

	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return this.stockPrice.getAgreedFx();
	}
	
	/**
	 * @return the pricePerUnit
	 */
	public BigDecimal getPricePerUnit() {
		return this.stockPrice.getPricePerUnit();
	}
	
	/**
	 * @return the units
	 */
	public int getUnits() {
		return this.stockPrice.getUnits();
	}
	
	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return this.stockPrice.getCurrencyCode();
	}
	
	/**
	 * @return the totalTradeAmt
	 */
	public BigDecimal getTotalTradeAmt() {
		return this.stockPrice.getTotalTradeAmt();
	}

	/**
	 * @param totalTradeAmt the totalTradeAmt to set
	 */
	public void setTotalTradeAmt(BigDecimal totalTradeAmt) {
		this.stockPrice.setTotalTradeAmt(totalTradeAmt);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [entity=");
		builder.append(entity);
		builder.append(", orderType=");
		builder.append(orderType);
		builder.append(", instructionDate=");
		builder.append(instructionDate);
		builder.append(", settlementDate=");
		builder.append(settlementDate);
		builder.append(", updatedSettlementDate=");
		builder.append(updatedSettlementDate);
		builder.append(", stockPrice=");
		builder.append(stockPrice);
		builder.append("]");
		return builder.toString();
	}	
	
	
	
	
}
