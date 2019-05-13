package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.integration.CashRegister;
import se.kth.iv1350.pos.integration.DatabaseFailureException;
import se.kth.iv1350.pos.model.DiscountHandler;
import se.kth.iv1350.pos.model.ExternalSystemHandler;
import se.kth.iv1350.pos.model.InvalidItemException;
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
	private CashRegister register;
	
	/**
	 * Creates new instance.
	 */
	public Controller (CashRegister register) {
		externalSysHandler = new ExternalSystemHandler();
		this.register = register;
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
	 * @throws InvalidItemException received from the model layer if the item identifier was invalid.
	 * @throws OperationFailedException thrown if a database error occured.
	 */
	public SaleDTO enterItemID (String identifier, int quantity) throws InvalidItemException {
		if (quantity < 1)
			throw new IllegalArgumentException("The quantity of the entered item was too small.");
		try {
			return sale.addItemGroup (identifier, quantity);
		}
		catch (DatabaseFailureException e) {
			throw new OperationFailedException("Could not access the item inventory. Please try again.", e);
		}
	}
	
	/**
	 * Method called when all items have been entered.
	 * @return the total price, including VAT.
	 */
	public PriceDTO endSale() {
		return sale.end();
	}
	
	/**
	 * Enter a customer's ID to check if they're eligible for discounts.
	 * 
	 * @param identifier the identifier of the customer
	 * @return the new running total after discounts have been applied.
	 * @throws DatabaseFailureException thrown if a database error occured.
	 */
	public PriceDTO enterCustomerID (String identifier) {
		try {
			return new DiscountHandler().findDiscount(new CustomerDTO(identifier), sale);
		}
		catch (DatabaseFailureException e) {
			throw new OperationFailedException("Could not access the discounts. Please try again.", e);
		}
	}
	
	/**
	 * Enter a customer's payment and retrieve how much change to give to them.
	 * @param payment the amount of money the customer paid.
	 * @return the change to be given to the customer.
	 */
	public MoneyDTO enterPayment(MoneyDTO payment) {
		SaleDTO saleLog = sale.getSaleLog();
		MoneyDTO change = new Payment(payment).calculateChange(saleLog.getRunningTotal());
		register.addToBalance(new MoneyDTO(payment.getAmount() - change.getAmount()));
		externalSysHandler.makeReciept(saleLog, payment, change);
		return change;
	}
}
