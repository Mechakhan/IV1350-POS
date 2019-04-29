package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.ReceiptDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.dto.StoreDTO;
import se.kth.iv1350.pos.dto.TimeDTO;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.ReceiptPrinter;
import se.kth.iv1350.pos.integration.StoreDataRetriever;

/**
 * Class that operates different classes related 
 * to communications with external systems.
 * @author William
 *
 */
public class ExternalSystemHandler {
	
	private InventorySystem inventorySys;
	private AccountingSystem accountingSys;
	
	public ExternalSystemHandler() {
		inventorySys = new InventorySystem();
		accountingSys = new AccountingSystem();
	}
	
	public void makeReciept(SaleDTO saleInfo, MoneyDTO payment, MoneyDTO change) {
		sendSaleLog(saleInfo);
		StoreDTO storeData = new StoreDataRetriever().getStoreData();
		TimeDTO currentTime = new TimeDTO();
		new ReceiptPrinter().print(new ReceiptDTO(storeData, currentTime, saleInfo, payment, change));
	}
	
	private void sendSaleLog(SaleDTO saleLog) {
		inventorySys.logSale(saleLog);
		accountingSys.logSale(saleLog);
	}
}
