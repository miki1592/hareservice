/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Terceros;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoProveedores implements IDAO<Terceros>
{private Session session;
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
    public synchronized int Agregar(Terceros entidad) 
    {
        int id = 0;

        try 
        {
            iniciaOperacion();
            id = (Integer) session.save(entidad);
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
    public synchronized void Actualizar(Terceros entidad) 
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
    public synchronized void Eliminar(Terceros entidad) 
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
    public synchronized Terceros Get(String atributo) 
    {
        Terceros cliente=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Terceros p WHERE p.email=:mail AND p.esproveedor=1");

            query.setString("mail",atributo);

            cliente=(Terceros)query.uniqueResult();
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

        return cliente;
    }
    
    public synchronized Terceros GetByRazon(String raz)
    {
        Terceros cliente=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Terceros p WHERE p.razonsocial=:rs AND p.esproveedor=1");

            query.setString("rs",raz);

            cliente=(Terceros)query.uniqueResult();
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

        return cliente;
    }
    
    public synchronized Terceros GetByCUIT(int cuit)
    {
        Terceros cliente=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Terceros p WHERE p.cuit=:cu AND p.esproveedor=1");

            query.setInteger("cu",cuit);

            cliente=(Terceros)query.uniqueResult();
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

        return cliente;
    }
    
    @Override
    public synchronized Terceros Get(int Atributo)
    {
        Terceros cliente=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Terceros p WHERE p.idtercero=:id");

            query.setParameter("id",Atributo);

            cliente=(Terceros)query.uniqueResult();
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

        return cliente;
    }

    @Override
    public synchronized ArrayList Listar() 
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Terceros p WHERE p.esproveedor=1");

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
