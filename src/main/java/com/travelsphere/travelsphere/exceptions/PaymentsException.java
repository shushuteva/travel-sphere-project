package com.travelsphere.travelsphere.exceptions;

public class PaymentsException extends RuntimeException {
    public PaymentsException() {
        super();
    }

    public PaymentsException(String message) {
        super(message);
    }

    public PaymentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentsException(Throwable cause) {
        super(cause);
    }
}
