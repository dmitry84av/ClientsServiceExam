package com.example.clientsserviceexam.controllers;

import com.example.clientsserviceexam.models.Client;
import com.example.clientsserviceexam.services.data.ClientService;
import com.example.clientsserviceexam.services.data.db.ClientServiceDb;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientsController {
	@Qualifier("clientServiceDb")
	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientServiceDb clientServiceDb;

	@GetMapping("clients")
	public String load(Model model) {
		List<Client> list = clientService.findAll();
		model.addAttribute("clients", list);
		model.addAttribute("genders", Client.Gender.values());
		return "clients";
	}
	@PostMapping("addClientForm")
	public String addClientForm(@ModelAttribute Client client) {
	clientService.save(client);
		return "redirect:clients";
	}
	@PostMapping("openClientForm")
	public ModelAndView openClientForm(@RequestParam("id")Integer id){
		return new ModelAndView("redirect:clientUpdate", new ModelMap("id",id));
	}
	@PostMapping("searchClientForm")
	public String searchClientForm(@ModelAttribute Client client, Model model) {
		List<Client> list = clientService.findAllBySurnameAndNameAndPatronymic(client.getSurname(), client.getName(), client.getPatronymic());
		if (list == null)
			list = new ArrayList<>();
		model.addAttribute("clients", list);
		return "clients";
	}
	@PostMapping("convertClientJsonForm")
	public String saveAll(List<Client> clients) {
		try {
			FileWriter writer = new FileWriter("clients.json");
			new Gson().toJson(clients,writer);
			writer.flush();
		}
		catch (Exception ignored) {
		}
		return "clients";
	}
}
