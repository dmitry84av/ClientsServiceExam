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
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Client> clients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return getId().equals(company.getId()) && getAddress().equals(company.getAddress()) && getCity().equals(company.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getCity());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
