package bean;

import java.util.ArrayList;
import java.util.List;

public class ListSocios {
	private List<Socio> Personas =new ArrayList<Socio>();
	
	public List<Socio> getSocios() {
		return Personas;
	}

	public void setPersonas(List<Socio> productos) {
		this.Personas = productos;
	}
	
	public void addSocio(Socio p){
		
		Personas.add(p);
	}
	
	public void removeSocio(Socio p){
		Personas.remove(p);
	}
	
	public Socio getPersonaPorDni(String dni){
		for(Socio p : Personas){
			if(p.getDni()==dni) return p;
		}
		return null;
	}
}
