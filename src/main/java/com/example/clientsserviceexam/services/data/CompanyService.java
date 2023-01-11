package com.example.clientsserviceexam.services.data;

import com.example.clientsserviceexam.models.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);

    List<Company> saveAll(List<Company> company);


}
