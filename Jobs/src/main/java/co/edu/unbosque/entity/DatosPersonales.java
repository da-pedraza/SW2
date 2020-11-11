package co.edu.unbosque.entity;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DatosPersonales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "id_usuario", updatable = false, nullable = false)
	@JsonIgnoreProperties("datos_personales")
	private Usuario usuario;
	private int t_Documento;
	private int numDocumento;
	private String p_Nombre;
	private String s_Nombre;
	private String p_Apellido;
	private String s_Apellido;
	private Date f_Nacimiento;
	private int genero;
	private int estadoCivil;
	private int ciudadResidencia;
	private String telefono;

	public DatosPersonales() {

	}

	public DatosPersonales(int t_Documento, int numDocumento, String p_Nombre, String s_Nombre, String p_Apellido,
			String s_Apellido, Date f_Nacimiento, int genero, int estadoCivil, int ciudadResidencia, String telefono) {
		this.t_Documento = t_Documento;
		this.numDocumento = numDocumento;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getT_Documento() {
		return t_Documento;
	}

	public void setT_Documento(int t_Documento) {
		this.t_Documento = t_Documento;
	}

	public int getNum_Documento() {
		return numDocumento;
	}

	public void setNum_Documento(int numDocumento) {
		this.numDocumento = numDocumento;
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
