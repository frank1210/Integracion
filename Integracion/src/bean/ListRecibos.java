package bean;

import java.util.ArrayList;
import java.util.List;

public class ListRecibos {
private List<ReciboDeSueldo> Recibos =new ArrayList<ReciboDeSueldo>();
	
	public List<ReciboDeSueldo> getRecibos() {
		return Recibos;
	}

	public void setRecibo(List<ReciboDeSueldo> Facturas) {
		this.Recibos = Facturas;
	}
	
	public void addRecibo(ReciboDeSueldo p){
		
		Recibos.add(p);
	}
	
	public void removeRecibo(ReciboDeSueldo p){
		Recibos.remove(p);
	}
	
	public ReciboDeSueldo getReciboPorCodigo(int codigo){
		for(ReciboDeSueldo p : Recibos){
			if(p.getNumero()==codigo) return p;
		}
		return null;
		
	}
}
