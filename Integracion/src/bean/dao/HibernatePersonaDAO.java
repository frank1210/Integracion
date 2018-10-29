package bean.dao;

import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Persona;


public class HibernatePersonaDAO {
	
	private static HibernatePersonaDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernatePersonaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernatePersonaDAO();
		} 
		return instancia;
	}
	
	public void grabarProductos(List<Persona> Personas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Persona p:Personas)
			session.merge(p);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Persona seleccionarPersona(String codigo){
		Persona p = new Persona();
		
		Session session = sf.openSession();
		session.beginTransaction();
		p=session.get(Persona.class, codigo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return p;
	}
	
	public void borrarPersona(Persona p){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(p);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarPersonaos(Persona p){
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(p);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	
	
}
