package com.example.clientsserviceexam;

import com.example.clientsserviceexam.models.Client;
import com.example.clientsserviceexam.repositiries.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.example.clientsserviceexam.models.Client.Gender.FEMALE;
import static com.example.clientsserviceexam.models.Client.Gender.MALE;

@SpringBootApplication
public class ClientsServiceExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsServiceExamApplication.class, args);
	}
    @Autowired
	private ClientRepository clientRepository;

	public ClientsServiceExamApplication(ClientRepository clientRepository) {this.clientRepository = clientRepository;}
	
	public void applicationReady() {
		Client a = new Client(0, "a", "a", "a", MALE,null);

		Client b = new Client(1, "b", "b", "b", FEMALE,null);
		clientRepository.saveAll(List.of(a, b));
	}
}
