package com.paystack.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PaymentResponse {

    private boolean status;
    private String message;
    private ResponseData data;

}
