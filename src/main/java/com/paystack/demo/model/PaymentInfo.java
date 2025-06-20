package com.paystack.demo.model;

import lombok.Data;

@Data
public class PaymentInfo {

    private String email;
    private Integer amount;
}
