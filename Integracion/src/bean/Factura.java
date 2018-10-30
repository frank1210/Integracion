package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="Facturas")
public class Factura {
	
	
	@Id
	private int numero;
	@ManyToOne
	//@PrimaryKeyJoinColumn
	@JoinColumn(name="Socio")
	private Socio socio;
	
	private double monto;
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double d) {
		this.monto = d;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	

}
