package com.bd.medico2025.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.medico2025.modelo.TblMedico;
import com.bd.medico2025.repositorio.IMedicoRepositorio;

@Service
public class MedicoServicioImp implements IMedicoServicio {
	
	//aplicamos la inyeccion de dependencia...
	@Autowired   //esta anotacion habilita la inyeccion de dependencia...
	private IMedicoRepositorio imedicorepositorio;
	
	
	@Override
	public void RegistrarMedico(TblMedico tblmedico) {
		// invocamos al metodo registrar
		imedicorepositorio.save(tblmedico);
		
	} //fin del metodo registrar

	@Override
	public void EliminarMedico(TblMedico tblmedico) {
		//invocamos el metodo eliminar ...
		imedicorepositorio.deleteById(tblmedico.getIdmedicot3());
		
	} //fin del método eliminar

	@Override
	public List<TblMedico> ListadoMedicos() {
		// TODO Auto-generated method stub
		return (List<TblMedico>) imedicorepositorio.findAll();
	} //fin del metodo listar

	@Override
	public TblMedico buscarporId(Integer id) {
		// TODO Auto-generated method stub
		return imedicorepositorio.findById(id).orElse(null);
	}// fin del metodo buscar

}//fin de la clase...
