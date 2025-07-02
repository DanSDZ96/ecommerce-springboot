package org.schiano.e_commerce.error.exceptions;

public class EmailNonValidaException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailNonValidaException(String message) {
        super(message);
    }
}
