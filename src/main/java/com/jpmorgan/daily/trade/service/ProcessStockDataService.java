/**
 * 
 */
package com.jpmorgan.daily.trade.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jpmorgan.daily.trade.exception.StockTradingException;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.model.StockRanking;

/**
 * @author suresh
 *
 */
public class ProcessStockDataService implements IProcessStockDataService {

	/**
	 * The method is to compute Day amount transaction for both BUY and SELL Order Type
	 * @param stocks The incoming stock data
	 * @param predicate the condition to added as part of filter
	 * @return date with sumTotal
	 */
	@Override
	public Map<LocalDate, BigDecimal> computeDayAmoutTransaction(List<Stock> stocks, Predicate<Stock> predicate) 
			throws StockTradingException {
		return stocks.stream()
			.filter(predicate)
			.collect(groupingBy(Stock::getUpdatedSettlementDate,
				Collectors.mapping(Stock::getTotalTradeAmt,
						Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
	}

	/**
	 * 
	 * @param stocks The incoming stock data
	 * @param predicate the condition to added as part of filter
	 * @return stockRating object list
	 */
	@Override
	public List<StockRanking> computeDayRanking(List<Stock> stocks, Predicate<Stock> predicate) 
			throws StockTradingException {
		List<StockRanking> rankingObj = new ArrayList<StockRanking>();
		stocks.stream().filter(predicate).collect(groupingBy(Stock::getUpdatedSettlementDate, toSet()))
				.forEach(computeSortingAndRanking(rankingObj));
		return rankingObj;
	}

	/**
	 * The method is to sort the based on the amount
	 * @param rankingObj the incoming ranking object
	 * @return
	 */
	private static BiConsumer<? super LocalDate, ? super Set<Stock>> computeSortingAndRanking(List<StockRanking> rankingObj) 
			throws StockTradingException{
		return (date, stocks2) -> {
			final AtomicInteger couter = new AtomicInteger(1);
			try{
				List<StockRanking> ranking = stocks2.stream()
						.sorted((obj1, obj2) -> obj2.getTotalTradeAmt().compareTo(obj1.getTotalTradeAmt()))
						.map(instruction -> new StockRanking(couter.getAndIncrement(), instruction.getEntity(), date))
						.collect(Collectors.toCollection(ArrayList::new));
				rankingObj.addAll(ranking);
			}catch(StockTradingException e){
				throw e;
			}
		};
	}
	
}
