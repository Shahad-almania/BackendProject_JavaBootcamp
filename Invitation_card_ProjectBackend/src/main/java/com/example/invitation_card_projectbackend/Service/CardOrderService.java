package com.example.invitation_card_projectbackend.Service;

import com.example.invitation_card_projectbackend.Model.CardOrder;

import com.example.invitation_card_projectbackend.Model.User;
import com.example.invitation_card_projectbackend.Repository.RepositoryCardOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardOrderService {

   private final RepositoryCardOrder repositoryCardOrder;

        public List<CardOrder> getCardOrder(User user){
        return repositoryCardOrder.findByCustomerId(user.getId());
    }
        public List<CardOrder> getCardOrder(){
        return repositoryCardOrder.findAll();
    }

   public void addCardOrder(CardOrder cardOrder, User user){
       cardOrder.setCustomerId(user.getId());
        repositoryCardOrder.save(cardOrder);
   }
   public void updateCardOrder(CardOrder cardOrder,Integer id){
        CardOrder order1= repositoryCardOrder.getById(id);
        order1.setEventTitle(cardOrder.getEventTitle());
        order1.setContent(cardOrder.getContent());
        order1.setDate(cardOrder.getDate());
        order1.setDay(cardOrder.getDay());
        order1.setLocation(cardOrder.getLocation());
        order1.setPrice(cardOrder.getPrice());
        order1.setStatus(cardOrder.getStatus());
        order1.setCustomerId(cardOrder.getCustomerId());
        order1.setCustomerUsername(cardOrder.getCustomerUsername());
        repositoryCardOrder.save(order1);
   }
   public void deleteCardOrder(Integer id){
        CardOrder orderr=repositoryCardOrder.getById(id);
        repositoryCardOrder.delete(orderr);
}
}
