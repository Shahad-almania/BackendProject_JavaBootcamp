package com.example.invitation_card_projectbackend.Repository;

import com.example.invitation_card_projectbackend.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCustomer extends JpaRepository<Customer,Integer> {
}
