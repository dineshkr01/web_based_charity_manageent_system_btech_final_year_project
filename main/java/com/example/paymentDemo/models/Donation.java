package com.example.paymentDemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "donation_table")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "donated_amount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "needy_id", nullable = false)
    private Needy needy;

    public Donation() {
    }

    public Donation(Double amount, Donor donor, Needy needy) {
        this.amount = amount;
        this.donor = donor;
        this.needy = needy;
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

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Needy getNeedy() {
        return needy;
    }

    public void setNeedy(Needy needy) {
        this.needy = needy;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", amount=" + amount +
                ", donor=" + donor +
                ", needy=" + needy +
                '}';
    }
}
