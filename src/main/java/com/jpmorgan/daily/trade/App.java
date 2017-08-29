/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jpmorgan.daily.trade.action.IInitializeStockData;
import com.jpmorgan.daily.trade.action.IPreprocessStockData;
import com.jpmorgan.daily.trade.action.IProcessStockData;
import com.jpmorgan.daily.trade.action.PreprocessStockDataAction;
import com.jpmorgan.daily.trade.constant.Constants;
import com.jpmorgan.daily.trade.exception.StockTradingException;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;
import com.jpmorgan.daily.trade.report.IGenerateStockReport;

/**
 * Main entry point of the Stock Report applications
 *
 */
public class App {
	
	static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		
		// Load the input data from CSV file by assigning to Java object
		IInitializeStockData prepareData = (IInitializeStockData) Factory.newInstance(Constants.INIT);
		List<Stock> stocks = null;
		try {
			stocks = prepareData.loadStockData();
		} catch (Exception e) {
			logger.error(Constants.ERROR_GENERATING_SAMPLE_DATA + e.getMessage());
			return;
		}
		
		//Pre Process the stock trade data
		try{
			IPreprocessStockData prePrcessRequiredData = (PreprocessStockDataAction)Factory.newInstance(Constants.PREPROCESS);
			prePrcessRequiredData.prePopulatedRequiredData(stocks);
			
		}catch(Exception e){
			logger.error(Constants.ERROR_PRE_PROCESS_SAMPLE_DATA + e.getMessage());
			return;
		}
		
		
		//Process the stock data and Generate the report		
		IProcessStockData iProcessStockData = (IProcessStockData) Factory.newInstance(Constants.PROCESS);
		IGenerateStockReport generateReport = (IGenerateStockReport) Factory.newInstance(Constants.REPORT);
		
		computeStockTradeDayAmountIncoming(iProcessStockData,generateReport,stocks);
		computeStockTradeDayAmountOutgoing(iProcessStockData,generateReport,stocks);
		computeStockTradeDayRankingIncoming(iProcessStockData,generateReport,stocks);
		computeStockTradeDayRankingOutgoing(iProcessStockData,generateReport,stocks);
	}
	
	/**
	 * 
	 * @param processStockData the object of ProcessStockData
	 * @param generateReport the object of GenerateStockReport
	 * @param stocks the list of stock data
	 */
	public static void computeStockTradeDayAmountIncoming(IProcessStockData processStockData,
			IGenerateStockReport generateReport,
			List<Stock> stocks){
		try{
			Map<LocalDate, BigDecimal> computeIncomingData  = processStockData.computeIncomingDayAmout(stocks);			
			generateReport.generateInComingDayAmoutReport(computeIncomingData);
		}catch(StockTradingException e){
			logger.error(Constants.ERROR_INCOMING_STOCK_TRADING_AMOUNT, e);
		}
	}
	
	/**
	 * 
	 * @param processStockData the object of ProcessStockData
	 * @param generateReport the object of GenerateStockReport
	 * @param stocks the list of stock data
	 */
	public static void computeStockTradeDayAmountOutgoing(IProcessStockData processStockData,
			IGenerateStockReport generateReport,
			List<Stock> stocks){
		try{
			Map<LocalDate, BigDecimal> computeOutgoingData  = processStockData.computeOutgoingDayAmout(stocks);			
			generateReport.generateOutgoingDayAmoutReport(computeOutgoingData);
		}catch(StockTradingException e){
			logger.error(Constants.ERROR_OUTGOING_STOCK_TRADING_AMOUNT, e);
		}
	}
	
	/**
	 * 
	 * @param processStockData the object of ProcessStockData
	 * @param generateReport the object of GenerateStockReport
	 * @param stocks the list of stock data
	 */
	public static void computeStockTradeDayRankingIncoming(IProcessStockData processStockData,
			IGenerateStockReport generateReport,
			List<Stock> stocks){
		try{
			List<StockRanking> stockRankingList  = processStockData.computeIncomingDayRanking(stocks);
			generateReport.generateIncomingRankingReport(stockRankingList);
		}catch(StockTradingException e){
			logger.error(Constants.ERROR_INCOMING_RANKING_ENTITY, e);
		}
	}
	
	/**
	 * 
	 * @param processStockData the object of ProcessStockData
	 * @param generateReport the object of GenerateStockReport
	 * @param stocks the list of stock data
	 */
	public static void computeStockTradeDayRankingOutgoing(IProcessStockData processStockData,
			IGenerateStockReport generateReport,
			List<Stock> stocks){
		try{
			List<StockRanking> stockRankingList  = processStockData.computeOutgoingDayRanking(stocks);
			generateReport.generateOutgoingRankingReport(stockRankingList);
		}catch(StockTradingException e){
			logger.error(Constants.ERROR_COMPUTING_OUTGOING_RANKING_ENTITY, e);
		}
	}
}
