package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.PaymentsDto;
import com.travelsphere.travelsphere.exceptions.PaymentsException;

import java.util.List;

public interface PaymentsService {
    List<PaymentsDto> getAllPayments() throws PaymentsException;
    PaymentsDto getPaymentById(Integer paymentId) throws PaymentsException;
    PaymentsDto createPayment(PaymentsDto paymentsDto) throws PaymentsException;
    PaymentsDto updatePayment(PaymentsDto paymentsDto) throws PaymentsException;
    void deletePayment(Integer paymentId) throws PaymentsException;
}

