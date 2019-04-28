package se.kth.iv1350.pos.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDTO {
	
	private DateTimeFormatter formatter;
	
	/**
	 * Creates new instance.
	 */
	public TimeDTO() {
		formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	}
	
	@Override
	public String toString() {
		LocalDateTime currentTime = LocalDateTime.now();
		return formatter.format(currentTime);
	}
}
