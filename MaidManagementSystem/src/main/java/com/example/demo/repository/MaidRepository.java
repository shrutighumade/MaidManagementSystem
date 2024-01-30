package com.example.demo.repository;

import com.example.demo.entity.Maid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaidRepository extends JpaRepository<Maid, Integer> {
    // Add custom queries if needed
}
