package se.kth.iv1350.pos.integration;

/**
 * Exception class thrown when there was a database failure.
 * @author William
 *
 */
@SuppressWarnings("serial")
public class DatabaseFailureException extends RuntimeException {

	/**
	 * @param msg the informative error message.
	 */
	public DatabaseFailureException(String msg) {
		super(msg);
	}
}
