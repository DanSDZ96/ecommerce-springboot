package org.schiano.e_commerce.error.exceptions;

public class ProdottoNonTrovatoException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9061110908189753993L;

	public ProdottoNonTrovatoException(String message) {
        super(message);
    }
}
