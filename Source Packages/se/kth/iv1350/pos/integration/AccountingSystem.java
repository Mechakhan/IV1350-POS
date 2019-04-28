package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.SaleDTO;

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
}
