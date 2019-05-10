package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.dto.ReceiptDTO;
import se.kth.iv1350.pos.dto.TimeDTO;
import se.kth.iv1350.pos.model.InvalidItemException;
import se.kth.iv1350.pos.model.Sale;

class ReceiptPrinterTest {

	ReceiptPrinter rp;
	Sale sale;
	private ByteArrayOutputStream printOut;
	private PrintStream originalSysOut;
	
	@BeforeEach
	void setUp() throws Exception {
		rp = new ReceiptPrinter();
		sale = new Sale();
		
		printOut = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream(printOut);
		originalSysOut = System.out;
		System.setOut(inMemSysOut);
	}

	@AfterEach
	void tearDown() throws Exception {
		rp = null;
		System.setOut(originalSysOut);
		printOut = null;
	}

	@Test
	void test() throws InvalidItemException {
		sale.addItemGroup("GHI789", 3);
		rp.print(new ReceiptDTO(new StoreDataRetriever().getStoreData(), new TimeDTO(), sale.getSaleLog(), 
				new MoneyDTO(sale.getSaleLog().getRunningTotal().getPrice()), new MoneyDTO(0)));
		String result = printOut.toString();
		String expResult = "Receipt";
		assertTrue(result.contains(expResult), "Wrong printout after calling startNewSale().");
	}

}
