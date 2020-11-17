package co.edu.unbosque.dao;

import java.util.Date;

public class FormacionDTO {

	private String institucion;
	private String nivelFormacion;
	private String estadoFormacion;
	private Date f_inicio;
	private Date f_fin;

	public FormacionDTO() {

	}

	public FormacionDTO(String institucion, String nivelFormacion, String estadoFormacion, Date f_inicio, Date f_fin) {
		this.institucion = institucion;
		this.nivelFormacion = nivelFormacion;
		this.estadoFormacion = estadoFormacion;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getNivelFormacion() {
		return nivelFormacion;
	}

	public void setNivelFormacion(String nivelFormacion) {
		this.nivelFormacion = nivelFormacion;
	}

	public String getEstadoFormacion() {
		return estadoFormacion;
	}

	public void setEstadoFormacion(String estadoFormacion) {
		this.estadoFormacion = estadoFormacion;
	}

	public Date getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(Date f_inicio) {
		this.f_inicio = f_inicio;
	}

	public Date getF_fin() {
		return f_fin;
	}

	public void setF_fin(Date f_fin) {
		this.f_fin = f_fin;
	}

}
