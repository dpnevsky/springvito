package com.example.springvito.security;

import com.example.springvito.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService, PasswordEncoder passwordEncoder) {
        this.personDetailsService = personDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails userDetails = personDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        };
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
