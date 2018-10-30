package TDAS;

import java.rmi.RemoteException;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.ListRecibos;
import bean.Socio;
import bean.Abono;
import bean.Factura;
import bean.ListFacturas;
import bean.ListPersonas;
import bean.Persona;
import bean.Servicio;


public interface TDAgimnasio extends Remote{

	
	public boolean crearServicio(String nombre, double costo, String descripcion, int codigo) throws RemoteException;
	public boolean crearProfesor(String nombre, String dni, String mail, String apellido, String domicilio, int nroemp, int sueldobase, int preciohs, int horas) throws RemoteException;
	
	public boolean crearAdministrativo(String nombre, String dni, String mail, String apellido, String domicilio, int nroemp, int sueldobase, int presentismo) throws RemoteException;
	public boolean crearSocio(String nombre, String dni, String mail, String apellido, String domicilio, List<Servicio> lista, Abono abono) throws RemoteException;
	public boolean crearFactura(int numero, Socio socio, double monto) throws RemoteException;
	public boolean crearAbono(int id, String nombre, float dto, int dias) throws RemoteException;
	
	public void grabarAbonos(Abono list) throws RemoteException;
	public void grabarPersonas(ListPersonas list) throws RemoteException;
	public void grabarFacturas(ListFacturas list) throws RemoteException;
	public List<Factura> facturarSocios()throws RemoteException;
	public Factura facturar(Socio socio, int i) throws RemoteException;
	public List<Factura> getFacturas() throws RemoteException;
	public void grabarRecibos(ListRecibos list) throws RemoteException;
	public void grabarServicios(List<Servicio> list) throws RemoteException;
}
