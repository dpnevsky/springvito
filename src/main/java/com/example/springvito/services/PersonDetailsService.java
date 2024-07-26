package com.example.springvito.services;

import com.example.springvito.models.Person;
import com.example.springvito.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonService personService;

    public PersonDetailsService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.findByNickName(username);
        if(person == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new PersonDetails(person);
    }

}
