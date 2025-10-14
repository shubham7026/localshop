package com.localshop.customer.exceptions;

public class PasswordMissMatchedException extends RuntimeException {
    public PasswordMissMatchedException(String message) {
        super(message);
    }
}
