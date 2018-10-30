package bean.dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Abono;
import bean.Factura;
import bean.ListAbonos;

public class HibernateAbonoDAO {

	private static HibernateAbonoDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateAbonoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateAbonoDAO();
		} 
		return instancia;
	}
	
	public void grabarAbonos(Abono Abonos){
		Session session = sf.openSession();
		session.beginTransaction();
		//for(Abono f:Abonos)
			session.merge(Abonos);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Abono seleccionarAbono(int codigo){
		Abono f = new Abono();
		Session session = sf.openSession();
		session.beginTransaction();
		f=session.get(Abono.class, codigo);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return f;
	}
	
	public void borrarAbono(Abono f){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarAbono(Abono f){
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
