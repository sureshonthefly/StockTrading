/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StockRanking {

	int counter;
	LocalDate date;
	String entity;
	
	
	/**
	 * @param counter
	 * @param entity
	 * @param date
	 */
	public StockRanking(int counter, String entity, LocalDate date) {
		super();
		this.counter = counter;
		this.date = date;
		this.entity = entity;
	}
	public StockRanking(int andIncrement, BigDecimal bigDecimal, LocalDate key) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockRanking [counter=");
		builder.append(counter);
		builder.append(", date=");
		builder.append(date);
		builder.append(", entity=");
		builder.append(entity);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
