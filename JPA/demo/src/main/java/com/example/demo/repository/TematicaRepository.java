package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tematica;

@Repository
public interface TematicaRepository extends JpaRepository<Tematica, Long> {}