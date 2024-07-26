package com.example.springvito.repositories;

import com.example.springvito.models.PersonalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalItemRepository extends JpaRepository<PersonalItem, Integer> {
}
