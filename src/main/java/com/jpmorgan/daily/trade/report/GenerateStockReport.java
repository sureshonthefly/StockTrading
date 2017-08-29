/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.report;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.constant.Constants;
import com.jpmorgan.daily.trade.model.StockRanking;

/**
 * Generating reports for stocks data
 * @author suresh
 *
 */
public class GenerateStockReport implements IGenerateStockReport {

	static final Logger logger = Logger.getLogger(ProcessStockDataAction.class);

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.report.IGenerateStockReport#generateOutgoingDayAmoutReport(java.util.Map)
	 */
	@Override
	public void generateOutgoingDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap) {
		logger.debug(Constants.AMT_OUTGOING_DAY);
		generateDayAmoutReport(stockObjMap);
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.report.IGenerateStockReport#generateInComingDayAmoutReport(java.util.Map)
	 */
	@Override
	public void generateInComingDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap) {
		logger.debug(Constants.AMT_INCOMING_DAY);
		generateDayAmoutReport(stockObjMap);
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.report.IGenerateStockReport#generateOutgoingRankingReport(java.util.List)
	 */
	@Override
	public void generateOutgoingRankingReport(List<StockRanking> stockRankObj) {
		logger.debug(Constants.RANKING_ENTITY_OUTGOING_DAY);
		generateDayRankingReport(stockRankObj);
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.report.IGenerateStockReport#generateIncomingRankingReport(java.util.List)
	 */
	@Override
	public void generateIncomingRankingReport(List<StockRanking> stockRankObj) {
		logger.debug(Constants.RANKING_ENTITY_INCOMING_DAY);
		generateDayRankingReport(stockRankObj);
	}

	/**
	 * Generate Report based on date with amount
	 * @param stockObjMap contains date with total amount
	 */
	private static void generateDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Constants.DATE).append(Constants.COLON).append(Constants.TOTAL_AMOUNT);

		for (Map.Entry<LocalDate, BigDecimal> obj : stockObjMap.entrySet()) {
			stringBuilder.append(Constants.NEWLINE).append(obj.getKey()).append(Constants.COLON)
					.append(obj.getValue().setScale(2, RoundingMode.CEILING));
		}

		logger.debug(stringBuilder);
	}

	/**
	 * Generate Report for day ranking based on entity
	 * @param stockRankObj objects to display stock ranks based on entity
	 */
	private static void generateDayRankingReport(List<StockRanking> stockRankObj) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Constants.RANK).append(Constants.COLON).append(Constants.ENTITY).append(Constants.COLON)
				.append(Constants.DATE);
		for (StockRanking obj : stockRankObj) {
			stringBuilder.append(Constants.NEWLINE).append(obj.getCounter()).append(Constants.COLON)
					.append(obj.getEntity()).append(Constants.COLON).append(obj.getDate());
		}
		logger.debug(stringBuilder);
	}
}
