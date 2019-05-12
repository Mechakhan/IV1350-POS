package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.CashRegister;
import se.kth.iv1350.pos.view.TotalRevenueView;
import se.kth.iv1350.pos.view.View;

/**
 * Contains the <code>main</code> method. Performs all startup
 * of the application.
 * @author William
 */
public class Main {
	/**
	 * The main method to run at startup
	 * 
	 * @param args The application does not take any command
	 * line parameters.
	 */
	public static void main(String[] args) {
		CashRegister register = CashRegister.getRegister();
		register.addObserver(new TotalRevenueView());
		new View(new Controller(register)).sampleInput();
	}
}
