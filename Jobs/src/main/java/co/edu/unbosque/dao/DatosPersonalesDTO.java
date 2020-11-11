package co.edu.unbosque.dao;

import java.sql.Date;
import com.sun.istack.NotNull;

public class DatosPersonalesDTO {

	@NotNull
	private int t_Documento;
	@NotNull
	private int num_Documento;
	@NotNull
	private String p_Nombre;
	@NotNull
	private String s_Nombre;
	@NotNull
	private String p_Apellido;
	@NotNull
	private String s_Apellido;
	@NotNull
	private Date f_Nacimiento;
	@NotNull
	private int genero;
	@NotNull
	private int estadoCivil;
	@NotNull
	private int ciudadResidencia;
	@NotNull
	private String telefono;

	public DatosPersonalesDTO() {

	}

	public DatosPersonalesDTO(int t_Documento, int num_Documento, String p_Nombre, String s_Nombre, String p_Apellido,
			String s_Apellido, Date f_Nacimiento, int genero, int estadoCivil, int ciudadResidencia, String telefono) {
		super();
		this.t_Documento = t_Documento;
		this.num_Documento = num_Documento;
		this.p_Nombre = p_Nombre;
		this.s_Nombre = s_Nombre;
		this.p_Apellido = p_Apellido;
		this.s_Apellido = s_Apellido;
		this.f_Nacimiento = f_Nacimiento;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.ciudadResidencia = ciudadResidencia;
		this.telefono = telefono;
	}

	public int getT_Documento() {
		return t_Documento;
	}

	public void setT_Documento(int t_Documento) {
		this.t_Documento = t_Documento;
	}

	public int getNum_Documento() {
		return num_Documento;
	}

	public void setNum_Documento(int num_Documento) {
		this.num_Documento = num_Documento;
	}

	public String getP_Nombre() {
		return p_Nombre;
	}

	public void setP_Nombre(String p_Nombre) {
		this.p_Nombre = p_Nombre;
	}

	public String getS_Nombre() {
		return s_Nombre;
	}

	public void setS_Nombre(String s_Nombre) {
		this.s_Nombre = s_Nombre;
	}

	public String getP_Apellido() {
		return p_Apellido;
	}

	public void setP_Apellido(String p_Apellido) {
		this.p_Apellido = p_Apellido;
	}

	public String getS_Apellido() {
		return s_Apellido;
	}

	public void setS_Apellido(String s_Apellido) {
		this.s_Apellido = s_Apellido;
	}

	public Date getF_Nacimiento() {
		return f_Nacimiento;
	}

	public void setF_Nacimiento(Date f_Nacimiento) {
		this.f_Nacimiento = f_Nacimiento;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(int ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
