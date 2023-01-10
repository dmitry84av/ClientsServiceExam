package com.example.clientsserviceexam.repositiries;

import com.example.clientsserviceexam.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
