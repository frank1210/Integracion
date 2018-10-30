package bean.srv;

import bean.Factura;
import bean.ListFacturas;
import bean.ListRecibos;
import bean.ReciboDeSueldo;
import bean.dao.HibernateFacturaDAO;
import bean.dao.HibernateReciboDAO;

public class ReciboSRV {

	private static HibernateReciboDAO dao;
	static {
		dao = HibernateReciboDAO.getInstancia();
	}
	
	public void grabarRecibos(ListRecibos Facturas){
		dao.grabarRecibos(Facturas);
	}
	
	public void borrarRecibo(ReciboDeSueldo f){
		dao.borrarRecibo(f);
	}
	
	public ReciboDeSueldo seleccionarRecibo(int c){
		return dao.seleccionarRecibo(c);
	}
	
	public void modificarRecibo(ReciboDeSueldo f){
		dao.modificarRecibo(f);
		
	}
}
