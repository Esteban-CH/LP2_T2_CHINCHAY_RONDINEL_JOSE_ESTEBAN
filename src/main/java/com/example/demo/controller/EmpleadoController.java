package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/listar_empleados")
	public String listarEmpleados(Model model) {
		List<EmpleadoEntity> empleado = empRepository.findAll();
		model.addAttribute("empleado", empleado);
		return("/empleados/listar");
	}
	
	@GetMapping("/eliminar_empleado/{id}")
	public String eliminarEmpleados(@PathVariable("id")Integer id) {
		empRepository.deleteById(id);
		return("redirect:/listar_empleados");
	}
	
	@GetMapping("/registrar_empleado")
	public String mostrarVistaRegistrarEmpleados(Model model) {
		List<AreaEntity> area = areaRepository.findAll();
		model.addAttribute("area", area);
		model.addAttribute("empleado", new EmpleadoEntity());
		return("/empleados/registrar");
	}
}
