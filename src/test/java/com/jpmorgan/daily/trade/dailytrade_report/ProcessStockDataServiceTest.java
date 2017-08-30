/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.dailytrade_report;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.daily.trade.action.IPreprocessStockData;
import com.jpmorgan.daily.trade.action.PreprocessStockDataAction;
import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.model.OrderType;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;
import com.jpmorgan.daily.trade.service.IProcessStockDataService;
import com.jpmorgan.daily.trade.service.ProcessStockDataService;

public class ProcessStockDataServiceTest {

	private final List<Stock> stocks = new ArrayList<Stock>();
	private IProcessStockDataService processStockDataService;
	/**
	 * Condition to filter the Outgoing (BUT)
	 */
	private static Predicate<Stock> predicateOutgoing = data -> data.getOrderType().equals(OrderType.B);

	/**
	 * Condition to filter the Incoming (SELL)
	 */
	private static Predicate<Stock> predicateIncoming = data -> data.getOrderType().equals(OrderType.S);
	
	@Before
	public void setUp() throws Exception {
		Stock es1 = new Stock("ES1","S","0.5","USD","07 Jan 2016","08 Jan 2016","10","10");
		Stock es2 = new Stock("ES2","S","0.5","USD","08 Jan 2016","09 Jan 2016","20","10");
		Stock es3 = new Stock("ES3","S","0.5","USD","08 Jan 2016","09 Jan 2016","20","10");
		
		Stock eb1 = new Stock("EB1","B","0.5","USD","07 Jan 2016","08 Jan 2016","10","10");
		Stock eb2 = new Stock("EB2","B","0.5","USD","08 Jan 2016","09 Jan 2016","20","10");
		Stock eb3 = new Stock("ES3","B","0.5","USD","08 Jan 2016","09 Jan 2016","20","10");
		
		stocks.add(es1);
		stocks.add(es2);
		stocks.add(es3);
		stocks.add(eb1);
		stocks.add(eb2);
		stocks.add(eb3);
		processStockDataService = new ProcessStockDataService();
		IPreprocessStockData prePrcessRequiredData = new PreprocessStockDataAction();
		prePrcessRequiredData.prePopulatedRequiredData(stocks);
	}

	@After
	public void tearDown() throws Exception {
		stocks.clear();
	}

	@Test
	public void computeDayAmoutTransactionIncomingTest() {
		Map<LocalDate, BigDecimal> result=  processStockDataService.computeDayAmoutTransaction(stocks, predicateIncoming);
		BigDecimal expected = new BigDecimal("200.0");
		assertEquals(expected, result.get(LocalDate.of(2016, 01, 11)));
	}
	
	@Test
	public void computeDayAmoutTransactionOutgoingTest() {
		Map<LocalDate, BigDecimal> result=  processStockDataService.computeDayAmoutTransaction(stocks, predicateOutgoing);
		BigDecimal expected = new BigDecimal("200.0");
		assertEquals(expected, result.get(LocalDate.of(2016, 01, 11)));
	}
	

	@Test
	public void computeDayRankingIncomingTest() {
		List<StockRanking> ranking  =   processStockDataService.computeDayRanking(stocks, predicateIncoming);
		int expected =1;
		assertEquals(expected, ranking.get(0).getCounter());
	}
	
	@Test
	public void computeDayRankingOutgoingTest() {
		List<StockRanking> ranking  =   processStockDataService.computeDayRanking(stocks, predicateOutgoing);
		int expected =1;
		assertEquals(expected, ranking.get(0).getCounter());
	}
}
