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
import java.util.function.Predicate;

import com.jpmorgan.daily.trade.exception.StockTradingException;
import com.jpmorgan.daily.trade.model.OrderType;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;
import com.jpmorgan.daily.trade.service.ProcessStockDataService;

/**
 * @author suresh
 * The class is to process the stock data
 */
public class ProcessStockDataAction implements IProcessStockData {

	/**
	 * Condition to filter the Outgoing (BUT)
	 */
	private static Predicate<Stock> predicateOutgoing = data -> data.getOrderType().equals(OrderType.B);

	/**
	 * Condition to filter the Incoming (SELL)
	 */
	private static Predicate<Stock> predicateIncoming = data -> data.getOrderType().equals(OrderType.S);
	
	/**
	 * Stock Report service
	 */
	private static ProcessStockDataService processStockDataService = new ProcessStockDataService();
	

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.action.IProcessStockData#computeIncomingDayAmout(java.util.List)
	 */
	@Override
	public Map<LocalDate, BigDecimal> computeIncomingDayAmout(List<Stock> stocks) throws StockTradingException {
		return processStockDataService.computeDayAmoutTransaction(stocks, predicateIncoming);
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.action.IProcessStockData#computeOutgoingDayAmout(java.util.List)
	 */
	@Override
	public Map<LocalDate, BigDecimal> computeOutgoingDayAmout(List<Stock> stocks) throws StockTradingException {
		return processStockDataService.computeDayAmoutTransaction(stocks, predicateOutgoing);
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.action.IProcessStockData#computeIncomingDayRanking(java.util.List)
	 */
	@Override
	public List<StockRanking> computeIncomingDayRanking(List<Stock> stocks) throws StockTradingException {
		return processStockDataService.computeDayRanking(stocks, predicateIncoming);
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.action.IProcessStockData#computeOutgoingDayRanking(java.util.List)
	 */
	@Override
	public List<StockRanking> computeOutgoingDayRanking(List<Stock> stocks) throws StockTradingException {
		return processStockDataService.computeDayRanking(stocks, predicateOutgoing);
	}

}
