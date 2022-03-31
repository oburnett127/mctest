package com.example.marketboard.exception;

public class InsufficientWithdrawException extends RuntimeException {
    public InsufficientWithdrawException(){
        super("Insufficient funds. Cannot withdraw the requested amount.");
    }
}
//Hello world