package com.unp.challenge.domain.enums;

public enum TipoMovimentacao {

	DEBITO(1, "D"), CREDITO(2, "C");

	private int code;
	private String description;

	TipoMovimentacao(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}
