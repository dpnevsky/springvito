package com.example.springvito.services;

import com.example.springvito.models.Realty;
import com.example.springvito.repositories.RealtyRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RealtyService {

    private final RealtyRepository realtyRepository;

    @Autowired
    public RealtyService(RealtyRepository realtyRepository) {
        this.realtyRepository = realtyRepository;
    }

    public List<Realty> findAll(){
        return realtyRepository.findAll(Sort.by(Sort.Order.asc("owner")));
    }

    @Transactional
    public void saveRealty(Realty realty){
        realtyRepository.save(realty);
    }

    public Realty findById(int id){
        return realtyRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        realtyRepository.deleteById(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void preAuth(){
        System.out.println("hello world");
    }


}
