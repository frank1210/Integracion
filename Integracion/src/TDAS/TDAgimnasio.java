package TDAS;

import java.rmi.RemoteException;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.Abono;
import bean.Factura;
import bean.Persona;
import bean.Servicio;


public interface TDAgimnasio extends Remote{

public List<Servicio> getServicios() throws RemoteException;
	
	public List<Persona> getPersonas() throws RemoteException;
	
	public List<Factura> getfacturas() throws RemoteException;
	
	public List<Abono> getAbonos() throws RemoteException;
	
	public boolean crearServicio(String nombre, float costo, String descripcion) throws RemoteException;
	
	public void crearNacional(int codigo, String rSocial,String cuit)throws RemoteException;
	
}
