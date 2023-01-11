package com.example.clientsserviceexam.models;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "companies")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false,length = 100)
    private  String address;
    @Column(nullable = false)
    private  String city;
    @OneToMany(mappedBy = "company")
    private Set<Client> clients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(getId(), company.getId()) && Objects.equals(getAddress(), company.getAddress()) && Objects.equals(getCity(), company.getCity()) && Objects.equals(getClients(), company.getClients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getCity(), getClients());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", clients=" + clients +
                '}';
    }
}
