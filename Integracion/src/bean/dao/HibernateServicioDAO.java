package bean.dao;

import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.*;

import bean.Servicio;

public class HibernateServicioDAO {
	
	private static HibernateServicioDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateServicioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateServicioDAO();
		} 
		return instancia;
	}

	public void grabarServicios(List<Servicio> servicios){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Servicio s:servicios)
			session.merge(s);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Servicio seleccionarServicio(int codigo){
		Servicio s = new Servicio();
		
		Session session = sf.openSession();
		session.beginTransaction();
		s=session.get(Servicio.class, codigo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return s;
	}
	
	public void borrarServicio(Servicio s){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(s);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarServicio(Servicio s){
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(s);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
