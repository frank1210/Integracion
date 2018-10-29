package bean.srv;

import java.util.List;

import bean.Abono;
import bean.dao.HibernateAbonoDAO;
import bean.dao.HibernatePersonaDAO;

public class AbonoSRV {
	private static HibernateAbonoDAO dao;
	static {
		dao = HibernateAbonoDAO.getInstancia();
	}
	
	public void grabarAbonos(List<Abono> Abonos){
		dao.grabarAbonos(Abonos);
	}
	
	public void borrarPersona(Abono p){
		dao.borrarAbono(p);
	}
	
	public Abono seleccionarPersona(int c){
		return dao.seleccionarAbono(c);
	}
	
	public void modificarAbono(Abono p){
		dao.modificarAbono(p);
		
	}
}
