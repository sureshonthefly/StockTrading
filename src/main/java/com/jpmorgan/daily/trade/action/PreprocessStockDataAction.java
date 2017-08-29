/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.action;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jpmorgan.daily.trade.exception.StockTradingException;
import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.util.GenericUtil;

public class PreprocessStockDataAction implements IPreprocessStockData {

	/* (non-Javadoc)
	 * @see com.jpmorgan.daily.trade.action.IPreprocessStockData#prePopulatedRequiredData(java.util.List)
	 */
	@Override
	public void prePopulatedRequiredData(List<Stock> stocks) throws StockTradingException {
		stocks.stream().forEach(stock -> {
			populateUpdatedSettleMentDate(stock);
			computeStockTotalAmout(stock);
		});
	}
		
	private void populateUpdatedSettleMentDate(Stock stock) throws StockTradingException{
		LocalDate date = GenericUtil.upateSettlementDate(stock.getSettlementDate(), stock.getCurrencyCode());
		stock.setUpdatedSettlementDate(date);
	}
	
	private void computeStockTotalAmout(Stock stock) throws StockTradingException{		
		BigDecimal totalTradeAmt = computeTotalTradeAmt(stock.getAgreedFx(), stock.getUnits(),stock.getPricePerUnit());
		stock.setTotalTradeAmt(totalTradeAmt);
	}
	
	private BigDecimal computeTotalTradeAmt(BigDecimal agreedFx,int units, BigDecimal pricePerUnit) throws StockTradingException {
		return agreedFx.multiply(pricePerUnit).multiply(BigDecimal.valueOf(units));
	}
}
