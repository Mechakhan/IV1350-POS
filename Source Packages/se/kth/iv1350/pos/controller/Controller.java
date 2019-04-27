package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.model.DiscountHandler;
import se.kth.iv1350.pos.model.Sale;
/**
 * This is the application’s only controller class. All
 * calls to the model pass through here.
 * @author William
 *
 */
public class Controller {
	
	private Sale sale;
	
	/**
	 * Creates new instance.
	 */
	public Controller () {}
	
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
	public SaleDTO enterItemID (String identifier, int quantity) {
		return sale.addItemGroup (identifier, quantity);
	}
	
	public PriceDTO endSale() {
		return sale.getSaleLog().getRunningTotal();
	}
	
	/*public double enterCustomerID (String identifier) {
		CustomerDTO customer = new CustomerDTO (identifier);
		return new DiscountHandler().findDiscount(customer, sale);
	}*/
}
