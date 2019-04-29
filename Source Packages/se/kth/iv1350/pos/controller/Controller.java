package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.integration.CashRegister;
import se.kth.iv1350.pos.model.DiscountHandler;
import se.kth.iv1350.pos.model.ExternalSystemHandler;
import se.kth.iv1350.pos.model.Payment;
import se.kth.iv1350.pos.model.Sale;

/**
 * This is the application’s only controller class. All
 * calls to the model pass through here.
 * @author William
 *
 */
public class Controller {
	
	private Sale sale;
	private ExternalSystemHandler externalSysHandler;
	private CashRegister cashRegister;
	
	/**
	 * Creates new instance.
	 */
	public Controller () {
		externalSysHandler = new ExternalSystemHandler();
		cashRegister = new CashRegister();
	}
	
	/**
	 * Starts a new Sale.
	 */
	public void startNewSale () {
		sale = new Sale ();
	}
	
	/**
	 * Add an item/items to the current Sale
	 * 
	 * @param identifier the identifier of the entered item(s).
	 * @param quantity the quantity of the entered item(s).
	 * @return A SaleDTO object based on information about the current Sale is returned.
	 */
	public String enterItemID (String identifier, int quantity) {
		return sale.addItemGroup (identifier, quantity);
	}
	
	/**
	 * Method called when all items have been entered.
	 * @return the total price, including VAT.
	 */
	public String endSale() {
		return sale.end().toString();
	}
	
	/**
	 * Enter a customer's ID to check if they're eligible for discounts.
	 * 
	 * @param identifier the identifier of the customer
	 * @return the new running total after discounts have been applied.
	 */
	public String enterCustomerID (String identifier) {
		return new DiscountHandler().findDiscount(new CustomerDTO(identifier), sale).toString();		
	}
	
	/**
	 * Enter a customer's payment and retrieve how much change to give to them.
	 * @param payment the amount of money the customer paid.
	 * @return the change to be given to the customer.
	 */
	public String enterPayment(MoneyDTO payment) {
		SaleDTO saleLog = sale.getSaleLog();
		MoneyDTO change = new Payment(payment).calculateChange(saleLog.getRunningTotal());
		cashRegister.addToBalance(new MoneyDTO(payment.getAmount() - change.getAmount()));
		externalSysHandler.makeReciept(saleLog, payment, change);
		return change.toString();
	}
}
