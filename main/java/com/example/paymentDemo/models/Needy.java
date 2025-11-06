package com.example.paymentDemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "needy_table")
public class Needy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "needy_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "donation_collected")
    private Double amount;

    @Column(name = "stripe_id", unique = true)
    private String stripeId;

    public Needy() {
    }

    public Needy(Double amount, String stripeId) {
        this.amount = amount;
        this.stripeId = stripeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    @Override
    public String toString() {
        return "Needy{" +
                "id=" + id +
                ", amount=" + amount +
                ", stripeId='" + stripeId + '\'' +
                '}';
    }
}
