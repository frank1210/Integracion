package TDAS;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;




import java.util.ArrayList;
import java.util.List;

import bean.Abono;
import bean.Empleado;
import bean.Factura;
import bean.ListEmpleados;
import bean.ListFacturas;
import bean.ListPersonas;
import bean.ListRecibos;
import bean.ListSocios;
import bean.ReciboDeSueldo;
import bean.Servicio;
import bean.Socio;
import bean.srv.AbonoSRV;
import bean.srv.FacturaSRV;
import bean.srv.PersonaSRV;
import bean.srv.ReciboSRV;

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
	
	public List<Factura> getFacturas() throws RemoteException{
		return facturas.getFacturas();
	}
	
	
	public Factura facturar(Socio socio, int i) throws RemoteException{
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
	for(Socio s: socios.getSocios()){
		try {
			facturas.addFactura(facturar(s, i));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	return false;	
	}
	
	public boolean crearAdministrativo(String nombre, String dni, String mail, String apellido, String domicilio, int nroemp, int sueldobase, int presentismo) throws RemoteException{
		return false;
	}
	public boolean crearSocio(String nombre, String dni, String mail, String apellido, String domicilio, List<Servicio> lista, Abono abono) throws RemoteException{
		return false;
	}
	public boolean crearFactura(int numero, Socio socio, double monto) throws RemoteException{
		return false;
	}
	public boolean crearAbono(int id, String nombre, float dto, int dias) throws RemoteException{
		return false;
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
}
