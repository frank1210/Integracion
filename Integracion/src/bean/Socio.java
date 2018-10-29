package bean;

import java.io.Serializable;
import java.util.ArrayList;

import bean.Servicio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Socio")
@Inheritance(strategy = InheritanceType.JOINED)
public class Socio extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	//@OneToMany (cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private ArrayList<Servicio> servicios = new ArrayList();

	@ManyToOne
	private Abono abonos;
	
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public Abono getId_abono() {
		return abonos;
	}
	public void setId_abono(int id_abono) {
		this.abonos = abonos;
	}

	
}
