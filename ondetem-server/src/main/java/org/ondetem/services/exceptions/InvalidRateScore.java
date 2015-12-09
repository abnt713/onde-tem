package org.ondetem.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid rate score")
public class InvalidRateScore extends RuntimeException{

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
