package com.example.springvito.services;

import com.example.springvito.models.Auto;
import com.example.springvito.repositories.AutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutosService {


    private final AutoRepository autoRepository;

    @Autowired
    public AutosService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> findAll(){
        return autoRepository.findAll();
    }

    @Transactional
    public void saveAuto(Auto auto){
        autoRepository.save(auto);
    }

    public Auto findById(int id){
        return autoRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        autoRepository.deleteById(id);
    }

    @Transactional
    public void saveById(Auto auto){
        autoRepository.save(auto);
    }
}
