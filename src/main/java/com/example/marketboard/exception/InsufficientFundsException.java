package com.example.marketboard.exception;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(){
        super("Insufficient funds. Cannot complete transaction.");
    }
}
//