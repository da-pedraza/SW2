package co.edu.unbosque.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> rol = new HashSet<>();

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private DatosPersonales datos_personales;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Experiencia> experiencia;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Formacion> formacion;

	// private List<Idioma> idioma;

	// private List<Postulaciones> postulaciones;

	public Usuario() {

	}

	public Usuario(String email, String password, DatosPersonales datos_personales) {
		this.email = email;
		this.password = password;
		this.datos_personales = datos_personales;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DatosPersonales getDatos_personales() {
		return datos_personales;
	}

	public void setDatos_personales(DatosPersonales datos_personales) {
		this.datos_personales = datos_personales;
	}

	public List<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public List<Formacion> getFormacion() {
		return formacion;
	}

	public void setFormacion(List<Formacion> formacion) {
		this.formacion = formacion;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}

}
