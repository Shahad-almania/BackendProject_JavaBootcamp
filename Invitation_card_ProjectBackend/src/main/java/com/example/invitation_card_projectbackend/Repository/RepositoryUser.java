package com.example.invitation_card_projectbackend.Repository;


import com.example.invitation_card_projectbackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User,Integer> {
  User findUserByUsername(String username);

}
