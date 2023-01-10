package com.example.clientsserviceexam.services.data;

import com.example.clientsserviceexam.models.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    List<Client> saveAll(List<Client> clients);

    List<Client> findAll();

    Client findById(Integer id);
}
