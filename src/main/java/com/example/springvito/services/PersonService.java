package com.example.springvito.services;

import com.example.springvito.models.Person;
import com.example.springvito.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonService{


    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;

    @Autowired
    PersonService(PasswordEncoder passwordEncoder, PersonRepository personRepository){
        this.passwordEncoder = passwordEncoder;
        this.personRepository = personRepository;
    }
    
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Transactional
    public void savePerson(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }

    public Person findByNickName(String nickname){
        return personRepository.findByNickname(nickname);
    }


}
