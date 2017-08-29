package com.jpmorgan.daily.trade.action;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.daily.trade.model.Stock;

/**
 * Input Stock Market Data
 * @author suresh
 *
 */
public class InitializeStockDataAction {

	public List<Stock> loadStockData() {
		
		List<Stock> stocks = new ArrayList<Stock>();
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
		
		return stocks;
	}
}
