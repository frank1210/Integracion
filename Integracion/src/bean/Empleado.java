package bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Empleado")
public abstract class Empleado extends Persona implements Serializable{
	//@Id
	private int NroEmpleado;
	private int SueldoBasico;
	

	public int getSueldoBasico() {
		return SueldoBasico;
	}

	public void setSueldoBasico(int sueldoBasico) {
		SueldoBasico = sueldoBasico;
	}

	public int getNroEmpleado() {
		return NroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		NroEmpleado = nroEmpleado;
	}
	public abstract float liquidarsueldo();
	
}
