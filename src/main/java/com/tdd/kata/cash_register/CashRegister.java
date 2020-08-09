package com.tdd.kata.cash_register;

public class CashRegister {
	private final Printer printer;

	public CashRegister() {
		this.printer = new Printer();
	}

	public CashRegister(Printer printer) {
		this.printer = printer;
	}

	void process(Purchase purchase) throws HardwareException {
		try {
			printer.print(purchase.asString());
		} catch (PrinterOutOfPaperException e) {
			e.printStackTrace();
			throw new HardwareException("Printer is out of paper.");
		}
	}
}
