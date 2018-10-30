package hbt;

import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import bean.Abono;
import bean.Administrativo;
import bean.Empleado;
import bean.Factura;
import bean.Persona;
import bean.Profesor;
import bean.ReciboDeSueldo;
import bean.Servicio;
import bean.Socio;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	Configuration config =new Configuration();
        	config.addAnnotatedClass(Abono.class);
        	config.addAnnotatedClass(Factura.class);
        	config.addAnnotatedClass(ReciboDeSueldo.class);
        	config.addAnnotatedClass(Servicio.class);
        	config.addAnnotatedClass(Persona.class);
        	config.addAnnotatedClass(Socio.class);
        	config.addAnnotatedClass(Profesor.class);
        	config.addAnnotatedClass(Administrativo.class);
        	config.addAnnotatedClass(Empleado.class);
        	//config.addAnnotatedClass(Servicio.class);
        	
        	
        	sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
