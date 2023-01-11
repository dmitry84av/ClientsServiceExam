package com.example.clientsserviceexam.serviceDbTest.json;

import com.example.clientsserviceexam.models.Client;
import com.example.clientsserviceexam.services.data.ClientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceJsonTest {
    @Qualifier("clientServiceJson")
    @Autowired
    ClientService clientService;
    static Client a = new Client(0, "a", "a", "a", Client.Gender.MALE,null);;
    static Client b = new Client(1, "b", "b", "b", Client.Gender.FEMALE,null);;

    @Test
    @Order(1)
    void save() {
        Client actual = clientService.save(a);
        a.setId(actual.getId());
        //Assertions.assertEquals(a, actual);
        System.out.println(clientService.findAll());
    }
}
