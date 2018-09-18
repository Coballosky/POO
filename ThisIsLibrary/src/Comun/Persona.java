package Comun;

import application.Rental;
import javafx.scene.control.TextArea;

public class Persona {
	private String rut;
	private String digVer;
	private String nombres;
	private String apellidos;
	private String rol;
	private String mail;
	private char sexo;
	private String direccion;
	private int cantRentas;
	private Rental[] rentas;
	
	//Constructores
	public Persona() {
		rut = null;
		digVer = null;
		nombres = null;
		apellidos = null;
		rol = null;
		mail = null;
		sexo = '-';
		direccion = null;
		cantRentas = 0;
		rentas = null;
	}
	public Persona(String rut, String verificador, String nombres, String apellidos, String rol, String mail, char sexo, String direccion, int cantRentas) {
		this.rut = rut;
		this.digVer = verificador;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
		this.mail = mail;
		this.sexo = sexo;
		this.direccion = direccion;
		this.cantRentas = cantRentas;
		this.rentas = new Rental[cantRentas];
	}
	
	//Getter & Setter
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getVerificador() {
		return digVer;
	}
	public void setVerificador(String verificador) {
		this.digVer = verificador;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCantRentas() {
		return cantRentas;
	}
	public void setCantRentas(int cantRentas) {
		this.cantRentas = cantRentas;
	}
	public Rental[] getRentas() {
		return rentas;
	}
	//Metodos
	public String infoPersona() {
		String info = "RUT: " + getRut() + "-" + getVerificador() + "\nNombre: " + getNombres() + " " 
				+ getApellidos() + "Sexo: " + getSexo() + "\nRol: " + getRol() + "\tMail: " + getMail() 
				+ "\nDireccion: " + getDireccion();
		
		return info;
	}
	
	public void mostrarInfo(TextArea texto) {
		texto.appendText(infoPersona());
	}
	
}
