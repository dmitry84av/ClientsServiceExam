package com.example.clientsserviceexam.controllers;

import com.example.clientsserviceexam.models.Company;
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

import java.util.List;

@Controller
public class CompaniesController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("companies")
	public String load(Model model) {
		List<Company> list = companyService.findAll();
		model.addAttribute("company", list);
		return "companies";
	}
	@PostMapping("addCompanyForm")
	public String addCompanyForm(@ModelAttribute Company company) {
		companyService.save(company);
		return "redirect:companies";
	}
	@PostMapping("openCompanyForm")
	public ModelAndView openCompanyForm(@RequestParam("id")Integer id){
		return new ModelAndView("redirect:companyUpdate", new ModelMap("id",id));
	}
}
