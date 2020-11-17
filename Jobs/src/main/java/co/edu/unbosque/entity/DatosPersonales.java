package co.edu.unbosque.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	//private int t_Documento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
	private int numDocumento;
	private String p_Nombre;
	private String s_Nombre;
	private String p_Apellido;
	private String s_Apellido;
	private Date f_Nacimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genero")
	private Genero genero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_civil")
	private EstadoCivil estadoCivil;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad")
	private Ciudad ciudadResidencia;
	private String telefono;

	public DatosPersonales() {

	}

	public DatosPersonales(TipoDocumento tipoDocumento, int numDocumento, String p_Nombre, String s_Nombre, String p_Apellido,
			String s_Apellido, Date f_Nacimiento, Genero genero, EstadoCivil estadoCivil, Ciudad ciudadResidencia,
			String telefono) {
		this.tipoDocumento = tipoDocumento;
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

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(int numDocumento) {
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Ciudad getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(Ciudad ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
