/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.exception;

/**
 * The Class BaseAppException.
 *
 * @author suresh
 */
public class BaseAppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Error message code
     */
    private String errorCode;

    /**
     * detail
     */
    private String detail;

    /**
     * Instantiates a new base app exception.
     *
     * @param message            the message
     * @param throwable            the throwable
     */
    public BaseAppException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    /**
     * Constructor.
     */
    public BaseAppException() {
        super();

    }

    /**
     * Constructor.
     * 
     * @param errorCode
     *            the errorCode
     * @param message
     *            the message
     */
    public BaseAppException(String errorCode, String message) {
        super();
        this.errorCode = errorCode;

    }
   
    /**
     * Instantiates a new base app exception.
     *
     * @param errorCode 				the errorCode
     * @param message            the message
     * @param throwable            the throwable
     */
    public BaseAppException(String errorCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode = errorCode;
    }

    /**
     * Constructor.
     * 
     * @param message
     *            the message
     */
    public BaseAppException(String message) {
        super(message);

    }

    /**
     * Constructor.
     * 
     * @param cause
     *            the cause
     */
    public BaseAppException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Instantiates a new base app exception.
     *
     * @param errorCode the errorCode
     * @param message the message
     * @param detail the detail
     */

    public BaseAppException(String errorCode, String message, String detail) {
    	 super();
         this.errorCode = errorCode;
         this.detail = detail;
	}

	
    /**
     * Prints the exception stack trace.
     */
    @Override
	public void printStackTrace() {
    }


    /**
     * Gets the error code.
     * 
     * @return errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

	/**
	 * Gets the detail.
	 *
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * Sets the detail.
	 *
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	
}