/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.action;

import java.util.List;

import com.jpmorgan.daily.trade.model.Stock;

public interface IInitializeStockData {

	List<Stock> loadStockData();

}