/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Estadosreparacion;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoEstadosReparaciones implements IDAO<Estadosreparacion>
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
    public synchronized int Agregar(Estadosreparacion entidad) 
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
    public synchronized void Actualizar(Estadosreparacion entidad) 
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
    public synchronized void Eliminar(Estadosreparacion entidad) 
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
    public synchronized Estadosreparacion Get(String atributo) 
    {
        Estadosreparacion estado=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Estadosreparacion estados WHERE estados.estado=:est");

            query.setParameter("est",atributo);

            estado=(Estadosreparacion)query.uniqueResult();
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

        return estado;
    }

    @Override
    public synchronized Estadosreparacion Get(int Atributo) 
    {
        Estadosreparacion estado=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Estadosreparaciom estados WHERE estados.idestado=:id");

            query.setParameter("id",Atributo);

            estado=(Estadosreparacion)query.uniqueResult();
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

        return estado;
    }

    @Override
    public synchronized ArrayList Listar() 
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Estadosreparacion estados");

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
