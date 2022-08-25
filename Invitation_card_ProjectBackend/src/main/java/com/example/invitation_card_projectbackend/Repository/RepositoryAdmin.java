package com.example.invitation_card_projectbackend.Repository;

import com.example.invitation_card_projectbackend.Model.Admin;
import com.example.invitation_card_projectbackend.Model.CardOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryAdmin extends JpaRepository<Admin,Integer> {

}
