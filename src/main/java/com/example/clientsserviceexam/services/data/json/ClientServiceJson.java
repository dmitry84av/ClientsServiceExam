package com.example.clientsserviceexam.services.data.json;

import com.example.clientsserviceexam.models.Client;
import com.example.clientsserviceexam.services.data.ClientService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceJson {
    private final String clientsFile = "clients.json";

    public List<Client> saveAll(List<Client> clients) {
        try {
            FileWriter writer = new FileWriter(clientsFile);
            new Gson().toJson(new JsonWriter(writer));
            writer.flush();
        }
        catch (Exception ignored) {

        }
        return clients;
    }
}
