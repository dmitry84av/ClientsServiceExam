package com.example.clientsserviceexam.controllers;
import com.example.clientsserviceexam.models.Client;
import com.example.clientsserviceexam.models.Company;
import com.example.clientsserviceexam.services.data.ClientService;
import com.example.clientsserviceexam.services.data.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("clientUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Client client = clientService.findById(id);
        if (client.getCompany() == null)
            client.setCompany(new Company());
        model.addAttribute("client",client);
        model.addAttribute("genders",Client.Gender.values());
        return "clientUpdate";
    }
    @PostMapping("updateClientForm")
    public ModelAndView method(@ModelAttribute Client client){
        System.err.println(client);
        clientService.save(client);
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("id",client.getId()));

    }
    @PostMapping("updateClientCompanyForm")
    public ModelAndView updateClientCompanyForm(
        @ModelAttribute Client client,
        @ModelAttribute Company company,
        @RequestParam(value = "idCompany", required = false) Integer idCompany
        )     {
            company.setId(idCompany);
            System.err.println(client);
            System.err.println(company);
            company= companyService.save(company);
            client.setCompany(company);
            clientService.save(client);
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("id",client.getId()));
    }
}
