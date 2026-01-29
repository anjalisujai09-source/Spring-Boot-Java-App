package com.example.demo.repository;

import com.example.demo.model.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
}

