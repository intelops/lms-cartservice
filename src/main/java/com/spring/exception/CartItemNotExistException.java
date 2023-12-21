package com.spring.exception;

@SuppressWarnings("serial")
public class CartItemNotExistException extends IllegalArgumentException {
    public CartItemNotExistException(String msg) {
        super(msg);
    }
}
