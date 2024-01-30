package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Client;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;



import java.util.List;

public interface ClientService {

    Client addClient(Client client);

    List<Client> findAllClients();

    List<Client> findClientById(int clientId) throws ResourceNotFoundException;

    // Uncomment and complete the methods for updating and deleting clients
}
