/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Modelo.Terceros;
/**
 *
 * @author romero
 */
public class DaoClientes implements IDAO<Terceros>
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
    public synchronized int Agregar(Terceros entidad) 
    {
       int id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Integer) session.save(entidad); 
            tx.commit(); 
        } 
        catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
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
        catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
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
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            session.close(); 
        } 
    }

    @Override
    public synchronized Terceros Get(String atributo) 
    {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public synchronized Terceros Get(int Atributo)
    {
        Terceros ocliente = null;  
        try 
        { 
            iniciaOperacion(); 
            ocliente = (Terceros) session.get(Terceros.class, Atributo); 
        } finally 
        { 
            session.close(); 
        }  

        return ocliente; 
    }

    @Override
    public synchronized ArrayList Listar() 
    {
        ArrayList listaClientes = null;  

        try 
        { 
            iniciaOperacion(); 
            listaClientes =(ArrayList) session.createQuery("from cliente").list(); 
        } finally 
        { 
            session.close(); 
        }  

        return listaClientes; 
    }
    
}
