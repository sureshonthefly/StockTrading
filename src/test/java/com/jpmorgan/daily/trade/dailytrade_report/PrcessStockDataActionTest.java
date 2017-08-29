package com.jpmorgan.daily.trade.dailytrade_report;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.daily.trade.action.PreprocessStockDataAction;
import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;

public class PrcessStockDataActionTest {

	final List<Stock> stocks = new ArrayList<Stock>();
	final List<Stock> stocksDummy = new ArrayList<Stock>();
	
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
		
		PreprocessStockDataAction prePrcessRequiredData = new PreprocessStockDataAction();
		prePrcessRequiredData.prePopulatedRequiredData(stocks);
	}

	@After
	public void tearDown() throws Exception {
		stocks.clear();
	}

	@Test
	public void computeIncomingDayAmoutSuccessTest() {
		Map<LocalDate, BigDecimal> result=  ProcessStockDataAction.computeIncomingDayAmout(stocks);
		BigDecimal expected = new BigDecimal("200.0");
		assertEquals(expected, result.get(LocalDate.of(2016, 01, 11)));
	}
	
	@Test
	public void computeIncomingDayAmoutNegativeTest() {
		Map<LocalDate, BigDecimal> result=  ProcessStockDataAction.computeIncomingDayAmout(stocksDummy);
		assertEquals(0, result.size());
	}

	@Test
	public void computeOutgoingDayAmoutSuccessTest() {
		Map<LocalDate, BigDecimal> result =  ProcessStockDataAction.computeOutgoingDayAmout(stocks);
		BigDecimal expected = new BigDecimal("200.0");
		assertEquals(expected, result.get(LocalDate.of(2016, 01, 11)));
	}
	
	@Test
	public void computeOutgoingDayAmoutFailureTest() {
		Map<LocalDate, BigDecimal> result =  ProcessStockDataAction.computeOutgoingDayAmout(stocksDummy);
		assertEquals(0, result.size());
	}
	
	@Test
	public void computeIncomingDayRankingSuccessTest() {
		List<StockRanking> ranking  = ProcessStockDataAction.computeIncomingDayRanking(stocks);
		int expected =1;
		assertEquals(expected, ranking.get(0).getCounter());
	}
	
	@Test
	public void computeIncomingDayRankingNegativeTest() {
		List<StockRanking> ranking  = ProcessStockDataAction.computeIncomingDayRanking(stocksDummy);
		assertEquals(0, ranking.size());
	}

	@Test
	public void computeOutgoingDaySuccessRankingTest() {
		List<StockRanking> ranking  = ProcessStockDataAction.computeIncomingDayRanking(stocks);
		int expected =1;
		assertEquals(expected, ranking.get(0).getCounter());
	}
	
	@Test
	public void computeOutgoingDayNegativeRankingTest() {
		List<StockRanking> ranking  = ProcessStockDataAction.computeIncomingDayRanking(stocksDummy);
		assertEquals(0, ranking.size());
	}

}
