package com.example.invitation_card_projectbackend.Service;

import com.example.invitation_card_projectbackend.Data_Transfer_Object.RegisterForm;
import com.example.invitation_card_projectbackend.Model.Admin;
import com.example.invitation_card_projectbackend.Model.Customer;
import com.example.invitation_card_projectbackend.Model.User;
import com.example.invitation_card_projectbackend.Repository.RepositoryAdmin;
import com.example.invitation_card_projectbackend.Repository.RepositoryCustomer;
import com.example.invitation_card_projectbackend.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    private final RepositoryUser repositoryUser;
    private final RepositoryCustomer repositoryCustomer;
    private final RepositoryAdmin repositoryAdmin;

    public void register(RegisterForm registerForm){

        //Use hashed Password instead normal password for Security
        String hashedPassword= new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        User user1 =new User(null,registerForm.getUsername(),registerForm.getPassword(),registerForm.getEmail(),registerForm.getNumberPhone(),registerForm.getRole());
        User newUser=repositoryUser.save(user1);
        if(registerForm.getRole().equals("Customer")){
            Customer customer=new Customer(null,registerForm.getCustomerName() ,registerForm.getAge(),newUser.getId());
            repositoryCustomer.save(customer);
        }else{
           Admin admin=new Admin(null,registerForm.getFullName(),newUser.getId());
           repositoryAdmin.save(admin);
        }

    }
    public void updateuser(User user,Integer id){
        User user1=repositoryUser.getById(id);
        repositoryUser.save(user1);
    }
    public void deleteuser(Integer id){
        User user=repositoryUser.getById(id);
        repositoryUser.delete(user);
    }
}




