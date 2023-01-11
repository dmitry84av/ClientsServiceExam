package com.example.clientsserviceexam.serviceDbTest;
import com.example.clientsserviceexam.models.Client;
import com.example.clientsserviceexam.services.data.ClientService;
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
public class ClientServiceDbTest {
    @Qualifier("clientServiceDb")
    @Autowired
    ClientService clientService;
    static Client a = new Client(0, "a", "a", "a", Client.Gender.MALE,null);;
    static Client b = new Client(1, "b", "b", "b", Client.Gender.FEMALE,null);;

    @Test
    @Order(1)
    public void saveAll() {
        Client a_saved = clientService.save(a);
        Client b_saved = clientService.save(b);

        a.setId((a_saved.getId()));
        b.setId((b_saved.getId()));
        assertEquals(a, a_saved);
        assertEquals(b, b_saved);
    }
    @Test
    @Order(4)
    public void findAllBySurnameNamePatronymic() {
        List<Client> actual =
                clientService.findAllBySurnameAndNameAndPatronymic(
                        a.getSurname(),a.getName(),a.getPatronymic()
                );
        System.out.println(actual);
        assertEquals(a, actual.get(0));
    }
}
