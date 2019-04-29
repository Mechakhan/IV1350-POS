package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.dto.AmountDTO;
import se.kth.iv1350.pos.dto.ItemDescriptionDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;

class PriceTest {

	Price price;
	PriceDTO priceDTO;
	SaleDTO saleDTO;
	ItemGroupDTO item;
	
	@BeforeEach
	void setUp() throws Exception {
		
		List<ItemGroupDTO> saleItems = new ArrayList<ItemGroupDTO>();
		priceDTO = new PriceDTO();
		saleDTO = new SaleDTO(saleItems, priceDTO, 0);
		price = new Price(priceDTO);
		item = new ItemGroupDTO("ABC123", new AmountDTO(30.0, 0.25), 3, new ItemDescriptionDTO(""));
	}

	@AfterEach
	void tearDown() throws Exception {
		price = null;
		item = null;
		saleDTO = null;
		priceDTO = null;
	}

	@Test
	void testRunningTotal() {
		price.addToRunningTotal(item);
		double runningTotal = priceDTO.getPrice();
		double expResult = 30.0 * 1.25 * 3;
		assertEquals(expResult, runningTotal, "Running total not added to correctly.");
	}
	
	@Test
	void testVAT() {
		price.addToVAT(item);
		double runningTotal = priceDTO.getVAT();
		double expResult = 30.0 * 0.25 * 3;
		assertEquals(runningTotal, expResult, "Running total not added to correctly.");
	}
	
	@Test
	void testSetRunningTotal() {
		PriceDTO newPrice = new PriceDTO(10, 0, false);
		price.setRunningTotal(newPrice);
		//double runningTotal = .getVAT();
		double expResult = 10;
		assertEquals(10, expResult, "Running total not added to correctly.");
	}

}
