package se.kth.iv1350.pos.dto;

public class ReceiptDTO {

	StoreDTO storeData;
	TimeDTO currentTime;
	SaleDTO saleInfo;
	MoneyDTO payment;
	MoneyDTO change;
	
	/**
	 * Creates new instance.
	 * 
	 * @param storeData information about the store.
	 * @param currentTime the current time
	 * @param saleInfo the information about the sale
	 * @param payment the customer's payment
	 * @param change the change the customer receives.
	 */
	public ReceiptDTO(StoreDTO storeData, TimeDTO currentTime, SaleDTO saleInfo, MoneyDTO payment,
			MoneyDTO change) {
		this.storeData = storeData;
		this.currentTime = currentTime;
		this.saleInfo = saleInfo;
		this.payment = payment;
		this.change = change;
	}
	
	@Override
	public String toString() {
		return "-----\nReciept:\n\n" + storeData + "\n" + currentTime + 
				"\n\n" + saleInfo + "\nPayment: " + payment + " | Change: " + change;
	}
}
