package se.kth.iv1350.pos.controller;

/**
 * Exception class thrown when an operation from the view fails.
 * @author William
 *
 */
@SuppressWarnings("serial")
public class OperationFailedException extends RuntimeException {

	Throwable cause;
	
	/**
	 * @param cause the cause of the operand failing.
	 */
	public OperationFailedException(String msg, Throwable cause) {
		super(msg);
		this.cause = cause;
	}

	@Override
	public Throwable getCause() {
		return cause;
	}
}
