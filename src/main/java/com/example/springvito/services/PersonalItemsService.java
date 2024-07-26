package com.example.springvito.services;

import com.example.springvito.models.PersonalItem;
import com.example.springvito.repositories.PersonalItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalItemsService {

    private final PersonalItemRepository personalItemRepository;

    @Autowired
    public PersonalItemsService(PersonalItemRepository personalItemRepository) {
        this.personalItemRepository = personalItemRepository;
    }

    public List<PersonalItem> findAll(){
        return personalItemRepository.findAll();
    }

    @Transactional
    public void saveById(PersonalItem personalItem){
        personalItemRepository.save(personalItem);
    }

    public void deleteById(int id){
        personalItemRepository.deleteById(id);
    }

    public PersonalItem findById(int id) {
        return personalItemRepository.findById(id).orElse(null);
    }
}
