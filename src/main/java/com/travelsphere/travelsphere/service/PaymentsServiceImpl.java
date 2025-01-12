package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.PaymentsDto;
import com.travelsphere.travelsphere.exceptions.PaymentsException;
import com.travelsphere.travelsphere.mapper.PaymentsMapper;
import com.travelsphere.travelsphere.model.Payments;
import com.travelsphere.travelsphere.repository.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsRepo paymentsRepo;

    @Autowired
    private PaymentsMapper paymentsMapper;

    @Override
    public List<PaymentsDto> getAllPayments() throws PaymentsException {
        List<Payments> paymentsList = paymentsRepo.findAll();
        if (paymentsList.isEmpty()) {
            throw new PaymentsException("No payments found");
        }
        return paymentsList.stream().map(paymentsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PaymentsDto getPaymentById(Integer paymentId) throws PaymentsException {
        Payments payment = paymentsRepo.findById(paymentId)
                .orElseThrow(() -> new PaymentsException("Payment not found with ID: " + paymentId));
        return paymentsMapper.toDto(payment);
    }

    @Override
    public PaymentsDto createPayment(PaymentsDto paymentsDto) throws PaymentsException {
        Payments payment = paymentsMapper.toEntity(paymentsDto);
        Payments savedPayment = paymentsRepo.save(payment);
        return paymentsMapper.toDto(savedPayment);
    }

    @Override
    public PaymentsDto updatePayment(PaymentsDto paymentsDto) throws PaymentsException {
        Payments payment = paymentsRepo.findById(paymentsDto.getPaymentId())
                .orElseThrow(() -> new PaymentsException("Payment not found with ID: " + paymentsDto.getPaymentId()));
        
        payment.setAmount(paymentsDto.getAmount());
        payment.setPaymentDate(paymentsDto.getPaymentDate());
        payment.setDescription(paymentsDto.getDescription());
        
        Payments updatedPayment = paymentsRepo.save(payment);
        return paymentsMapper.toDto(updatedPayment);
    }
    

    @Override
    public void deletePayment(Integer paymentId) throws PaymentsException {
        Payments payment = paymentsRepo.findById(paymentId)
                .orElseThrow(() -> new PaymentsException("Payment not found with ID: " + paymentId));
        paymentsRepo.delete(payment);
    }
}
