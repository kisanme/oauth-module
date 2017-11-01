package org.ucsc.ewa.oauthModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.ucsc.ewa.oauthModule.model.AppUser;
import org.ucsc.ewa.oauthModule.repository.UserRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser userByUsername = userRepository.findOneByUsername(s);

        List<GrantedAuthority> setAuths = new ArrayList<>();
        setAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(userByUsername.getUsername(),
                userByUsername.getPassword(), userByUsername.isEnabled(),
                true, true, true, setAuths);

    }
}
