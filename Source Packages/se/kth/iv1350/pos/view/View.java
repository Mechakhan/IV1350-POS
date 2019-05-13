package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.controller.OperationFailedException;
import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.model.InvalidItemException;
import se.kth.iv1350.pos.util.LogHandler;

/**
 * This program has no view, instead, this class is a
 * placeholder for the entire view.
 * @author William
 */
public class View {
	
	private Controller controller;
	private ErrorMessageHandler errorMessage;
	private LogHandler logger;
	
	/**
	 * Creates new instance
	 * 
	 * @param contr The controller that is used for 
	 * all operations.
	 */
	public View (Controller controller) {
		this.controller = controller;
		errorMessage = new ErrorMessageHandler();
		logger = new LogHandler();
	}
	
	/**
	 * Simulates a user input that generates calls to all
	 * system operations. 
	 * @throws OperationFailedException 
	 * @throws InvalidItemException when an invalid item identifier is entered.
	 */
	public void sampleInput() {
		controller.startNewSale();
		System.out.println("New sale was started.");
		
		try {
			System.out.println(controller.enterItemID("ABC123", 1) + "\n");
		} catch (InvalidItemException | IllegalArgumentException e) {
			handleException(e);
		}
		try {
			System.out.println(controller.enterItemID("DEF456", 2) + "\n");
		} catch (InvalidItemException | IllegalArgumentException e) {
			handleException(e);
		}
		try {
			System.out.println(controller.enterItemID("ÅÄÖ123", 3) + "\n");
		} catch (Exception e) {
			handleException(e);
		}
		try {
			System.out.println(controller.enterItemID("ABC123", 3) + "\n");
		} catch (Exception e) {
			handleException(e);
		}
		try {
			System.out.println(controller.enterItemID("dbfailure", 3) + "\n");
		} catch (Exception e) {
			handleException(e);
		}
		
		// Ska man fånga en runtime exception för att logga den?
		// Kan databasen i discountsearcher lagra objekt av 
		// implementationer av discount interfacet från model lagret?
		// Lägga in bilder på all källkod som ändrades när den finns tillgänglig på github?
		
		System.out.println(controller.endSale() + "\n");
		
		System.out.println(controller.enterCustomerID("1234") + "\n");
		
		try {
			System.out.println("-----\nChange: " + controller.enterPayment
					(new MoneyDTO(500)) + "\n");
		}
		catch (IllegalArgumentException e){
			handleException(e);
		}
	}
	
	private void handleException(Exception e) {
		errorMessage.showErrorMessage(e.getMessage());
		logger.logException(e);
	}
}
