package org.schiano.e_commerce.error.exceptions;

public class NessunRisultatoException extends RuntimeException {	//o Exception, ma spring gestisce meglio
    /**																//e non serve il throws nelle firme
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NessunRisultatoException(String message) {
        super(message);
    }
}
