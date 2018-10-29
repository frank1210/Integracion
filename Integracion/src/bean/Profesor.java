package bean;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Profesor")
public class Profesor {
	private int PrecioHs;
	private int Horas;
	public int getPrecioHs() {
		return PrecioHs;
	}
	public void setPrecioHs(int precioHs) {
		PrecioHs = precioHs;
	}
	public int getHoras() {
		return Horas;
	}
	public void setHoras(int horas) {
		Horas = horas;
	}
	

}
