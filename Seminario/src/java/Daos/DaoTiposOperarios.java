/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Modelo.Tiposoperario;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoTiposOperarios implements IDAO<Tiposoperario>
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
    public synchronized int Agregar(Tiposoperario entidad) 
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
    public synchronized void Actualizar(Tiposoperario entidad) 
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
    public synchronized void Eliminar(Tiposoperario entidad)
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
    public synchronized Tiposoperario Get(String atributo) 
    {
        Tiposoperario tipo=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Tiposoperario tipos WHERE tipos.tipo=:tip");

            query.setParameter("tip",atributo);

            tipo=(Tiposoperario)query.uniqueResult();
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

        return tipo;
    }

    @Override
    public synchronized Tiposoperario Get(int Atributo) 
    {
        Tiposoperario tipo=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Tiposoperario tipos WHERE tipos.idtipooperario=:id");

            query.setParameter("id",Atributo);

            tipo=(Tiposoperario)query.uniqueResult();
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

        return tipo;
    }

    @Override
    public synchronized ArrayList Listar() 
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Tiposoperario tipo");

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
