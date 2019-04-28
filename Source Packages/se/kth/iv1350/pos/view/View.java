package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;

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
		
		SaleDTO currentSale;
		currentSale = controller.enterItemID("ABC123", 1);
		System.out.println(currentSale.toString());
		currentSale = controller.enterItemID("DEF456", 2);
		System.out.println(currentSale.toString());
		currentSale = controller.enterItemID("ÅÄÖ123", 3);
		System.out.println(currentSale.toString());
		currentSale = controller.enterItemID("ABC123", 3);
		System.out.println(currentSale.toString());
		
		PriceDTO totalPrice = controller.endSale();
		System.out.println(totalPrice + "\n");
		
		totalPrice = controller.enterCustomerID("1234");
		System.out.println(totalPrice + "\n");
		
		MoneyDTO change = controller.enterPayment(new MoneyDTO(totalPrice.getPrice() + 42));
		System.out.println("-----\nChange: " + change);
	}
}
