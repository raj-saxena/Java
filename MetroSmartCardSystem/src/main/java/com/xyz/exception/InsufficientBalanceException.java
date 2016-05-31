package com.xyz.exception;

/**
 * Created by raj on 17/4/16.
 */
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
