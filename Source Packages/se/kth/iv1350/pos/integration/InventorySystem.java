package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.SaleDTO;

/**
 * Class that stores updates the inventory
 * system by storing sale logs.
 * @author William
 *
 */
public class InventorySystem {

	private List<SaleDTO> saleLogs;
	
	/**
	 * Creates new instance.
	 */
	public InventorySystem() {
		saleLogs = new ArrayList<SaleDTO>();
	}
	
	/**
	 * Stores sale log in the inventory system.
	 * @param saleLog the sale log to store.
	 */
	public void logSale(SaleDTO saleLog) {
		saleLogs.add(saleLog);		
	}

}
