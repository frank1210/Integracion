package bean.dao;

import hbt.HibernateUtil;

import org.hibernate.SessionFactory;

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

}
