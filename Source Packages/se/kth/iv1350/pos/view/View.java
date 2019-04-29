package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dto.MoneyDTO;

/**
 * This program has no view, instead, this class is a
 * placeholder for the entire view.
 * @author William
 */
public class View {
	
	private Controller controller;
	
	/**
	 * Creates new instance
	 * 
	 * @param contr The controller that is used for 
	 * all operations.
	 */
	public View (Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Simulates a user input that generates calls to all
	 * system operations. 
	 */
	public void sampleInput() {
		controller.startNewSale();
		System.out.println("New sale was started.");
		
		System.out.println(controller.enterItemID("ABC123", 1) + "\n");
		System.out.println(controller.enterItemID("DEF456", 2) + "\n");
		System.out.println(controller.enterItemID("ÅÄÖ123", 3) + "\n");
		System.out.println(controller.enterItemID("ABC123", 3) + "\n");
		
		System.out.println(controller.endSale() + "\n");
		
		System.out.println(controller.enterCustomerID("1234") + "\n");
		
		System.out.println("-----\nChange: " + controller.enterPayment
				(new MoneyDTO(500)) + "\n");
	}
}
