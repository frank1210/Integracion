package bean;

import java.util.ArrayList;
import java.util.List;

public class ListAbonos {
	private static final long serialVersionUID = 1L;
	private List<Abono> abonos =new ArrayList<Abono>();
	
	public List<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(List<Abono> abonos) {
		this.abonos = abonos;
	}
	
	public void addAbono(Abono a){
		
		abonos.add(a);
	}
	
	public void removeProducto(Abono a){
		abonos.remove(a);
	}
	
	public Abono getAbonoPorCodigo(int codigo){
		for(Abono a : abonos){
			if(a.getId()==codigo) return a;
		}
		return null;
		
	}
}
