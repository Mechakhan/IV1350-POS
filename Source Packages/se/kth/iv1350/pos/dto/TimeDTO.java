package se.kth.iv1350.pos.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class able to print the current time.
 * @author William
 *
 */
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
		return formatter.format(LocalDateTime.now());
	}
}
