package bean;

import java.util.ArrayList;
import java.util.List;

public class ListFacturas {
	private List<Factura> Facturas =new ArrayList<Factura>();
	
	public List<Factura> getFacturas() {
		return Facturas;
	}

	public void setFacturas(List<Factura> Facturas) {
		this.Facturas = Facturas;
	}
	
	public void addFactura(Factura p){
		
		Facturas.add(p);
	}
	
	public void removeFactura(Factura p){
		Facturas.remove(p);
	}
	
	public Factura getPersonaPorDni(int codigo){
		for(Factura p : Facturas){
			if(p.getNumero()==codigo) return p;
		}
		return null;
		
	}
	
}
