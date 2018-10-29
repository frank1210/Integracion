package bean.srv;

import java.util.List;

import bean.ListPersonas;
import bean.Persona;
import bean.dao.HibernatePersonaDAO;

public class PersonaSRV {
	private static HibernatePersonaDAO dao;
	static {
		dao = HibernatePersonaDAO.getInstancia();
	}
	
	public void grabarPersonas(ListPersonas Personas){
		dao.grabarPersonas(Personas);
	}
	
	public void borrarPersona(Persona p){
		dao.borrarPersona(p);
	}
	
	public Persona seleccionarPersona(String c){
		return dao.seleccionarPersona(c);
	}
	
	public void modificarPersona(Persona p){
		dao.modificarPersonas(p);
		
	}

}
