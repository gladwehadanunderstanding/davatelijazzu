package com.example.davatelijazzu.service;


import com.example.davatelijazzu.Repos.UserRepos;
import com.example.davatelijazzu.entity.Role;
import com.example.davatelijazzu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepos userRepos;

    @Autowired
    private Mailer mailer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepos.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userDb=userRepos.findByUsername(user.getUsername());

        if(userDb != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());

        userRepos.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s \n" + "Welcome to Gym Davateli Jazzu, visit next link: http://localhost:8182/activation/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailer.send(user.getEmail(), "Activation code", message);
        }

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepos.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);

        userRepos.save(user);

        return true;
    }

}
