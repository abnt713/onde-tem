package org.ondetem.exceptions;

public class DatabaseError extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseError() {
		super();
	}
	public DatabaseError(String message, Throwable cause) {
		super(message, cause);
	}
	public DatabaseError(String message) {
		super(message);
	}
	public DatabaseError(Throwable cause) {
		super(cause);
	}
}
