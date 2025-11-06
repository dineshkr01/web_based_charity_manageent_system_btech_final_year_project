package com.example.paymentDemo.controllers;

import com.example.paymentDemo.models.Needy;
import com.example.paymentDemo.services.NeedyService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/needy")
public class NeedyController {

    @Autowired
    private NeedyService needyService;

    @PostMapping
    public Needy addNeedy(@RequestBody Needy needy) throws StripeException {
        return needyService.saveNeedy(needy);
    }

    @GetMapping
    public List<Needy> getAllNeedy() {
        return needyService.getAllNeedy();
    }

    @GetMapping("/{id}")
    public Needy getNeedyById(@PathVariable Long id) {
        return needyService.getNeedyById(id).orElse(null);
    }
}
