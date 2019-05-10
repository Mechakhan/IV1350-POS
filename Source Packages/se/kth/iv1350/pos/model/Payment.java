package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.PriceDTO;

/**
 * Class performaing logic related to the customer payment.
 * @author William
 *
 */
public class Payment {

	private MoneyDTO payment;
	
	/**
	 * Creates new instance
	 * @param payment the payment received by the customer.
	 */
	public Payment(MoneyDTO payment) {
		this.payment = new MoneyDTO(payment);
	}
	
	/**
	 * Get method that retrieves the payment attribute.
	 * @return the payment attribute.
	 */
	public MoneyDTO getPayment() {
		return new MoneyDTO (payment);
	}
	
	public MoneyDTO calculateChange(PriceDTO price) {
		if (payment.getAmount() < price.getPrice())
			throw new IllegalArgumentException("The payment was not sufficient to cover the total price.");
		return new MoneyDTO (payment.getAmount() - price.getPrice());
	}
}
