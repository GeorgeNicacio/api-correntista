package com.unp.challenge.services.exceptions;

import java.util.List;

import org.springframework.validation.ObjectError;

public class UNPException extends Exception {

	private static final long serialVersionUID = 1L;
	protected List<ObjectError> allErros;

	public UNPException(String message) {
		super(message);
	}
	
	public List<ObjectError> getAllErros() {
		return allErros;
	}
}
