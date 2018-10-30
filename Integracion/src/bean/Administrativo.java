package bean;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Administrativo")
public class Administrativo extends Empleado{
	private int Presentismo;

	public int getPresentismo() {
		return Presentismo;
	}

	public void setPresentismo(int presentismo) {
		Presentismo = presentismo;
	}

	@Override
	public float liquidarsueldo() {
		// TODO Auto-generated method stub
		return this.getSueldoBasico() + this.getPresentismo();
	}
	
}
