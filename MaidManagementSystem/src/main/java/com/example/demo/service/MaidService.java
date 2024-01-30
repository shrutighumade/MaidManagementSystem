package com.example.demo.service;

import com.example.demo.entity.Maid;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface MaidService {

    List<Maid> getAllMaids();

    List<Maid> getMaidById(Integer maidId)throws ResourceNotFoundException;

    Maid addMaid(Maid maid);

    // Add other service methods as needed
}
