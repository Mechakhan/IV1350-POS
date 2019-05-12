package se.kth.iv1350.pos.view;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.CashRegister;

class ViewTest {
	
	private View instance;
	private ByteArrayOutputStream printOut;
	private PrintStream originalSysOut;
	
	@BeforeEach
	void setUp() throws Exception {
		Controller contr = new Controller(CashRegister.getRegister());
		instance = new View(contr);
		
		printOut = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream(printOut);
		originalSysOut = System.out;
		System.setOut(inMemSysOut);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(originalSysOut);
		printOut = null;
	}

	@Test
	void test() {
		instance.sampleInput();
		String result = printOut.toString();
		String expResult = "started";
		assertTrue(result.contains(expResult), "Wrong printout after calling startNewSale().");
	}

}
