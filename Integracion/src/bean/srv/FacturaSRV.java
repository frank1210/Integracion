package bean.srv;

import java.util.List;

import bean.Factura;
import bean.ListFacturas;
import bean.dao.HibernateFacturaDAO;

public class FacturaSRV {
	
	private static HibernateFacturaDAO dao;
	static {
		dao = HibernateFacturaDAO.getInstancia();
	}
	
	public void grabarFacturas(ListFacturas Facturas){
		dao.grabarFacturas(Facturas);
	}
	
	public void borrarFactura(Factura f){
		dao.borrarFactura(f);
	}
	
	public Factura seleccionarFactura(String c){
		return dao.seleccionarFactura(c);
	}
	
	public void modificarFactura(Factura f){
		dao.modificarFactura(f);
		
	}


}
