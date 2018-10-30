package bean.dao;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Factura;
import bean.ListFacturas;
import bean.ListRecibos;
import bean.ReciboDeSueldo;

public class HibernateReciboDAO {

	private static HibernateReciboDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateReciboDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateReciboDAO();
		} 
		return instancia;
	}
	
	public void grabarRecibos(ListRecibos facturas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(ReciboDeSueldo f:facturas.getRecibos())
			session.merge(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public ReciboDeSueldo seleccionarRecibo(int codigo){
		ReciboDeSueldo f = new ReciboDeSueldo();
		
		Session session = sf.openSession();
		session.beginTransaction();
		f=session.get(ReciboDeSueldo.class, codigo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return f;
	}
	
	public void borrarRecibo(ReciboDeSueldo f){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarRecibo(ReciboDeSueldo f){
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
