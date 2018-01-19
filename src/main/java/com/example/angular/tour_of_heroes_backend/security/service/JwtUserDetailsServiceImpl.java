package com.example.angular.tour_of_heroes_backend.security.service;

import com.example.angular.tour_of_heroes_backend.model.security.User;
import com.example.angular.tour_of_heroes_backend.security.JwtUserFactory;
import com.example.angular.tour_of_heroes_backend.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username \'%s\'.", username));
        }
        return JwtUserFactory.create(user);

    }
}
