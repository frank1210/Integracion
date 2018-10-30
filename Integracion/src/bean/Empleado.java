package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Empleado")
public abstract class Empleado extends Persona{
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
