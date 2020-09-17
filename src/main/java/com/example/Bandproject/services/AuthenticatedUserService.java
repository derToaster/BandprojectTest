//package com.example.Bandproject.services;
//
//
//import com.example.Bandproject.models.User;
//import com.example.Bandproject.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthenticatedUserService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username){
//
//        User user = userRepository.findByUsername(username);
//        if (user == null)
//        { throw new UsernameNotFoundException("the user" + username + "does not exist");}
//
//        return new AuthenticatedUser(user);
//    }
//}
