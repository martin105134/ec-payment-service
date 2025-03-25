package com.example.ecpaymentservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@Slf4j
@RequestMapping("payment")
public class MainRestController {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    AuthService authService;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest paymentRequest, @RequestHeader("Authorization") String token) throws InterruptedException {
        log.info("Create payment request in ecpayment service");
        if(authService.authenticate(token)) {
            Thread.sleep(10000);
            Payment payment = new Payment();
            payment.setPaymentAmount(paymentRequest.getPaymentAmount());
            payment.setOrderId(paymentRequest.getOrderId());
            payment.setPaymentId(String.valueOf(new Random().nextInt(1000)));
            payment.setPaymentStatus("INITIATED");
            paymentRepo.save(payment);
            return ResponseEntity.ok(payment.getPaymentId());
        }else {
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }
}
