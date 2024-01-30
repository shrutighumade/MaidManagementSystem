package com.example.demo.service.impl;

import com.example.demo.entity.Client;
import com.example.demo.entity.Maid;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MaidRepository;
import com.example.demo.service.MaidService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaidServiceImpl implements MaidService {

    @Autowired
    private MaidRepository maidRepository;

	@Autowired
	ModelMapper modelMapper;
    
    @Override
    public List<Maid> getAllMaids() {
        return maidRepository.findAll();
    }

    @Override
    public List<Maid> getMaidById(Integer maidId) throws ResourceNotFoundException{
    	Optional<Maid> optionalmaid = maidRepository.findById(maidId);
//      return optionalClient.orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
  
      if (optionalmaid.isPresent()) {
			return optionalmaid.stream().map(client -> modelMapper.map(optionalmaid, Maid.class))
					.collect(Collectors.toList());
		} else {
			// Handle the case where the customer with the given ID is not found
			throw new ResourceNotFoundException("Maid", " id", maidId);
		}
//      return maidRepository.findById(maidId).orElse(null);
    }

    @Override
    public Maid addMaid(Maid maid) {
        // Add any business logic or validation before saving
        return maidRepository.save(maid);
    }
    
 


    // Add implementations for other service methods as needed
}
