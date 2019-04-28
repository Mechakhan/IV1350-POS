package se.kth.iv1350.pos.dto;

public class DiscountConditionDTO {

	private CustomerDTO applicableCustomer;
	private PriceDTO applicableSalePrice;
	private int applicableNrOfItemsInSale;
	
	/**
	 * Creates new instance.
	 * 
	 * @param applicableCustomer the customer that the discount is applicable to.
	 * @param applicableSalePrice the sale price that the discount is applicable to.
	 * @param applicableNrOfItemsInSale the amount of items in sale that the discount is applicable to.
	 * @param applicableItem the item that the discount is applicable to.
	 */
	public DiscountConditionDTO (CustomerDTO applicableCustomer, 
			PriceDTO applicableSalePrice, int applicableNrOfItemsInSale) {
		this.applicableCustomer = applicableCustomer;
		this.applicableSalePrice = applicableSalePrice;
		this.applicableNrOfItemsInSale = applicableNrOfItemsInSale;
	}

	/**
	 * Creates new instance based on existing discount condition.
	 * @param conditions the discount condition instance to copy.
	 */
	public DiscountConditionDTO(DiscountConditionDTO conditions) {
		this.applicableCustomer = conditions.getCustomer();
		this.applicableSalePrice = conditions.getSalePrice();
		this.applicableNrOfItemsInSale = conditions.getNrOfItemsInSale();
	}

	/**
	 * Get method that retrieves the applicable customer of the discount.
	 * @return the applicable customer.
	 */
	public CustomerDTO getCustomer() {
		return new CustomerDTO(applicableCustomer.getIdentifier());
	}

	/**
	 * Get method that retrieves the applicable sale price of the discount.
	 * @return the applicable sale price.
	 */
	public PriceDTO getSalePrice() {
		return new PriceDTO(applicableSalePrice.getPrice(), applicableSalePrice.getVAT(), applicableSalePrice.getActive());
	}
	
	/**
	 * Get method that retrieves the applicable number of items in the sale of the discount.
	 * @return the applicable number of items in the sale.
	 */
	public int getNrOfItemsInSale() {
		return applicableNrOfItemsInSale;
	}
}
