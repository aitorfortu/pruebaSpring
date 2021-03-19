package org.afortuna.simexamen.controllers;

import javax.servlet.http.HttpSession;

import org.afortuna.simexamen.domain.Cliente;
import org.afortuna.simexamen.exception.DangerException;
import org.afortuna.simexamen.helper.PRG;
import org.afortuna.simexamen.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente/c")
	public String clienteCGet(ModelMap m) {
		m.put("view","cliente/cGet");
		return "/_t/frame";
	}
	
	@PostMapping("/cliente/c")
	public String clienteCPost(
			@RequestParam("dni") Integer dni,
			@RequestParam("nombre") String nombre, 
			ModelMap data) throws DangerException {
		if(nombre=="") 
			PRG.error("Nombre vacío","/cliente/r");
		
		
		Cliente cliente=new Cliente(dni,nombre);
		
		try {
			clienteRepository.save(cliente);
		}catch (Exception e) {
			PRG.error("DNI duplicado","/cliente/r");
		}
		return "redirect:/cliente/r";
		
	}
	
	@GetMapping("/cliente/r")
	public String clienteRGet(
			ModelMap m
			) {
		m.put("clientes",clienteRepository.findAll());
		m.put("view", "cliente/rGet");
		return "/_t/frame";
	}
	//hola
	@GetMapping("/cliente/d")
	public String clienteDGet(
			@RequestParam Long idCliente, 
			HttpSession s) throws DangerException {
		Cliente cliente=clienteRepository.getOne(idCliente);
		clienteRepository.delete(cliente);
		return "redirect:/cliente/r";
	}
}
