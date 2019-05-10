package se.kth.iv1350.pos.model;

/**
 * Exception class related to invalid items.
 * @author William
 *
 */
@SuppressWarnings("serial")
public class InvalidItemException extends Exception {

	private String invalidIdentifier;
	
	/**
	 * @param invalidIdentifier the identifier causing the exception.
	 */
	public InvalidItemException(String invalidIdentifier) {
		super("Item could not be entered. ID " + invalidIdentifier + " is invalid.");
		this.invalidIdentifier = invalidIdentifier;
	}

	/**
	 * @return the identifier causing the exception.
	 */
	public String getIdentifier() {
		return invalidIdentifier;
	}
}
