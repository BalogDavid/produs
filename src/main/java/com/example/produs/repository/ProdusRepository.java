package com.example.produs.repository;

import com.example.produs.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository extends JpaRepository<Produs, Long> {
}
