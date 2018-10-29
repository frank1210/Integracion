package bean.dao;

import hbt.HibernateUtil;
import org.hibernate.*;

import org.hibernate.SessionFactory;

public class HibernateServicioDAO {
	
	private static HibernateServicioDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateServicioDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateProductoDAO();
		} 
		return instancia;
	}

}
