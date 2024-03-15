package com.formproject.Formproject.exception;

public class UserNotFountException extends RuntimeException{
	public UserNotFountException(Long id) {
		super("Could not found the user with id"+ id);
	}

}
