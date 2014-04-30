/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Operarios;
import java.math.BigInteger;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author romero
 */
public class DaoOperarios implements IDAO<Operarios>
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
    public int Agregar(Operarios entidad) 
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
    public void Actualizar(Operarios entidad) 
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
    public void Eliminar(Operarios entidad) 
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
    public Operarios Get(String atributo) 
    {
        Operarios o=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Operarios o WHERE o.nombre=:nombreoper");

            query.setString("nombreoper",atributo);

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

    @Override
    public Operarios Get(int Atributo)
    {
        Operarios o=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Operarios o WHERE o.idoperario=:id");

            query.setParameter("id",Atributo);

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

    @Override
    public ArrayList Listar()
    {
        ArrayList Lista=new ArrayList();  
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Operarios o");

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
    
}
