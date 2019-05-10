package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.dto.TimeDTO;

public class ErrorMessageHandler {

	void showErrorMessage(String msg) {
		System.out.println(currentTime() + ", ERROR: " + msg);
	}

	private String currentTime() {
		return new TimeDTO().toString();
	}
}
