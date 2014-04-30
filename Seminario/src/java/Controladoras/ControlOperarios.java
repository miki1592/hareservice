/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoOperarios;
import Daos.DaoTiposOperarios;
import Modelo.Operarios;
import Modelo.Tiposoperario;
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
            d_tipos_opers=new DaoTiposOperarios();
            Lista=ListarTiposOperarios();
        }
        catch(Exception ex)
        {}
    }
    
    private Tiposoperario[] Lista;
    
    DaoOperarios d_operarios;
    
    DaoTiposOperarios d_tipos_opers;
    
    private Operarios oper_logeado=null; 
    
    private Operarios oper=new Operarios();
    
    private Operarios agregar=new Operarios();
    
    private Operarios editar=new Operarios();
    
    private boolean logeado=false;
    
    private String mensaje="";
    
    private boolean HayMensaje=false;
    
    public void VaciarCampos() 
    {
        agregar.setNombre("");

        agregar.setUsuario("");

        agregar.setPass("");

        agregar.setEmail("");

        agregar.setTiposoperario(new Tiposoperario());
    }
    
    public String AgregarOperario()
    {
        String Salida="abmoperarios";
        
        try
        {
            if(d_operarios.Agregar(agregar)==0)
            {
                mensaje="Ha ocurrido un error, el operario no pudo ser agregado";
            }
            
            mensaje="Operario agregado correctamente";
            
            HayMensaje=true;
            
            return Salida;
        }
        catch(Exception ex)
        {
            return "ErrorOperarios";
        }
        finally
        {
            VaciarCampos();
        }
    }
    
    public String EliminarOperario(Operarios o)
    {   
        String Salida="abmoperarios";
        
        try
        {
            d_operarios.Eliminar(o);
            
            mensaje="Operario eliminado correctamente";
            
            HayMensaje=true;
            
            return Salida;
        }
        catch(Exception ex)
        {
            return "ErrorOperarios";
        }
    }
    
    public String ProcesarEditar(Operarios o)
    {
        String Salida="EditarOperarios";
        
        editar=o;
        
        return Salida;
    }
    
    public String ActualizarOperario()
    {
        String Salida="abmoperarios";
        
        try
        {
            d_operarios.Actualizar(editar);
            
            mensaje="Operario modificado correctamente";
            
            HayMensaje=true;
            
            return Salida;
        }
        catch(Exception ex)
        {
            return "ErrorOperarios";
        }
        finally
        {
            editar=null;
        }
    }
    
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
            return d_operarios.Listar();
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public String LeerMensaje()
    {
        String m=mensaje;
        
        mensaje="";
        
        HayMensaje=false;
        
        return m;
    }
    
    
    public Tiposoperario[] ListarTiposOperarios()
    {
        try
        {
            ArrayList ListaOpers=d_tipos_opers.Listar();
            
            Lista=new Tiposoperario[ListaOpers.size()];
            
            for( int i = 0 ; i < ListaOpers.size() ; i++ )
            {
                Lista[i]=(Tiposoperario)ListaOpers.get(i);
            }

            return Lista;
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

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the HayMensaje
     */
    public boolean isHayMensaje() {
        return HayMensaje;
    }

    /**
     * @param HayMensaje the HayMensaje to set
     */
    public void setHayMensaje(boolean HayMensaje) {
        this.HayMensaje = HayMensaje;
    }

    /**
     * @return the agregar
     */
    public Operarios getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Operarios agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Operarios getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Operarios editar) {
        this.editar = editar;
    }

    /**
     * @return the Lista
     */
    public Tiposoperario[] getLista() {
        return Lista;
    }

    /**
     * @param Lista the Lista to set
     */
    public void setLista(Tiposoperario[] Lista) {
        this.Lista = Lista;
    }

}
