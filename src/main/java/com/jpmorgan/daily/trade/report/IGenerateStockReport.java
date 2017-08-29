/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.report;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.jpmorgan.daily.trade.model.StockRanking;

public interface IGenerateStockReport {

	/**
	 * Generate Report for Outgoing (BUY) day amount
	 * @param stockObjMap contains date with tatal amount
	 */
	void generateOutgoingDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap);

	/**
	 * Generate Report for Incoming (SELL) day amount
	 * @param stockObjMap contains date with total amount
	 */
	void generateInComingDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap);

	/**
	 * Generate Report for Outgoing (BUY) day ranking
	 * @param stockRankObj objects to display stock ranks based on entity
	 */
	void generateOutgoingRankingReport(List<StockRanking> stockRankObj);

	/**
	 * Generate Report for Outgoing (BUY) day ranking
	 * @param stockRankObj objects to display stock ranks based on entity
	 */
	void generateIncomingRankingReport(List<StockRanking> stockRankObj);

}