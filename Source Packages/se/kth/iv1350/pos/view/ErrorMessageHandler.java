package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.dto.TimeDTO;

/**
 * Class responsible for printing error messages to the view.
 * @author William
 *
 */
public class ErrorMessageHandler {

	/**
	 * @param msg the error message to show.
	 */
	void showErrorMessage(String msg) {
		System.out.println(currentTime() + ", ERROR: " + msg);
	}

	private String currentTime() {
		return new TimeDTO().toString();
	}
}
