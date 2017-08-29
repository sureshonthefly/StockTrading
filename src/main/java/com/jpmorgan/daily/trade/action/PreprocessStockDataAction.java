package com.jpmorgan.daily.trade.action;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jpmorgan.daily.trade.model.Stock;
import com.jpmorgan.daily.trade.util.GenericUtil;

public class PreprocessStockDataAction {

	public void prePopulatedRequiredData(List<Stock> stocks){
		stocks.stream().forEach(stock -> {
			populateUpdatedSettleMentDate(stock);
			computeStockTotalAmout(stock);
		});
	}
		
	private void populateUpdatedSettleMentDate(Stock stock){
		LocalDate date = GenericUtil.upateSettlementDate(stock.getSettlementDate(), stock.getCurrencyCode());
		stock.setUpdatedSettlementDate(date);
	}
	
	private void computeStockTotalAmout(Stock stock){		
		BigDecimal totalTradeAmt = computeTotalTradeAmt(stock.getAgreedFx(), stock.getUnits(),stock.getPricePerUnit());
		stock.setTotalTradeAmt(totalTradeAmt);
	}
	
	private BigDecimal computeTotalTradeAmt(BigDecimal agreedFx,int units, BigDecimal pricePerUnit) {
		return agreedFx.multiply(pricePerUnit).multiply(BigDecimal.valueOf(units));
	}
}
