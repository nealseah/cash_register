package com.tdd.kata.cash_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
		//given
		Printer printer = new Printer();
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		assertTrue(printer.hasBeenCalledPrint);
	}

}
