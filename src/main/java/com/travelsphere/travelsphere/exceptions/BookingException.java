package com.travelsphere.travelsphere.exceptions;

public class BookingException extends Exception{
    public BookingException(){

    }

    public BookingException(String mgs){
        super(mgs);
    }
}
