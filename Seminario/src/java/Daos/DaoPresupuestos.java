/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Modelo.Presupuestos;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoPresupuestos implements IDAO<Presupuestos>
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
    public synchronized int Agregar(Presupuestos entidad) 
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
    public synchronized void Actualizar(Presupuestos entidad) 
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
    public synchronized void Eliminar(Presupuestos entidad) 
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
    public synchronized Presupuestos Get(String atributo) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Presupuestos Get(int Atributo)
    {
        Presupuestos pre=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Presupuestos p WHERE p.idpresupuesto=:id");

            query.setParameter("id",Atributo);

            pre=(Presupuestos)query.uniqueResult();
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

        return pre;
    }

    @Override
    public synchronized ArrayList Listar() 
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Presupuestos p");

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
