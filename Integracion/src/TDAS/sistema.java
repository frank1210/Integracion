package TDAS;

import java.rmi.RemoteException;
import java.util.List;

import bean.Abono;
import bean.ListAbonos;
import bean.ListPersonas;
import bean.Persona;
import bean.Profesor;
import bean.srv.*;

public class sistema {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
/*
		ListAbonos abonos = new ListAbonos();
		
		Abono a = new Abono();
		a.setDescuento(10);
		a.setDias(10);
		a.setNombre("semanal");
		abonos.addAbono(a);
		grabarAbonos(abonos);
		*/
		
		ListPersonas personas = new ListPersonas();
		Profesor p1 = new Profesor();
		p1.setApellido("Lopez");
		p1.setNombre("asd");
		p1.setDni("37068765");
		p1.setDomicilio("MT1807");
		p1.setMail("asd@asd.c");
		p1.setSueldoBasico(2000);
		p1.setNroEmpleado(1);
		p1.setPrecioHs(100);
		p1.setHoras(10);
		personas.addPersona(p1);
		grabarPersonas(personas);
		
	}
	
	public static void grabarAbonos(ListAbonos list) throws RemoteException{
		new AbonoSRV().grabarAbonos(list);
	}
	public static void grabarPersonas(ListPersonas list) throws RemoteException{
		new PersonaSRV().grabarPersonas(list);
	}

}
