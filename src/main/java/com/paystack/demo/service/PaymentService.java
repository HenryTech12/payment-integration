package com.paystack.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paystack.demo.model.PaymentInfo;
import com.paystack.demo.response.PaymentResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Objects;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;
    private String url = "https://api.paystack.co/transaction/initialize";
    @Value("${paystack-secretKey}")
    private String secretKey;
    private ObjectMapper objectMapper;

    public PaymentResponse initPayment(PaymentInfo paymentInfo) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        if(!Objects.isNull(paymentInfo)) {
            String jsonData = objectMapper.writeValueAsString(paymentInfo);
            System.out.println("DATA: "+jsonData);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer "+
                    secretKey);
            HttpEntity<?> httpEntity = new HttpEntity<>(jsonData,httpHeaders);

            return restTemplate.exchange(url, HttpMethod.POST,httpEntity,PaymentResponse.class).getBody();
        }
        return null;
    }
}
