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
    public int Agregar(Tiposoperario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(Tiposoperario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Tiposoperario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tiposoperario Get(String atributo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tiposoperario Get(int Atributo) 
    {
        Tiposoperario tipo=null;
        
        try 
        { 
            iniciaOperacion(); 

            Query query=session.createQuery("FROM Tiposoperario tipo WHERE tipo.idtipooperario=:id");

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
    public ArrayList Listar() 
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
