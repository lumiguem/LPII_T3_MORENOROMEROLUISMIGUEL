package com.bd.medico2025.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="tbl_medicot3")
public class TblMedico {
	//declaramos sus atributos...
	//agregamos las respectivas anotaciones..
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmedicot3;
	private String nombret3;
	private String apellidot3;
	private String emailt3;
	private String estadocivilt3;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE)
	private Date fechanacimt3;
	
	
	
	public TblMedico() {
		//super();
	} //fin del constructor vacío...
	
	public TblMedico(int idmedicot3, String nombret3, String apellidot3, String emailt3, String estadocivilt3,
			Date fechanacimt3) {
		//super();
		this.idmedicot3 = idmedicot3;
		this.nombret3 = nombret3;
		this.apellidot3 = apellidot3;
		this.emailt3 = emailt3;
		this.estadocivilt3 = estadocivilt3;
		this.fechanacimt3 = fechanacimt3;
	}//fin del constructor con parametros...
	
	public int getIdmedicot3() {
		return idmedicot3;
	}
	public void setIdmedicot3(int idmedicot3) {
		this.idmedicot3 = idmedicot3;
	}
	public String getNombret3() {
		return nombret3;
	}
	public void setNombret3(String nombret3) {
		this.nombret3 = nombret3;
	}
	public String getApellidot3() {
		return apellidot3;
	}
	public void setApellidot3(String apellidot3) {
		this.apellidot3 = apellidot3;
	}
	public String getEmailt3() {
		return emailt3;
	}
	public void setEmailt3(String emailt3) {
		this.emailt3 = emailt3;
	}
	public String getEstadocivilt3() {
		return estadocivilt3;
	}
	public void setEstadocivilt3(String estadocivilt3) {
		this.estadocivilt3 = estadocivilt3;
	}
	public Date getFechanacimt3() {
		return fechanacimt3;
	}
	public void setFechanacimt3(Date fechanacimt3) {
		this.fechanacimt3 = fechanacimt3;
	}
	
	
	
	
} //fin de la clase
