package com.example.clientsserviceexam.services.data.db;
import com.example.clientsserviceexam.models.Company;
import com.example.clientsserviceexam.repositiries.CompanyRepository;
import com.example.clientsserviceexam.services.data.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CompanyServiceDb implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> saveAll(List<Company> company) {
        return companyRepository.saveAll(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
