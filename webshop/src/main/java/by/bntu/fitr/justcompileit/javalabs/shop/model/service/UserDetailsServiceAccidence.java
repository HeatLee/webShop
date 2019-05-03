package by.bntu.fitr.justcompileit.javalabs.shop.model.service;

import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.Role;
import by.bntu.fitr.justcompileit.javalabs.shop.model.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceAccidence implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserDetailsServiceAccidence.class);
    private static final String USERNAME_NOT_FOUND_MESSAGE = "User with this username not found.";


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            LOGGER.warn(USERNAME_NOT_FOUND_MESSAGE);
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> roles = new HashSet<>();

        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
