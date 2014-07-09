/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Modelo.Repuestos;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoRepuestos implements IDAO<Repuestos>
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
    public synchronized int Agregar(Repuestos entidad) 
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
    public synchronized void Actualizar(Repuestos entidad) 
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
    public synchronized void Eliminar(Repuestos entidad) 
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
    public synchronized Repuestos Get(String atributo) 
    {
        Repuestos r=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Repuestos r WHERE r.codigoprov=:cod");

            query.setString("cod",atributo);

            r=(Repuestos)query.uniqueResult();
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

        return r;
    }

    @Override
    public synchronized Repuestos Get(int Atributo)
    {
        Repuestos r=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Repuestos r WHERE r.idrepuesto=:id");

            query.setParameter("id",Atributo);

            r=(Repuestos)query.uniqueResult();
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

        return r;
    }

    @Override
    public synchronized ArrayList Listar()
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Repuestos r");

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

