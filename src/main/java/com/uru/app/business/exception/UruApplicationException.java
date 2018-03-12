package com.uru.app.business.exception;

public class UruApplicationException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;
	
	public UruApplicationException() {
		super();
	}
	
	public UruApplicationException(String msg) {
		super(msg);
	}
	
	public UruApplicationException(Throwable cause) {
		super(cause);
	}
	
	public UruApplicationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
