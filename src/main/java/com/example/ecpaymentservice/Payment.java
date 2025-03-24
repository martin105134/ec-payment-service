package com.example.ecpaymentservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name="payment_id")
    private String paymentId;
    @Column(name="order_id")
    private String orderId;
    @Column(name="payment_status")
    private String paymentStatus;
    @Column(name="payment_amount")
    private Integer paymentAmount;
}
