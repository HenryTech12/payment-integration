package com.paystack.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paystack.demo.model.PaymentInfo;
import com.paystack.demo.response.PaymentResponse;
import com.paystack.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/init")
    public PaymentResponse initPayment(@RequestBody PaymentInfo paymentInfo) throws JsonProcessingException {
        return paymentService.initPayment(paymentInfo);
    }
}
