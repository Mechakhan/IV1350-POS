package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.ReceiptDTO;

/**
 * Class that tells the receipt printer
 * to print a receipt.
 * @author William
 *
 */
public class ReceiptPrinter {

	/**
	 * Creates new instance.
	 */
	public ReceiptPrinter() {}
	
	/**
	 * Prints the given receipt.
	 * @param reciept the receipt to print.
	 */
	public void print(ReceiptDTO reciept) {
		System.out.println(reciept + "\n");
	}
}
