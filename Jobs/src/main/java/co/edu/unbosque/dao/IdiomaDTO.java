package co.edu.unbosque.dao;

public class IdiomaDTO {

	private int idioma;
	private int nivelIdioma;

	public IdiomaDTO() {

	}

	public IdiomaDTO(int idioma, int nivelIdioma) {
		this.idioma = idioma;
		this.nivelIdioma = nivelIdioma;
	}

	public int getIdioma() {
		return idioma;
	}

	public void setIdioma(int idioma) {
		this.idioma = idioma;
	}

	public int getNivelIdioma() {
		return nivelIdioma;
	}

	public void setNivelIdioma(int nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

}
