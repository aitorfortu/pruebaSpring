package org.afortuna.simexamen.controllers;

import javax.servlet.http.HttpSession;

import org.afortuna.simexamen.domain.Habitacion;
import org.afortuna.simexamen.exception.DangerException;
import org.afortuna.simexamen.helper.PRG;
import org.afortuna.simexamen.repositories.HabitacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/habitacion")
public class HabitacionController {

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@GetMapping("c")
	public String habitacionCGet(ModelMap m) {
		m.put("view","habitacion/cGet");
		return "/_t/frame";
	}
	
	@PostMapping("c")
	public String habitacionCPost(
			@RequestParam("numHabitacion") Integer numHabitacion,
			@RequestParam("numCamas") Integer numCamas,
			ModelMap data
			)
			throws DangerException {
		numHabitacion = (numHabitacion==null?100:numHabitacion);
		numCamas = (numCamas==null?1:numCamas);
		numCamas = (numCamas>10?10:numCamas);
		
		
		
		
		
		Habitacion habitacion= new Habitacion(numHabitacion, numCamas);
	
				try {
					habitacionRepository.save(habitacion);
				}
				catch (Exception e) {
					PRG.error("Habitación duplicada","/habitacion/r");
				}
				return "redirect:/habitacion/r";
	}
	@GetMapping("r")
	public String habitacionRGet(
			ModelMap m
			) {
		m.put("habitaciones",habitacionRepository.findAll());
		m.put("view", "habitacion/rGet");
		return "/_t/frame";
	}
	
	@GetMapping("d")
	public String habitacionDGet(
			@RequestParam Long idHabitacion,
			HttpSession s) throws DangerException {
		Habitacion habitacion=habitacionRepository.getOne(idHabitacion);
		habitacionRepository.delete(habitacion);
		return "redirect:/habitacion/r";
	}
	
	
}
