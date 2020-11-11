package co.edu.unbosque.dao;

import java.sql.Date;

public class ExperienciaDTO {

	private String empresa;
	private String cargo;
	private String funciones;
	private int ciudad;
	private Date f_inicio;
	private Date f_fin;

	public ExperienciaDTO() {

	}

	public ExperienciaDTO(String empresa, String cargo, String funciones, int ciudad, Date f_inicio, Date f_fin) {
		this.empresa = empresa;
		this.cargo = cargo;
		this.funciones = funciones;
		this.ciudad = ciudad;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

	public Date getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(Date f_incio) {
		this.f_inicio = f_incio;
	}

	public Date getF_fin() {
		return f_fin;
	}

	public void setF_fin(Date f_fin) {
		this.f_fin = f_fin;
	}

}
