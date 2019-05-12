package se.kth.iv1350.pos.util;

import se.kth.iv1350.pos.dto.TimeDTO;

/**
 * Class that creates a log of something.
 * @author William
 *
 */
public class LogHandler {
	
	/**
	 * Logs an exception.
	 * @param e the exception to log.
	 */
	public void logException(Exception e) {
		System.out.println("\n--EXCEPTION LOG--\n" + currentTime() + ", Exception was thrown: " + e.getMessage());
		e.printStackTrace(System.out);
	}
	
	private String currentTime() {
		return new TimeDTO().toString();
	}
}
