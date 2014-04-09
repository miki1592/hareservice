/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Operarios;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoOperarios
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
    
    
    public Operarios Loguear(String username,String pass)
    {
        Operarios o=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Operarios o WHERE o.usuario=:nombreusuario AND o.pass=:password");

            query.setString("nombreusuario",username);

            query.setString("password",pass);

            o=(Operarios)query.uniqueResult();
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

        return o;
    }
    
    public ArrayList GetAll()
    {
        System.out.println("Entre a dao get all");
        ArrayList Lista=new ArrayList();    
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Operarios o");

            Lista=(ArrayList)query.list();
            
            System.out.println("hizo query.list");
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
