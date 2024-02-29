package com.empresa.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	//La anotación id se utiliza para especificar en sql que es campo id
	@Id
	//Se utiliza para saber que es un autoincremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//longitud en la base de datos del campo
	@Column(length = 256, nullable = false)
	private String nombre;
	
	@Column(length = 256)
	private String apellido;
	
	//No puede ser nulo y debe ser unico
	@Column(length = 256, nullable = false, unique = true)
	private String email;
	
	//nombre que va a recibir en la base de datos
	@Column(name = "create_at")
	//Se especifica el tipo de dato qu se quiere manejar: Date, Timestamp, time
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Column(name = "fecha_nac")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
