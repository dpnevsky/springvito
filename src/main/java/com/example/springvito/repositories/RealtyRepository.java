package com.example.springvito.repositories;

import com.example.springvito.models.Realty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyRepository extends JpaRepository<Realty, Integer> {
}
