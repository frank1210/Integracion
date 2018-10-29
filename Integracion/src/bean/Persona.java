package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Persona")
@Inheritance(strategy = InheritanceType.JOINED)

public class Persona {
	@Column (name = "Nombre", nullable = false, length = 20)
	private String Nombre;
	@Id
	@Column (name = "Dni", nullable = false, length = 14)
	private String Dni;
	@Column (name = "mail", nullable = false, length = 25)
	private String mail;
	@Column (name = "Apellido", nullable = false, length = 20)
	private String Apellido;
	@Column (name = "Domicilio", nullable = false, length = 50)
	private String Domicilio;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	
	
	
}
