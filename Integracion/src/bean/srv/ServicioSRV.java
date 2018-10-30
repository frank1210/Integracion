package bean.srv;

import java.util.List;

import bean.ListServicios;
import bean.Servicio;
import bean.dao.HibernateServicioDAO;

public class ServicioSRV {
	private static HibernateServicioDAO dao;
	static {
		dao = HibernateServicioDAO.getInstancia();
	}
	
	public void grabarServicios(List<Servicio> servicios){
		dao.grabarServicios(servicios);
	}
	
	public void borrarServicio(Servicio s){
		dao.borrarServicio(s);
	}
	
	public Servicio seleccionarServicio(int c){
		return dao.seleccionarServicio(c);
	}
	
	public void modificarServicio(Servicio s){
		dao.modificarServicio(s);
		
	}

}
