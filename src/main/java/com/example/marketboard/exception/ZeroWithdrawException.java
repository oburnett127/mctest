package com.example.marketboard.exception;

public class ZeroWithdrawException extends RuntimeException{
    public ZeroWithdrawException(){
        super("Amount to withdraw must be a positive number");
    }
}
////Hello world