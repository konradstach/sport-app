package com.example.sportapp.repository;

import com.example.sportapp.model.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
}
