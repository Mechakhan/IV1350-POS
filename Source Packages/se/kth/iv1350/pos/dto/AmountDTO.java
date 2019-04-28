package se.kth.iv1350.pos.dto;

/**
 * A DTO class containing information about the  amount of money an item costs.
 * @author William
 *
 */
public class AmountDTO {

	private double price;
	private double vat;
	
	/**
	 * Creates new instance.
	 * @param price represents an amount of money
	 * @param vat represents the VAT rate of the amount.
	 */
	public AmountDTO (double price, double vat) {
		if (price >= 0)
			this.price = price;
		else
			this.price = 0;
		if (vat >= 0)
			this.vat = vat;
		else
			this.vat = 0;
	}
	
	/**
	 * Get method that retrieves the price of the item, excluding VAT.
	 * @return the price attribute.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Get method that retrieves the VAT rate of the item.
	 * @return the VAT attribute.
	 */
	public double getVAT() {
		return vat;
	}
	
	@Override
	public String toString() {
		return price + " | VAT: " + vat;
	}
}
