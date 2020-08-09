package com.tdd.kata.cash_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
		//given
		SpyPrinter printer = new SpyPrinter();
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		assertTrue(printer.hasBeenCalledPrint);
	}

	private class SpyPrinter extends Printer {
		public boolean hasBeenCalledPrint;

		@Override
		public void print(String content) throws PrinterOutOfPaperException {
			hasBeenCalledPrint = true;
			super.print(content);
		}
	}
}
