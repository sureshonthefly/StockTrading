/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.constant;

public abstract class Constants {

	/**
	 * Class Instance Related Strings
	 */
	public static final String INIT ="INIT";
	public static final String PREPROCESS ="PREPROCESS";
	public static final String PROCESS ="PROCESS";
	public static final String REPORT ="REPORT";
	
	/**
	 * Below are Application specific strings
	 */
	public static final String NEWLINE="\n";
	public static final String DATE="Date      ";
	public static final String COLON="   :  ";
	public static final String TOTAL_AMOUNT="Total Amount";
	public static final String RANK="Rank";
	public static final String ENTITY="Enitity";
	public static final String AMT_OUTGOING_DAY="Amount in USD settled outgoing (BUY) everyday:";
	public static final String AMT_INCOMING_DAY="Amount in USD settled incoming (SELL) everyday:";
	public static final String RANKING_ENTITY_OUTGOING_DAY="Ranking of entities based on outgoing (BUY) amount:";
	public static final String RANKING_ENTITY_INCOMING_DAY="Ranking of entities based on incoming (SELL) amount:";
	
	
	/**
	 * Below are exception messages
	 */
	public static final String ERROR_COMPUTING_OUTGOING_RANKING_ENTITY = "Unexpected error while computing Outgoing Ranking on Entity  {} ";
	public static final String ERROR_INCOMING_RANKING_ENTITY = "Unexpected error while computing Incoming Ranking on Entity  {} ";
	public static final String ERROR_OUTGOING_STOCK_TRADING_AMOUNT = "Unexpected error while computing Outgoing Stock Trading on Amount  {} ";
	public static final String ERROR_INCOMING_STOCK_TRADING_AMOUNT = "Unexpected error while computing Incoming Stock Trading on Amount  {} ";
	public static final String ERROR_GENERATING_SAMPLE_DATA = "Unexpected error while generating sample data : ";
	public static final String ERROR_PRE_PROCESS_SAMPLE_DATA = "Unexpected error while pre process sample data : ";
	public static final String ERROR_IN_CREATING_OBJECTS = "Unexpected error while creating objects : ";

}
