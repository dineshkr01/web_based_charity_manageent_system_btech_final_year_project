package com.example.paymentDemo.services;

import com.example.paymentDemo.models.Donation;
import com.example.paymentDemo.repositories.DonationRepository;
import com.example.paymentDemo.stripe.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private StripeService stripeService;

    public Donation saveDonation(Donation donation) throws StripeException {
        // Create Stripe PaymentIntent for donation
        PaymentIntent paymentIntent = stripeService.createPaymentIntent(
                donation.getAmount(),
                donation.getNeedy().getStripeId()
        );
        // You can save paymentIntent.getId() in Donation if needed
        return donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public Optional<Donation> getDonationById(Long id) {
        return donationRepository.findById(id);
    }
}
