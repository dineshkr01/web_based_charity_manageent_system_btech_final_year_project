package com.example.paymentDemo.controllers;

import com.example.paymentDemo.models.Donation;
import com.example.paymentDemo.services.DonationService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public Donation makeDonation(@RequestBody Donation donation) throws StripeException {
        return donationService.saveDonation(donation);
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        return donationService.getDonationById(id).orElse(null);
    }
}
