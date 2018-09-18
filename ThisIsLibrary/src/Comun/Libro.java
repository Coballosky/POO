package Comun;

import javafx.scene.control.TextArea;

public class Libro {
	private String codigoLibro;
	private String titulo;
	private String autor;
	private String tema;
	private String idioma;
	private String estado;
	private boolean rentado;
	
	//Constructores
	public Libro() {
		codigoLibro = null;
		titulo = null;
		autor = null;
		tema = null;
		idioma = null;
		estado = null;
		rentado = false;
	}
	
	public Libro(String codigo, String nombreLibro, String autor, String tema, String idioma, String estado) {
		this.codigoLibro = codigo;
		this.titulo = nombreLibro;
		this.autor = autor;
		this.idioma = idioma;
		this.tema = tema;
		this.estado = estado;
		this.rentado = false;
	}
	
	//Getter & Setter
	public String getCode() {
		return codigoLibro;
	}
	public void setCode(String codigo) {
		this.codigoLibro = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean getRentado() {
		return rentado;
	}
	public void setRentado(boolean rentado) {
		this.rentado = rentado;
	}
	
	//Metodos
	public String infoLibro() {
		String info = getTema() + " " + getCode() + "|" + getTitulo() + ", " + getAutor() + "\n\tIdioma: " 
				+ getIdioma() + ", Estado: " + getEstado() + ", Rentado: ";
		
		if(getRentado() == true) {
			info = info + "SI";
		}
		else {
			info = info + "NO";
		}
		
		return info;
	}
	
	public void mostrarInfo(TextArea texto) {
		texto.appendText(infoLibro()+"\n\n");
	}
	
}