package se.kth.iv1350.pos.util;

import se.kth.iv1350.pos.dto.TimeDTO;

public class LogHandler {
	
	public void logException(Exception e) {
		System.out.println("\n--EXCEPTION LOG--\n" + currentTime() + ", Exception was thrown: " + e.getMessage());
		e.printStackTrace(System.out);
	}
	
	private String currentTime() {
		return new TimeDTO().toString();
	}
}
