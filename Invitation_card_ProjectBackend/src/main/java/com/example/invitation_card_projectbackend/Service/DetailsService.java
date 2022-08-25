package com.example.invitation_card_projectbackend.Service;

import com.example.invitation_card_projectbackend.Model.User;
import com.example.invitation_card_projectbackend.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailsService implements UserDetailsService{

    private final RepositoryUser repositoryUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repositoryUser.findUserByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Wrong username or passpord");
        }
        return user;
    }
}
