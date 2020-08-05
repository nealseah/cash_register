package com.tdd.kata.cash_register;

import java.time.LocalDateTime;

public class Purchase {
	private final String content;

	public Purchase() {
		// very time-consuming operation, connecting network to get content
		content = "content";
	}

	public String asString() {
		return content + timestamp();
	}

	private String timestamp() {
		return LocalDateTime.now().toString();
	}
}
