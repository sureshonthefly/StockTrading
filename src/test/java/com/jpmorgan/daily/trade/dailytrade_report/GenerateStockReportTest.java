/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.dailytrade_report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.daily.trade.action.IPreprocessStockData;
import com.jpmorgan.daily.trade.action.PreprocessStockDataAction;
import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;
import com.jpmorgan.daily.trade.report.GenerateStockReport;

/**
 * @author suresh
 *
 */
public class GenerateStockReportTest {

	private final List<Stock> stocks = new ArrayList<Stock>();
	private ProcessStockDataAction stockDataAction;
	private GenerateStockReport generateStockReport;
	
	/**
	 * @throws java.lang.Exception
	 */
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
		stockDataAction = new ProcessStockDataAction();
		generateStockReport = new GenerateStockReport();
		IPreprocessStockData prePrcessRequiredData = new PreprocessStockDataAction();
		prePrcessRequiredData.prePopulatedRequiredData(stocks);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		stocks.clear();
		stockDataAction = null;
		generateStockReport = null;
	}

	@Test
	public void computeIncomingDayAmoutSuccessTest() {
		try{
			Map<LocalDate, BigDecimal> stockObjMap=  stockDataAction.computeIncomingDayAmout(stocks);
			BigDecimal expected = new BigDecimal("200.0");
			assertEquals(expected, stockObjMap.get(LocalDate.of(2016, 01, 11)));			
			generateStockReport.generateInComingDayAmoutReport(stockObjMap);
		}catch(Exception ex){
			fail("Exception accured while generating report");
		}
	}
		
	@Test
	public void computeOutgoingDayAmoutSuccessTest() {
		try{
			Map<LocalDate, BigDecimal> result =  stockDataAction.computeOutgoingDayAmout(stocks);
			BigDecimal expected = new BigDecimal("200.0");
			assertEquals(expected, result.get(LocalDate.of(2016, 01, 11)));
			generateStockReport.generateOutgoingDayAmoutReport(result);
		}catch(Exception ex){
			fail("Exception accured while generating report");
		}
	}
	
	@Test
	public void computeIncomingDayRankingSuccessTest() {
		try{
			List<StockRanking> ranking  = stockDataAction.computeIncomingDayRanking(stocks);
			int expected =1;
			assertEquals(expected, ranking.get(0).getCounter());
			generateStockReport.generateIncomingRankingReport(ranking);
		}catch(Exception ex){
			fail("Exception accured while generating report");
		}
	}

	@Test
	public void computeOutgoingDaySuccessRankingTest() {
		try{
			List<StockRanking> ranking  = stockDataAction.computeIncomingDayRanking(stocks);
			int expected =1;
			assertEquals(expected, ranking.get(0).getCounter());
			generateStockReport.generateOutgoingRankingReport(ranking);
		}catch(Exception ex){
			fail("Exception accured while generating report");
		}
	}
	

	
}
