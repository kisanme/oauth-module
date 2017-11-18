package org.ucsc.ewa.oauthModule.service;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucsc.ewa.oauthModule.dto.ResetPasswordDTO;
import org.ucsc.ewa.oauthModule.dto.TokenDTO;
import org.ucsc.ewa.oauthModule.dto.UserDTO;
import org.ucsc.ewa.oauthModule.exception.InvalidToken;
import org.ucsc.ewa.oauthModule.exception.UserNameAlreadyExists;
import org.ucsc.ewa.oauthModule.model.AppUser;
import org.ucsc.ewa.oauthModule.model.UserToken;
import org.ucsc.ewa.oauthModule.repository.UserRepository;
import org.ucsc.ewa.oauthModule.repository.UserTokenRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserTokenRepository userTokenRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser userByUsername = userRepository.findOneByUsername(s);

        List<GrantedAuthority> setAuths = new ArrayList<>();
        setAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(userByUsername.getUsername(),
                userByUsername.getPassword(), userByUsername.isEnabled(),
                true, true, true, setAuths);

    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO user) throws UserNameAlreadyExists {


        AppUser userByUsername = userRepository.findOneByUsername(user.getUserName());
        if(userByUsername!= null){
            throw new UserNameAlreadyExists();
        }

        AppUser userToSave=new AppUser();
        userToSave.setEnabled(false);
        userToSave.setUsername(user.getUserName());
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser createdUser = userRepository.save(userToSave);

        Long userId = createdUser.getId();

        String s = RandomStringUtils.randomAlphanumeric(5);
        UserToken token =new UserToken();

        token.setAppUserId(userId);
        token.setUserToken(s);

        userTokenRepository.save(token);

        user.setId(userId);

        return user;



    }

    @Transactional
    @Override
    public void validateToken(TokenDTO token) throws InvalidToken {


        UserToken oneByAppUserIdAndToken = userTokenRepository
                .findOneByAppUserIdAndUserToken(token.getUserId(), token.getToken());
        if(oneByAppUserIdAndToken==null){
            throw new InvalidToken();
        }

        long appUserId = oneByAppUserIdAndToken.getAppUserId();
        AppUser one = userRepository.findOne(appUserId);
        one.setEnabled(true);
        userRepository.save(one);
    }

    @Override
    public void resetPassword(ResetPasswordDTO resetPasswordDTO) {

        String password = resetPasswordDTO.getPassword();
        String token = resetPasswordDTO.getToken();
        if(token.equals("Huhuki")){

        }

    }
}
