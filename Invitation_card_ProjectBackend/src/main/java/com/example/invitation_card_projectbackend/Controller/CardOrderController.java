package com.example.invitation_card_projectbackend.Controller;

import com.example.invitation_card_projectbackend.Data_Transfer_Object.ApiResponse;
import com.example.invitation_card_projectbackend.Model.CardOrder;

import com.example.invitation_card_projectbackend.Model.User;
import com.example.invitation_card_projectbackend.Service.CardOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/CardOrder")
public class CardOrderController {

    private final CardOrderService cardOrderService;

    @GetMapping()
    public ResponseEntity getCardOrder(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(200).body(cardOrderService.getCardOrder(user));
    }

    //Admin page you appear in orders for customer
    @GetMapping("/ordersPage")
    public ResponseEntity getCardOrder() {
        return ResponseEntity.status(200).body(cardOrderService.getCardOrder());
    }

    // add order only custmer
    @PostMapping
    public ResponseEntity addCardOrder(@RequestBody @Valid CardOrder cardOrder, @AuthenticationPrincipal User user){
        cardOrderService.addCardOrder(cardOrder,user);
        return ResponseEntity.status(201).body(new ApiResponse("Order has been successfully added ..",201));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCardOrder(@RequestBody @Valid CardOrder cardOrder,@PathVariable Integer id, @AuthenticationPrincipal User user){
        cardOrderService.updateCardOrder(cardOrder,id);
        return ResponseEntity.status(201).body(new ApiResponse("Order data update..",201));
    }

    //Admin page for update orders custmers
    @PutMapping("/ordersPage/{id}") //Order data update
    public ResponseEntity updateCardOrderPage(@RequestBody @Valid CardOrder cardOrder,@PathVariable Integer id, @AuthenticationPrincipal User user){
        cardOrderService.updateCardOrder(cardOrder,id);
        return ResponseEntity.status(201).body(new ApiResponse("Order data update..",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCardOrder(@PathVariable Integer id, @AuthenticationPrincipal User user){
        cardOrderService.deleteCardOrder(id);
        return ResponseEntity.status(201).body(new ApiResponse("Order data delete..",201));
    }

    //Admin page for delete orders custmers
    @DeleteMapping("/ordersPage/{id}")
    public ResponseEntity deleteCardOrderPage(@PathVariable Integer id, @AuthenticationPrincipal User user){
        cardOrderService.deleteCardOrder(id);
        return ResponseEntity.status(201).body(new ApiResponse("Order data delete..",201));
    }
}
