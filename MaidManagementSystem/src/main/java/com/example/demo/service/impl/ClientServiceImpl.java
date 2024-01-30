package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Client;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
	ModelMapper modelMapper;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientById(int clientId) throws ResourceNotFoundException {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
//        return optionalClient.orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
    
        if (optionalClient.isPresent()) {
			return optionalClient.stream().map(client -> modelMapper.map(optionalClient, Client.class))
					.collect(Collectors.toList());
		} else {
			// Handle the case where the customer with the given ID is not found
			throw new ResourceNotFoundException("Client", " id", clientId);
		}
    
    
    }

    // Uncomment and complete the methods for updating and deleting clients
}
