/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Ordenesrecepcion;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoOrdenesRecepcion implements IDAO<Ordenesrecepcion>
{
    private Session session;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException 
    { 
        session = HibernateUtil.getSessionFactory().openSession(); 
        tx = session.beginTransaction(); 
    }  

    private void manejaExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    }
    
    @Override
    public synchronized int Agregar(Ordenesrecepcion entidad) 
    {
        int id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer)session.save(entidad); 
            tx.commit(); 
        }
        catch(HibernateException ex) 
        { 
            System.out.println("Ha ocurrido una excepcion: " + ex.getMessage());
            
            manejaExcepcion(ex); 
        }
        finally 
        { 
            session.close(); 
        }  
        
        return id;
    }

    @Override
    public synchronized void Actualizar(Ordenesrecepcion entidad)
    {
        try 
        { 
            iniciaOperacion(); 
            session.update(entidad); 
            tx.commit(); 
        }
        catch (HibernateException ex) 
        { 
            System.out.println("Ha ocurrido una excepcion: " + ex.getMessage());
            manejaExcepcion(ex); 
        }
        finally 
        { 
            session.close(); 
        }
    }

    @Override
    public synchronized void Eliminar(Ordenesrecepcion entidad)
    {
        try 
        { 
            iniciaOperacion(); 
            session.delete(entidad); 
            tx.commit(); 
        }
        catch (HibernateException ex) 
        { 
            System.out.println("Ha ocurrido una excepcion: " + ex.getMessage());
            manejaExcepcion(ex); 
        }
        finally 
        { 
            session.close(); 
        }
    }

    @Override
    public Ordenesrecepcion Get(String atributo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ordenesrecepcion Get(int Atributo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String dateToMySQLDate(Date fecha)
    {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        return sdf.format(fecha);
    }
    
    public synchronized Ordenesrecepcion GetByDate(Date busqueda)
    {
        Ordenesrecepcion orden=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Ordenesrecepcion o WHERE o.fecha=" + dateToMySQLDate(busqueda));

            orden=(Ordenesrecepcion)query.uniqueResult();
        }
        catch(HibernateException ex)
        {
            System.out.println("Ha ocurrido una excepcion: " + ex.getMessage());
            
            manejaExcepcion(ex);
            
        }
        finally 
        { 
            session.close(); 
        }  

        return orden;
    }
    
     public synchronized ArrayList ListarByCliente(int idcliente) 
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Ordenesrecepcion o WHERE o.cliente_id=:id");
            
            query.setParameter("id",idcliente);

            Lista=(ArrayList)query.list();
        }
        catch(HibernateException ex)
        {
            System.out.println("Ha ocurrido una excepcion: " + ex.getMessage());
            
            manejaExcepcion(ex);
            
        }
        finally 
        { 
            session.close(); 
        }  

        return Lista;
    }
    
    @Override
    public synchronized ArrayList Listar() 
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Ordenesrecepcion o");

            Lista=(ArrayList)query.list();
        }
        catch(HibernateException ex)
        {
            System.out.println("Ha ocurrido una excepcion: " + ex.getMessage());
            
            manejaExcepcion(ex);
            
        }
        finally 
        { 
            session.close(); 
        }  

        return Lista;
    }
    
  
    
}
