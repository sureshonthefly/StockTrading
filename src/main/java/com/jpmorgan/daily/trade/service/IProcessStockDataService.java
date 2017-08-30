package com.jpmorgan.daily.trade.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.jpmorgan.daily.trade.exception.StockTradingException;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;

public interface IProcessStockDataService {

	/**
	 * The method is to compute Day amount transaction for both BUY and SELL Order Type
	 * @param stocks The incoming stock data
	 * @param predicate the condition to added as part of filter
	 * @return date with sumTotal
	 */
	public Map<LocalDate, BigDecimal> computeDayAmoutTransaction(List<Stock> stocks, Predicate<Stock> predicate) 
			throws StockTradingException;
	
	/**
	 * 
	 * @param stocks The incoming stock data
	 * @param predicate the condition to added as part of filter
	 * @return stockRating object list
	 */
	public List<StockRanking> computeDayRanking(List<Stock> stocks, Predicate<Stock> predicate) 
			throws StockTradingException;
	
}