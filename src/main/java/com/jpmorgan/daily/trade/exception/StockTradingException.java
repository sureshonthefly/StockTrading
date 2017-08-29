/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.exception;

import java.io.Serializable;

/**
 * @author suresh
 *
 */
public class StockTradingException extends RuntimeException implements Serializable{

	 /**
    *
    */
   private static final long serialVersionUID = 3154644682440209451L;

   private String errorKey;

   private String errorDescription;

   private String additionalMessage;

   private Exception t;

   /**
    * Instantiates a new market place registration exception.
    *
    * @param errorKey the error key
    * @param errorDescription the error description
    */
   public StockTradingException(String errorKey, String errorDescription) {
       this.errorKey = errorKey;
       this.errorDescription = errorDescription;
   }

   /**
    * Instantiates a new market place registration exception.
    *
    * @param errorKey the error key
    * @param errorDescription the error description
    * @param additionalMessage the additional message
    */
   public StockTradingException(String errorKey, String errorDescription, String additionalMessage) {
       this.errorKey = errorKey;
       this.errorDescription = errorDescription;
       this.additionalMessage = additionalMessage;
   }

   /**
    * Instantiates a new market place registration exception.
    *
    * @param errorKey the error key
    * @param errorDescription the error description
    * @param t the t
    */
   public StockTradingException(String errorKey, String errorDescription, Exception t) {
       this.errorKey = errorKey;
       this.errorDescription = errorDescription;
       this.t = t;
   }

   /**
    * Instantiates a new market place registration exception.
    *
    * @param errorKey the error key
    * @param errorDescription the error description
    * @param t the t
    * @param additionalMessage the additional message
    */
   public StockTradingException(String errorKey, String errorDescription, Exception t, String additionalMessage) {
       this.errorKey = errorKey;
       this.errorDescription = errorDescription;
       this.t = t;
       this.additionalMessage = additionalMessage;
   }


   /**
    * Instantiates a new market place registration exception.
    */
   public StockTradingException() {

   }

   /**
    * Instantiates a new market place registration exception.
    *
    * @param t the t
    */
   public StockTradingException(Exception t) {
       this.t = t;
   }

   /**
    * Gets the additional message.
    *
    * @return the additional message
    */
   public String getAdditionalMessage() {
       return additionalMessage;
   }

   /**
    * Sets the additional message.
    *
    * @param additionalMessage the new additional message
    */
   public void setAdditionalMessage(String additionalMessage) {
       this.additionalMessage = additionalMessage;
   }

   /**
    * Gets the t.
    *
    * @return the t
    */
   public Exception getT() {
       return t;
   }

   /**
    * Sets the t.
    *
    * @param t the new t
    */
   public void setT(Exception t) {
       this.t = t;
   }

   /**
    * Gets the error key.
    *
    * @return the error key
    */
   public String getErrorKey() {
       return errorKey;
   }

   /**
    * Sets the error key.
    *
    * @param errorKey the new error key
    */
   public void setErrorKey(String errorKey) {
       this.errorKey = errorKey;
   }

   /**
    * Gets the error description.
    *
    * @return the error description
    */
   public String getErrorDescription() {
       return errorDescription;
   }

   /**
    * Sets the error description.
    *
    * @param errorDescription the new error description
    */
   public void setErrorDescription(String errorDescription) {
       this.errorDescription = errorDescription;
   }

}
