package org.ondetem.services;

import org.ondetem.exceptions.ClientError;

public class InvalidRateScore extends ClientError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRateScore() {
		super();
	}

	public InvalidRateScore(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRateScore(String message) {
		super(message);
	}

	public InvalidRateScore(Throwable cause) {
		super(cause);
	}
}
