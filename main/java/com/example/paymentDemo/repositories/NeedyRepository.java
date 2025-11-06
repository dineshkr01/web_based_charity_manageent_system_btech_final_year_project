package com.example.paymentDemo.repositories;

import com.example.paymentDemo.models.Needy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedyRepository extends JpaRepository<Needy, Long> {
}
