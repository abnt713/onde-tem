package org.ondetem.exceptions;

/** Exception superclass to represent an error caused by an client of a service */
public class ClientError extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientError() {
		super();
	}
	public ClientError(String message, Throwable cause) {
		super(message, cause);
	}
	public ClientError(String message) {
		super(message);
	}
	public ClientError(Throwable cause) {
		super(cause);
	}
}
