package com.tdd.kata.cash_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
		//given
		Printer printer = spy(new Printer());
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = mock(Purchase.class);
		final String stubContent = "content";
		given(purchase.asString()).willReturn(stubContent);
		//when
		cashRegister.process(purchase);
		//then
		verify(printer).print(stubContent);
	}

	@Test
	void should_throws_hardware_exception_while_printer_is_out_of_paper() {
		//given
		Printer printer = mock(Printer.class);
		willThrow(PrinterOutOfPaperException.class).given(printer).print(anyString());
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = mock(Purchase.class);
		final String stubContent = "content";
		given(purchase.asString()).willReturn(stubContent);
		//when
		//then
		assertThrows(HardwareException.class, () -> {
			cashRegister.process(purchase);
		});
	}
}
