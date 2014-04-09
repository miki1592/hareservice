/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoOperarios;
import Modelo.Operarios;
import java.util.ArrayList;

/**
 *
 * @author romero
 */
public class ControlOperarios
{
    public ControlOperarios()
    {
        try
        {
            d_operarios=new DaoOperarios();
        }
        catch(Exception ex)
        {}
    }
    
    DaoOperarios d_operarios;
    
    private Operarios oper_logeado=null; 
    
    private Operarios oper=new Operarios();
    
    private boolean logeado=false;
    
    public String Loguear()
    {
        String salida = "sinlogueo";
        
        try 
        {
            oper_logeado=d_operarios.Loguear(oper.getUsuario(),oper.getPass());
 
            if (oper_logeado != null) 
            {
                if(oper_logeado.getTiposoperario().getIdtipooperario()== 2)
                {
                    salida = "logueadoadmin";
                }
                else
                {
                    salida="logueonormal";
                }
                
                logeado=true;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return salida;
    } 
    
    public String Logout()
    {
        String salida="index";
        
        oper_logeado=null;
        
        logeado=false;
        
        return salida;
    }
    
    public ArrayList ListarOperarios()
    {
        try
        {
            System.out.println("Entre a control get all");
            return d_operarios.GetAll();
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    /**
     * @return the oper_logeado
     */
    public Operarios getOper_logeado() {
        return oper_logeado;
    }

    /**
     * @param oper_logeado the oper_logeado to set
     */
    public void setOper_logeado(Operarios oper_logeado) {
        this.oper_logeado = oper_logeado;
    }

    /**
     * @return the oper
     */
    public Operarios getOper() {
        return oper;
    }

    /**
     * @param oper the oper to set
     */
    public void setOper(Operarios oper) {
        this.oper = oper;
    }

    /**
     * @return the logeado
     */
    public boolean isLogeado() {
        return logeado;
    }

    /**
     * @param logeado the logeado to set
     */
    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }
}
