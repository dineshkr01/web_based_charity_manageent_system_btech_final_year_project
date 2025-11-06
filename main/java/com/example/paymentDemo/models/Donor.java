package com.example.paymentDemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "donor_table")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "donated_amount", nullable = false, unique = true)
    private Double amount;

    public Donor() {
    }

    public Donor(Double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Donor{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
