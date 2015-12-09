package org.ondetem.exceptions;

public class MemberNotExistError extends ClientError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberNotExistError() {
		super();
	}
	public MemberNotExistError(String message, Throwable cause) {
		super(message, cause);
	}
	public MemberNotExistError(String message) {
		super(message);
	}
	public MemberNotExistError(Throwable cause) {
		super(cause);
	}
}
