package bean;

import java.util.ArrayList;
import java.util.List;

public class ListServicios {

	private static final long serialVersionUID = 1L;
	private List<Servicio> servicios =new ArrayList<Servicio>();
	
	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicio(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public void addServicio(Servicio s){
		
		servicios.add(s);
	}
	
	public void removeServicio(Servicio s){
		servicios.remove(s);
	}
	
	public Servicio getServicioPorCodigo(int codigo){
		for(Servicio s : servicios){
			if(s.getId()==codigo) return s;
		}
		return null;
		
	}
}
