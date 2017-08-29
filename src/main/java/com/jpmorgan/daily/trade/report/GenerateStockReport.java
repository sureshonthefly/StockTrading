package com.jpmorgan.daily.trade.report;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.constant.Contants;
import com.jpmorgan.daily.trade.model.StockRanking;

/**
 * Generating reports for stocks data
 * @author suresh
 *
 */
public class GenerateStockReport {

	static final Logger logger = Logger.getLogger(ProcessStockDataAction.class);

	/**
	 * Generate Report for Outgoing (BUY) day amount
	 * @param stockObjMap contains date with tatal amount
	 */
	public static void generateOutgoingDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap) {
		logger.debug(Contants.AMT_OUTGOING_DAY);
		generateDayAmoutReport(stockObjMap);
	}

	/**
	 * Generate Report for Incoming (SELL) day amount
	 * @param stockObjMap contains date with total amount
	 */
	public static void generateInComingDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap) {
		logger.debug(Contants.AMT_INCOMING_DAY);
		generateDayAmoutReport(stockObjMap);
	}

	/**
	 * Generate Report for Outgoing (BUY) day ranking
	 * @param stockRankObj objects to display stock ranks based on entity
	 */
	public static void generateOutgoingRankingReport(List<StockRanking> stockRankObj) {
		logger.debug(Contants.RANKING_ENTITY_OUTGOING_DAY);
		generateDayRankingReport(stockRankObj);
	}

	/**
	 * Generate Report for Outgoing (BUY) day ranking
	 * @param stockRankObj objects to display stock ranks based on entity
	 */
	public static void generateIncomingRankingReport(List<StockRanking> stockRankObj) {
		logger.debug(Contants.RANKING_ENTITY_INCOMING_DAY);
		generateDayRankingReport(stockRankObj);
	}

	/**
	 * Generate Report based on date with amount
	 * @param stockObjMap contains date with total amount
	 */
	private static void generateDayAmoutReport(Map<LocalDate, BigDecimal> stockObjMap) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Contants.DATE).append(Contants.COLON).append(Contants.TOTAL_AMOUNT);

		for (Map.Entry<LocalDate, BigDecimal> obj : stockObjMap.entrySet()) {
			stringBuilder.append(Contants.NEWLINE).append(obj.getKey()).append(Contants.COLON)
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
		stringBuilder.append(Contants.RANK).append(Contants.COLON).append(Contants.ENTITY).append(Contants.COLON)
				.append(Contants.DATE);
		for (StockRanking obj : stockRankObj) {
			stringBuilder.append(Contants.NEWLINE).append(obj.getCounter()).append(Contants.COLON)
					.append(obj.getEntity()).append(Contants.COLON).append(obj.getDate());
		}
		logger.debug(stringBuilder);
	}
}
