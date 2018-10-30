package bean;

import java.util.ArrayList;
import java.util.List;

public class ListEmpleados {
	private List<Empleado> Personas =new ArrayList<Empleado>();
	
	public List<Empleado> getEmpleados() {
		return Personas;
	}

	public void setEmpleado(List<Empleado> productos) {
		this.Personas = productos;
	}
	
	public void addEmpelado(Empleado p){
		
		Personas.add(p);
	}
	
	public void removeEmpleado(Empleado p){
		Personas.remove(p);
	}
	
	public Persona getEmpleadoPorDni(String dni){
		for(Empleado p : Personas){
			if(p.getDni()==dni) return p;
		}
		return null;
		
	}
}
