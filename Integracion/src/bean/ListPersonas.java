package bean;

import java.util.ArrayList;
import java.util.List;

public class ListPersonas {
	private List<Persona> Personas =new ArrayList<Persona>();
	
	public List<Persona> getProductos() {
		return Personas;
	}

	public void setPersonas(List<Persona> productos) {
		this.Personas = productos;
	}
	
	public void addPersona(Persona p){
		
		Personas.add(p);
	}
	
	public void removePersona(Persona p){
		Personas.remove(p);
	}
	
	public Persona getPersonaPorDni(String dni){
		for(Persona p : Personas){
			if(p.getDni()==dni) return p;
		}
		return null;
		
	}
}
