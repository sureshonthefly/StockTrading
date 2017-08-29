package com.jpmorgan.daily.trade;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jpmorgan.daily.trade.action.InitializeStockDataAction;
import com.jpmorgan.daily.trade.action.PreprocessStockDataAction;
import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.constant.Contants;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.report.GenerateStockReport;

/**
 * Main entry point of the Stock Report applications
 *
 */
public class App {
	static {
		// Log4j file path
		PropertyConfigurator.configure(
				"/Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/src/main/resource/log4j.properties");
	}
	static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		// Load the input data from CSV file by assigning to Java object
		InitializeStockDataAction prepareData = new InitializeStockDataAction();
		List<Stock> stocks = null;
		try {
			stocks = prepareData.loadStockData();
		} catch (Exception e) {
			logger.debug("Input File path is not valid : " + e.getMessage());
			return;
		}

		//Pre Populate required data
		PreprocessStockDataAction prePrcessRequiredData = new PreprocessStockDataAction();
		prePrcessRequiredData.prePopulatedRequiredData(stocks);
		
		//Process the stock data and Generate the report
		GenerateStockReport.generateInComingDayAmoutReport((ProcessStockDataAction.computeIncomingDayAmout(stocks)));
		logger.debug(Contants.NEWLINE);
		GenerateStockReport.generateOutgoingDayAmoutReport((ProcessStockDataAction.computeOutgoingDayAmout(stocks)));
		logger.debug(Contants.NEWLINE);
		GenerateStockReport.generateIncomingRankingReport((ProcessStockDataAction.computeIncomingDayRanking(stocks)));
		logger.debug(Contants.NEWLINE);
		GenerateStockReport.generateOutgoingRankingReport((ProcessStockDataAction.computeOutgoingDayRanking(stocks)));
	}
}
