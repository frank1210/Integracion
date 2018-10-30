package TDAS;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bean.Abono;
import bean.Administrativo;
import bean.Factura;
import bean.ListAbonos;
import bean.ListFacturas;
import bean.ListPersonas;
import bean.ListServicios;
import bean.Persona;
import bean.Profesor;
import bean.Servicio;
import bean.Socio;
import bean.srv.*;

public class sistema2 {

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
		List<Servicio> servicios = new ArrayList<Servicio>();
		ListFacturas facturas= new ListFacturas();
		/*Profesor p1 = new Profesor();*/
		Servicio s1 = new Servicio();
		s1.setDescripcion("asd");
		s1.setId(1);
		s1.setNombre("asdasd");
		servicios.add(s1);
		Abono a1= new Abono();
		a1.setDescuento(45);
		a1.setDias(14);
		a1.setId(1);
		a1.setNombre("ABONO1");
		Factura f1 = new Factura();
		f1.setMonto(100.5);
		f1.setNumero(1);
		
		
		Socio p1= new Socio();
		p1.setApellido("Lopez");
		p1.setNombre("asd");
		p1.setDni("37068765");
		p1.setDomicilio("MT1807");
		p1.setMail("asd@asd.c");
		p1.setAbono(a1);
		p1.setServicios(servicios);
		f1.setSocio(p1);
		facturas.addFactura(f1);
		Profesor p2= new Profesor();
		p2.setApellido("DV");
		p2.setDni("11111111");
		p2.setDomicilio("calle falsa 1");
		p2.setHoras(12);
		p2.setMail("asd");
		p2.setNombre("Julio");
		p2.setNroEmpleado(1);
		p2.setPrecioHs(100);
		p2.setSueldoBasico(1000);
		Administrativo p3= new Administrativo();
		p3.setApellido("qwe");
		p3.setDni("456789");
		p3.setDomicilio("asdasdasdasd");
		p3.setMail("asdasdsad");
		p3.setNombre("forro");
		p3.setNroEmpleado(2);
		p3.setPresentismo(10);
		p3.setSueldoBasico(3000);
		
		//p1.setSueldoBasico(2000);
		//p1.setNroEmpleado(1);
		//p1.setPrecioHs(100);
		//p1.setHoras(10);
		
		personas.addPersona(p1);
		personas.addPersona(p2);
		personas.addPersona(p3);
		grabarAbonos(a1);
		grabarPersonas(personas);
		grabarFacturas(facturas);
		//grabarAbonos(a1);
		/*ListAbonos abonos = new ListAbonos();
		Abono a = new Abono();
		a.setDias(7);
		a.setNombre("semanal");
		a.setId(1);
		a.setDescuento(10);
		abonos.addAbono(a);
		
		grabarAbonos(abonos);*/
		
	
	}
	
	public static void grabarAbonos(Abono list) throws RemoteException{
		new AbonoSRV().grabarAbonos(list);
	}
	public static void grabarPersonas(ListPersonas list) throws RemoteException{
		new PersonaSRV().grabarPersonas(list);
	}
	public static void grabarFacturas(ListFacturas list) throws RemoteException{
		new FacturaSRV().grabarFacturas(list);
		
	}
	
	
}
