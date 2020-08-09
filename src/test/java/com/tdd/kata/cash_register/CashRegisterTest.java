package com.tdd.kata.cash_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
		//given
		SpyPrinter printer = new SpyPrinter();
		CashRegister cashRegister = new CashRegister(printer);
		final String stubContent = "content";
		StubPurchase purchase = new StubPurchase(stubContent);
		//when
		cashRegister.process(purchase);
		//then
		assertTrue(printer.hasBeenCalledPrint);
		assertEquals(stubContent, printer.hasBeenPrintWith);
	}

	private class SpyPrinter extends Printer {
		public boolean hasBeenCalledPrint;
		public String hasBeenPrintWith;

		@Override
		public void print(String content) throws PrinterOutOfPaperException {
			hasBeenCalledPrint = true;
			hasBeenPrintWith = content;
			super.print(content);
		}
	}

	private class StubPurchase extends Purchase {
		private String content;

		private StubPurchase(String content) {
			this.content = content;
		}

		@Override
		public String asString() {
			return this.content;
		}
	}
}
