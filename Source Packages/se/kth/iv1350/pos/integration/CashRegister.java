package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.MoneyDTO;

/**
 * Class containing the current balance of the register.
 * @author William
 *
 */
@SuppressWarnings("unused")
public class CashRegister {

	private static CashRegister CASH_REGISTER = new CashRegister();
	private MoneyDTO balance;
	private List<CashRegisterObserver> observers = new ArrayList<CashRegisterObserver>();
	
	/**
	 * Creates new instance and initializes the balance to to the amount of cash in the register.
	 * Can only be called from within this singleton class.
	 */
	private CashRegister() {
		balance = new MoneyDTO(1000);
	}
	
	/**
	 * Adds payment to the balance.
	 * @param payment the payment to add
	 */
	public void addToBalance (MoneyDTO payment) {
		balance = new MoneyDTO(payment.getAmount() + balance.getAmount());
		notifyObservers(payment);
	}
	
	private void notifyObservers(MoneyDTO payment) {
		for (CashRegisterObserver obs : observers) {
			obs.addToTotalRevenue(payment);
		}
	}
	
	/**
	 * Adds an observer of this class to the list of observers.
	 * @param obs the observer to add.
	 */
	public void addObserver(CashRegisterObserver obs) {
		observers.add(obs);
	}
	
	/**
	 * @return the only instance of this singleton.
	 */
	public static CashRegister getRegister() {
		return CASH_REGISTER;
	}
}
