package bean.srv;

import java.util.List;

import bean.Persona;
import bean.dao.HibernatePersonaDAO;

public class PersonaSRV {
	private static HibernatePersonaDAO dao;
	static {
		dao = HibernatePersonaDAO.getInstancia();
	}
	
	public void grabarProductos(List<Persona> productos){
		dao.grabarProductos(productos);
	}
	
	public void borrarProducto(Persona p){
		dao.borrarPersona(p);
	}
	
	public Persona seleccionarProducto(String c){
		return dao.seleccionarPersona(c);
	}
	
	public void modificarProducto(Persona p){
		dao.modificarPersonas(p);
		
	}

}
