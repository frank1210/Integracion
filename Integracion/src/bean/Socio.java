package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.Servicio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Socio")
@Inheritance(strategy = InheritanceType.JOINED)
public class Socio extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	//@OneToMany (cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@ManyToMany (cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	//@JoinColumn(name="Codigo")
	private List<Servicio> servicios = new ArrayList<Servicio>();
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Abono abono;
	
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public Abono getAbono() {
		return abono;
	}
	public void setAbono(Abono abono) {
		this.abono = abono;
	}

	
}
