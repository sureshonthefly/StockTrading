/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.action;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;

public interface IProcessStockData {

	/**
	 * The method is to process Incoming Day amount based on date
	 * @param stocks The incoming stock data to process
	 * @return date with sumTotal
	 */
	Map<LocalDate, BigDecimal> computeIncomingDayAmout(List<Stock> stocks);

	/**
	 * The method is to process Outgoing Day amount based on date
	 * @param stocks The incoming stock data to process
	 * @return date with sumTotal
	 */
	Map<LocalDate, BigDecimal> computeOutgoingDayAmout(List<Stock> stocks);

	/**
	 * The method is to process Incoming Day Raking based on Entity for a day
	 * @param stocks The incoming stock data to process
	 * @return StockRanking object list
	 */
	List<StockRanking> computeIncomingDayRanking(List<Stock> stocks);

	/**
	 * The method is to process Outgoing Day Raking based on Entity for a day
	 * @param stocks The incoming stock data to process
	 * @return StockRanking object list
	 */
	List<StockRanking> computeOutgoingDayRanking(List<Stock> stocks);

}