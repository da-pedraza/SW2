package co.edu.unbosque.entity;

public class Idioma {

	private int id;
	private String nombre;
	private int nivelIdioma;

	public Idioma() {

	}

	public Idioma(int id, String nombre, int nivelIdioma) {
		this.id = id;
		this.nombre = nombre;
		this.nivelIdioma = nivelIdioma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelIdioma() {
		return nivelIdioma;
	}

	public void setNivelIdioma(int nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

}
