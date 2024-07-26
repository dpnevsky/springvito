package com.example.springvito.repositories;

import com.example.springvito.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public Person findByNickname(String nickname);
}

