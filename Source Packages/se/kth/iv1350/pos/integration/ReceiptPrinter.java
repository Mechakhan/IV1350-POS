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
	 * In the real program, this method would print the given receipt.
	 * Here, it prints it to the console instead.
	 * @param reciept the receipt to print.
	 */
	public void print(ReceiptDTO reciept) {
		System.out.println(reciept + "\n");
	}
}
