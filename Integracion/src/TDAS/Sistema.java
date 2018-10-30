package TDAS;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;




import java.util.ArrayList;
import java.util.List;

import bean.Abono;
import bean.Administrativo;
import bean.Empleado;
import bean.Factura;
import bean.ListAbonos;
import bean.ListEmpleados;
import bean.ListFacturas;
import bean.ListPersonas;
import bean.ListRecibos;
import bean.ListServicios;
import bean.ListSocios;
import bean.Profesor;
import bean.ReciboDeSueldo;
import bean.Servicio;
import bean.Socio;
import bean.srv.AbonoSRV;
import bean.srv.FacturaSRV;
import bean.srv.PersonaSRV;
import bean.srv.ReciboSRV;
import bean.srv.ServicioSRV;

public class Sistema extends UnicastRemoteObject implements TDAgimnasio{
	public Sistema() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private ListSocios socios = new ListSocios();
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private ListFacturas facturas= new ListFacturas();
	private ListRecibos recibos= new ListRecibos();
	private ListEmpleados empleados= new ListEmpleados();
	private ListAbonos abonos = new ListAbonos();
	private ListPersonas personas = new ListPersonas();
	
	public List<Factura> getFacturas() throws RemoteException{
		return facturas.getFacturas();
	}
	
	
	public Factura facturar(Socio socio, int i) throws RemoteException{
		
		System.out.println("Factura");
		float monto=0;
		for(Servicio s: socio.getServicios())
			monto+= s.getCosto();
		monto= (monto* socio.getAbono().getDias()) - socio.getAbono().getDescuento();
		Factura factura= new Factura();
		factura.setSocio(socio);
		factura.setMonto(monto);
		factura.setNumero(i);
		
		return  factura;
	}
	public List<Factura> facturarSocios()throws RemoteException{
		//Factura fact = new Factura();
		int i=1;
		System.out.println("facturacion");
	for(Socio s: socios.getSocios()){
		try {
			facturas.addFactura(facturar(s, i));
			System.out.println("Factura agregada"+facturar(s,i).getMonto());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR");
		}
		i++;
	}
	try {
		grabarFacturas(facturas);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return facturas.getFacturas();
	}
	public boolean crearServicio(String nombre, double costo, String descripcion, int codigo) throws RemoteException{
		Servicio s1= new Servicio();
		s1.setDescripcion(descripcion);
		s1.setCosto(costo);
		s1.setNombre(nombre);
		s1.setId(codigo);
		servicios.add(s1);
		
		grabarServicios(servicios);
		return true;
	}
	public ReciboDeSueldo generarRecibo(Empleado empleado, int i){
		ReciboDeSueldo recibo=new ReciboDeSueldo();
		recibo.setEmpleado(empleado);
		recibo.setMonto(empleado.liquidarsueldo());
		recibo.setNumero(i);
		
		return recibo;
	}
	public List<ReciboDeSueldo> liquidarSueldos(){
		int i=1;
	for(Empleado s: empleados.getEmpleados()){
		recibos.addRecibo(generarRecibo(s, i));
		i++;
	}
	try {
		grabarRecibos(recibos);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return recibos.getRecibos();
	}
	
	public boolean crearProfesor(String nombre, String dni, String mail, String apellido, String domicilio, int nroemp, int sueldobase, int preciohs, int horas) throws RemoteException{
	Profesor profesor = new Profesor();
	profesor.setApellido(apellido);
	profesor.setDni(dni);
	profesor.setDomicilio(domicilio);
	profesor.setHoras(horas);
	profesor.setMail(mail);
	profesor.setNombre(nombre);
	profesor.setNroEmpleado(nroemp);
	profesor.setPrecioHs(preciohs);
	profesor.setSueldoBasico(sueldobase);
	empleados.addEmpelado(profesor);
	personas.addPersona(profesor);
	
	grabarPersonas(personas);
	
	return true;
	
	}
	
	public boolean crearAdministrativo(String nombre, String dni, String mail, String apellido, String domicilio, int nroemp, int sueldobase, int presentismo) throws RemoteException{
		Administrativo adm = new Administrativo();
		
		adm.setApellido(apellido);
		adm.setDni(dni);
		adm.setDomicilio(domicilio);
		adm.setMail(mail);
		adm.setNombre(nombre);
		adm.setNroEmpleado(nroemp);
		adm.setPresentismo(presentismo);
		adm.setSueldoBasico(sueldobase);
		personas.addPersona(adm);
		empleados.addEmpelado(adm);
		grabarPersonas(personas);
		
		return true;
		}
	public boolean crearSocio(String nombre, String dni, String mail, String apellido, String domicilio, List<Servicio> lista, Abono abono) throws RemoteException{
	
		Socio s = new Socio();
		s.setAbono(abono);
		s.setApellido(apellido);
		s.setDni(dni);
		s.setDomicilio(domicilio);
		s.setMail(mail);
		s.setNombre(nombre);
		s.setServicios(lista);
		personas.addPersona(s);
		socios.addSocio(s);
		
		grabarPersonas(personas);
		
		return true;
	}
	public boolean crearFactura(int numero, Socio socio, double monto) throws RemoteException{
		return false;
	}
	public boolean crearAbono(int id, String nombre, float dto, int dias) throws RemoteException{
		Abono a = new Abono();
		
		a.setDescuento(dto);
		a.setId(id);
		a.setNombre(nombre);
		a.setDias(dias);
		
		grabarAbonos(a);
		return true;
		
	}

	public void grabarAbonos(Abono list) throws RemoteException{
		new AbonoSRV().grabarAbonos(list);
	}
	public void grabarPersonas(ListPersonas list) throws RemoteException{
		new PersonaSRV().grabarPersonas(list);
	}
	public void grabarFacturas(ListFacturas list) throws RemoteException{
		new FacturaSRV().grabarFacturas(list);
		
	}
	public void grabarRecibos(ListRecibos list) throws RemoteException{
		new ReciboSRV().grabarRecibos(list);
	}
	
	public void grabarServicios(List<Servicio> list) throws RemoteException{
		new ServicioSRV().grabarServicios(list);
	}
	
	
	
	public static void main(String[] args) throws RemoteException {
		//TDAgimnasio sistema = null;
		Sistema sistema = new Sistema();
		 ListSocios socios = new ListSocios();
		 ListServicios servicios = new ListServicios();
		 ListServicios servicios2 = new ListServicios();
		 ListFacturas facturas= new ListFacturas();
		 ListRecibos recibos= new ListRecibos();
		 ListEmpleados empleados= new ListEmpleados();
		ListAbonos abonos = new ListAbonos();
		ListPersonas personas = new ListPersonas();
		
		
		
		Servicio s1 =new Servicio();
		s1.setCosto(100);
		s1.setDescripcion("algo");
		s1.setId(1);
		s1.setNombre("Pileta");
		
		sistema.crearServicio(s1.getNombre(), s1.getCosto(), s1.getDescripcion(), s1.getId());
		Servicio s2 =new Servicio();
		s2.setCosto(200);
		s2.setDescripcion("actividad");
		s2.setId(2);
		s2.setNombre("Profesor");
		sistema.crearServicio(s2.getNombre(), s2.getCosto(), s2.getDescripcion(), s2.getId());
		Servicio s3 =new Servicio();
		s3.setCosto(300.59);
		s3.setDescripcion("Fierros");
		s3.setId(3);
		s3.setNombre("Maquinas");
		sistema.crearServicio(s3.getNombre(), s3.getCosto(), s3.getDescripcion(), s3.getId());
		//(String nombre, double costo, String descripcion, int codigo)
		
		servicios.addServicio(s1);
		servicios.addServicio(s2);
		servicios.addServicio(s3);
		//sistema.grabarServicios(servicios.getServicios());
		
		
		Abono a1 = new Abono();
		a1.setDias(1);
		a1.setDescuento(0);
		a1.setId(1);
		a1.setNombre("Diario");
		sistema.crearAbono(1, "Diario", 0, 1);
		Abono a2 = new Abono();
		a2.setDias(7);
		a2.setDescuento(20);
		a2.setId(2);
		a2.setNombre("Semanal");
		sistema.crearAbono(2, "Semanal", 20, 7);

		Abono a3 = new Abono();
		a3.setDias(15);
		a3.setDescuento(50);
		a3.setId(3);
		a3.setNombre("Medio mes");
		sistema.crearAbono(3, "medio mes", 50, 15);

		Abono a4 = new Abono();
		a4.setDias(30);
		a4.setDescuento(100);
		a4.setId(4);
		a4.setNombre("Mensual");
		sistema.crearAbono(4, "Mensual", 75, 30);

		
		//abonos.addAbono(a1);
		//sistema.grabarAbonos(a1);
		//abonos.addAbono(a2);
		//sistema.grabarAbonos(a2);
		/*abonos.addAbono(a3);
		sistema.grabarAbonos(a3);
		abonos.addAbono(a4);
		sistema.grabarAbonos(a4);*/
		
		Administrativo adm1= new Administrativo();
		adm1.setApellido("Lopez");
		adm1.setDni("1234567");
		adm1.setDomicilio("Calle Falsa 123");
		adm1.setMail("mailfalso@gmial.com");
		adm1.setNombre("Franco");
		adm1.setNroEmpleado(1);
		adm1.setPresentismo(100);
		adm1.setSueldoBasico(12000);
		//personas.addPersona(adm1);
		
		sistema.crearAdministrativo(adm1.getNombre(), adm1.getDni(), adm1.getMail(), adm1.getApellido(), adm1.getDomicilio(), adm1.getNroEmpleado(), adm1.getSueldoBasico(), adm1.getPresentismo());
		
		Profesor p1 = new Profesor();
		p1.setApellido("Harendrof");
		p1.setDni("9876543");
		p1.setHoras(20);
		p1.setMail("Maia.h@gamil.com");
		p1.setNombre("Maia");
		p1.setNroEmpleado(2);
		p1.setPrecioHs(100);
		p1.setSueldoBasico(20000);
		p1.setDomicilio("Calle falsa 123123");
		//personas.addPersona(p1);
		sistema.crearProfesor(p1.getNombre(), p1.getDni(), p1.getMail(), p1.getApellido(), p1.getDomicilio(), p1.getNroEmpleado(), p1.getSueldoBasico(), p1.getPrecioHs(), p1.getHoras());
		
		Socio so1 = new Socio();
		so1.setAbono(a1);
		so1.setApellido("De Vincenzi");
		so1.setDni("93885241");
		so1.setDomicilio("calle falsa 234");
		so1.setMail("Matiasdv@gmail.com");
		so1.setNombre("Matias");
		so1.setServicios(servicios.getServicios());
		sistema.crearSocio(so1.getNombre(), so1.getDni(), so1.getMail(), so1.getApellido(), so1.getDomicilio(), so1.getServicios(), so1.getAbono());
		
		Socio so2 = new Socio();
		so2.setAbono(a4);
		so2.setApellido("Gomez");
		so2.setDni("3562729");
		so2.setDomicilio("Calle 2623");
		so2.setMail("mail@Gmail.com");
		so2.setNombre("Pepe");
		servicios2.addServicio(s1);
		so2.setServicios(servicios2.getServicios());
		sistema.crearSocio(so2.getNombre(), so2.getDni(), so2.getMail(), so2.getApellido(), so2.getDomicilio(), so2.getServicios(), so2.getAbono());

		
		
		
		
		/*socios.addSocio(so1);
		socios.addSocio(so2);
		personas.addPersona(so1);
		personas.addPersona(so2);
		
		sistema.grabarPersonas(personas);*/
		sistema.liquidarSueldos();
		sistema.facturarSocios();
	
		
		
		
		
	}
	
	
	
}
