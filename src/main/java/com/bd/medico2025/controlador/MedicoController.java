package com.bd.medico2025.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.medico2025.modelo.TblMedico;
import com.bd.medico2025.servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoController {

	//aplicamos inyeccion de dependencia....
	@Autowired
	private IMedicoServicio imedicoservicio;	
	
	//listado de medicos
	@GetMapping("ListadoMedicos")
    public String listarMedicos(Model modelo) {
		//recuperamos los datos de la BD.....
		List<TblMedico> listado=imedicoservicio.ListadoMedicos();
		//enviamos hacia la vista...
		modelo.addAttribute("listado",listado);
		//retornamos
		return "/Vistas/ListadoMedicos";	
	}   //fin del metodo listado medicos...
	
	//creamos el metodo para registrar  datos...
	@GetMapping("/RegistrarMedico")
	public String RegistrarMedico(Model modelo) {
		//realizamos la respectiva instancia..
		TblMedico tblmed=new TblMedico();
		//enviamos hacia la vista...
		modelo.addAttribute("regmedico",tblmed);
		//retornamos al formulario...
		return "/Vistas/FrmRegMedico";	
	}  //fin del metodo registrar...
	
	//realizamos el mapeo con postmapping...
	@PostMapping("/GuardarMedico")
	public String GuardarMedico(@ModelAttribute TblMedico tblmed,Model modelo) {	
		imedicoservicio.RegistrarMedico(tblmed);
		//emitimos mensaje por consola...
		System.out.println("dato registrado en  la BD...");
		//retornamos el listado..
		return "redirect:/Vistas/ListadoMedicos";		
	}  //fin del metodo...
	
	//*********************editar.....
	@GetMapping("/editarmedico/{id}")
	public String Editar(@PathVariable("id") Integer idmedico,Model modelo) {
		//creamos un objeto de tipo tblmedico...
		TblMedico clmedico=imedicoservicio.buscarporId(idmedico);
		//enviamos hacia la vista...
		modelo.addAttribute("regmedico",clmedico);
		return "/Vistas/FrmRegMedico";
		
	}   //fin del metodo editar...
	
	//*****************eliminar...
	//creamos el metodo eliminar..
	@GetMapping("/eliminarmedico/{id}")
	public String eliminar(@PathVariable("id") Integer idmedico,Model modelo) {
		TblMedico tblmed=new TblMedico();
		tblmed.setIdmedicot3(idmedico);
		//aplicamos la inyeccion de dependencia...
		imedicoservicio.EliminarMedico(tblmed);
		//actualizamos el listado...
		List<TblMedico> listado=imedicoservicio.ListadoMedicos();
		//enviamos hacia la vista...
		modelo.addAttribute("listado",listado);
		//redireccionamos
		return "redirect:/Vistas/ListadoMedicos";
		
	}   //fin del metodo....
}
