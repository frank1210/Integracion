package bean.dao;

import hbt.HibernateUtil;

import org.hibernate.SessionFactory;

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

}
