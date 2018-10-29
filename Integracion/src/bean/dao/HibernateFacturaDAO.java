package bean.dao;

import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Factura;
import bean.ListFacturas;
import bean.Persona;

public class HibernateFacturaDAO {
	
	private static HibernateFacturaDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateFacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateFacturaDAO();
		} 
		return instancia;
	}
	
	public void grabarFacturas(ListFacturas facturas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Factura f:facturas.getFacturas())
			session.merge(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Factura seleccionarFactura(String codigo){
		Factura f = new Factura();
		
		Session session = sf.openSession();
		session.beginTransaction();
		f=session.get(Factura.class, codigo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return f;
	}
	
	public void borrarFactura(Factura f){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarFactura(Factura f){
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
