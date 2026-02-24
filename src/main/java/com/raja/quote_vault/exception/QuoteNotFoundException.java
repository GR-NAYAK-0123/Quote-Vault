package com.raja.quote_vault.exception;

public class QuoteNotFoundException extends RuntimeException{

    public QuoteNotFoundException(){
        super();
    }

    public QuoteNotFoundException(String message){
        super(message);
    }
}
