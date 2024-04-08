package com.cloudmotiv.cashfreebackend.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CashfreeService {
    @Value("${cashfree.client-id}")
    private String clientId;

    @Value("${cashfree.client-secret}")
    private String clientSecret;



        public String createOrder (String requestData){
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-api-version", "2023-08-01");
            headers.set("x-client-id", clientId);
            headers.set("x-client-secret", clientSecret);

            HttpEntity<String> request = new HttpEntity<>(requestData, headers);
            ResponseEntity<String> response = restTemplate.postForEntity("https://sandbox.cashfree.com/pg/orders", request, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                return "Error occurred while creating order";
            }
        }

    }


