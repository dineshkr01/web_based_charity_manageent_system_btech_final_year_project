package com.example.paymentDemo.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.api.key}")
    private String apiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey; // Initialize Stripe with secret key
    }

    // Create connected account for Needy organization
    public Account createConnectedAccount() throws StripeException {
        String email = "dineshkumarqe2002@gmail.com";
        Map<String, Object> params = new HashMap<>();
        params.put("type", "express");
        params.put("email", email);
        return Account.create(params);
    }

    // Create PaymentIntent to charge donor and transfer to Needy's connected account
    public PaymentIntent createPaymentIntent(Double amount, String connectedAccountId) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", (int)(amount * 100)); // Stripe uses cents
        params.put("currency", "usd");
        params.put("payment_method_types", java.util.List.of("card"));
        params.put("transfer_data", Map.of("destination", connectedAccountId));

        return PaymentIntent.create(params);
    }
}
