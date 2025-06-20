package com.paystack.demo.response;

import lombok.Data;

@Data
public class ResponseData {
    private String authorization_url;
    private String access_code;
    private String reference;

}
