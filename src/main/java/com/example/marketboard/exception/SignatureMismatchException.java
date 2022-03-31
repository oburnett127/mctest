package com.example.marketboard.exception;

public class SignatureMismatchException extends RuntimeException {
    public SignatureMismatchException(){
        super("The full name and the signature do not match.");
    }

}
////Hello world