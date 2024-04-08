package com.cloudmotiv.cashfreebackend.controller;
import com.cloudmotiv.cashfreebackend.service.CashfreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashfreeController {
    @Autowired
    private CashfreeService cashfreeService;

    @PostMapping("/create-order")
    public String createOrder(@RequestBody String requestData) {
        return cashfreeService.createOrder(requestData);
    }
}
