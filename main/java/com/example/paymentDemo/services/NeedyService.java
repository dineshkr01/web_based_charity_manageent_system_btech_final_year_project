package com.example.paymentDemo.services;

import com.example.paymentDemo.models.Needy;
import com.example.paymentDemo.repositories.NeedyRepository;
import com.example.paymentDemo.stripe.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NeedyService {

    @Autowired
    private NeedyRepository needyRepository;

    @Autowired
    private StripeService stripeService;

    public Needy saveNeedy(Needy needy) throws StripeException {
        // Create Stripe connected account
        Account account = stripeService.createConnectedAccount();
        needy.setStripeId(account.getId());
        return needyRepository.save(needy);
    }

    public List<Needy> getAllNeedy() {
        return needyRepository.findAll();
    }

    public Optional<Needy> getNeedyById(Long id) {
        return needyRepository.findById(id);
    }
}
