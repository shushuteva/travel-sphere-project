package com.travelsphere.travelsphere.exceptions;

public class TravelException extends Exception{

    public TravelException () {

    }

    public TravelException (String mgs) {
        super(mgs);
    }
}