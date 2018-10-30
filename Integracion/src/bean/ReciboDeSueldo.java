package bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="RecibosSueldo")

public class ReciboDeSueldo {
	@Id
	private int numero;
	//@ManyToOne
	//@ManyToOne(cascade = CascadeType.ALL )
	//@PrimaryKeyJoinColumn
	//@JoinColumn(name="Empleado")
	@OneToOne
	@JoinColumn(name="EmpleadoID")
	private Empleado empleado;
	
	private double monto;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
}
