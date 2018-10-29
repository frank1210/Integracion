package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Empleado")
public class Empleado {
	//@Id
	private int NroEmpleado;
	private int SueldoBasico;

	public int getSueldoBasico() {
		return SueldoBasico;
	}

	public void setSueldoBasico(int sueldoBasico) {
		SueldoBasico = sueldoBasico;
	}
	
	
}
