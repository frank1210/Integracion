package TDAS;

import java.rmi.RemoteException;
import java.util.List;

import bean.Abono;
import bean.ListAbonos;

import bean.srv.*;

public class sistema {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		ListAbonos abonos = new ListAbonos();
		
		Abono a = new Abono();
		a.setDescuento(10);
		a.setDias(10);
		a.setNombre("semanal");
		abonos.addAbono(a);
		grabarAbonos(abonos);
		
	}
	
	public static void grabarAbonos(ListAbonos list)throws RemoteException{
		new AbonoSRV().grabarAbonos(list);
	}

}
