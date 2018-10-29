package bean;

import java.util.ArrayList;

public class Socio {
	
	private ArrayList<Servicio> servicios = new ArrayList();
	private int id_abono;
	
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	public int getId_abono() {
		return id_abono;
	}
	public void setId_abono(int id_abono) {
		this.id_abono = id_abono;
	}

	
}
