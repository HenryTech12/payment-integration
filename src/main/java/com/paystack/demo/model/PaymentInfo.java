package com.paystack.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentInfo {

    @NotBlank
    @NotNull
    private String email;
    @Min(value = 100, message = "amount must be greater than or equal to 100")
    private Integer amount;
}
