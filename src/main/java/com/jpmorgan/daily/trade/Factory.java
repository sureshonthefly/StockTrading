/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade;

import com.jpmorgan.daily.trade.action.InitializeStockDataAction;
import com.jpmorgan.daily.trade.action.PreprocessStockDataAction;
import com.jpmorgan.daily.trade.action.ProcessStockDataAction;
import com.jpmorgan.daily.trade.report.GenerateStockReport;

/**
 * @author suresh
 *
 */
public class Factory {

	public static Object newInstance(String classType) {
		Object obj = null;

		try {

			if(classType == null){
				return null;
			}else if(classType.equalsIgnoreCase("INIT")){
				return new InitializeStockDataAction();				
			}else if( classType.equalsIgnoreCase("PREPROCESS")) {
				return new PreprocessStockDataAction();
			}else if( classType.equalsIgnoreCase("PROCESS")) {
				return new ProcessStockDataAction();
			}else if(classType.equalsIgnoreCase("REPORT")){
				return new GenerateStockReport();
			}
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return obj;
	}

	
	
}
