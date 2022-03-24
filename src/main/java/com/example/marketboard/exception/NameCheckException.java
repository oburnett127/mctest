package com.example.marketboard.exception;

public class NameCheckException extends RuntimeException{
    public NameCheckException(){
        super("The check must have a full name and the name cannot contains digits");
    }
}//