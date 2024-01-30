package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

//    Optional<Client> findByContactNumber(String contactNumber);
//
//    Optional<Client> findByName(String name);

    // Add custom query methods if needed
}
