package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
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
		System.out.println("-----\nTotal Price: " + totalPrice);
		// Anropa en metod "retrieveRunningTotal" i controller här? Dålig sammanhållning?
		// System.out.println(saleDTO.getIdentifier() + " " + saleDTO.getPrice());	
	}
	
	// En javadoc kommentar per publik deklaration, om fler behövs: dålig sammanhållning
	// Många privata metoder vid krångliga kodformuleringar.
}
