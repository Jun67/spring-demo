package com.bailiban.day5.transaction.transfer.bean;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
