package com.example.ecpaymentservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private String orderId;
    private String paymentId;
    private Integer paymentAmount;
}
