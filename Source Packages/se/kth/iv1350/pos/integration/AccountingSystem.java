package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.SaleDTO;

/**
 * A class were sale logs are stored for accounting.
 * @author William
 *
 */
public class AccountingSystem {

	private List<SaleDTO> saleLogs;
	
	/**
	 * Creates new instance.
	 */
	public AccountingSystem() {
		saleLogs = new ArrayList<SaleDTO>();
	}

	/**
	 * Stores sale log in the accounting system.
	 * @param saleLog the sale log to store.
	 */
	public void logSale(SaleDTO saleLog) {
		saleLogs.add(saleLog);	
	}
	
	/**
	 * Get method that retrieves the amount of sales logged in the database.
	 * @return the amount of sales that have been logged.
	 */
	public int getNrOfSales() {
		return saleLogs.size();
	}
}
