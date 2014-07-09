/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoTiposRespuestos;
import Modelo.Tiposrepuesto;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlTiposRepuestos
{
    public ControlTiposRepuestos()
    {
        try
        {
            d_tiporepuestos=new DaoTiposRespuestos();
        }
        catch(Exception ex)
        {}
    }

    DaoTiposRespuestos d_tiporepuestos;

    private Tiposrepuesto agregar=new Tiposrepuesto();
    
    private Tiposrepuesto editar=new Tiposrepuesto();

    public void VaciarCampos() 
    {
        agregar.setTipo("");
        agregar.setStock(0);
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarTipoRepuesto() 
    {
        String Salida = "agregartiporepuestos";

        try 
        {
            if (d_tiporepuestos.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Tipo de Repuesto agregado correctamente");

            return Salida;
        }
        catch (Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        } 
        finally 
        {
            VaciarCampos();
        }
    }
    
    public String EliminarTipoRepuesto(Tiposrepuesto t)
    {   
        String Salida="abmtiporepuestos";
        
        try
        {
            d_tiporepuestos.Eliminar(t);
            
            addMessage("Tipo de Repuesto eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarTipoRepuesto(Tiposrepuesto t)
    {
        String Salida="editartiporepuestos";
        
        editar=t;

        return Salida;
    }
    
    public String ActualizarTipoRepuesto()
    {
        String Salida="abmtiporepuestos";

        try
        {
            if (editar.getIdtiporepuesto() != null || editar.getIdtiporepuesto() != 0)
            {

                d_tiporepuestos.Actualizar(editar);

                addMessage("Tipo de Repuesto editado correctamente");

            } 
            else 
            {
                addMessage("Seleccione tipo de repuesto");
            }

            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
        finally
        {
            editar=new Tiposrepuesto();
        }
    }
    
    public ArrayList ListarTiposRepuestos()
    {
        try
        {
            return d_tiporepuestos.Listar();
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }   

    /**
     * @return the agregar
     */
    public Tiposrepuesto getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Tiposrepuesto agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Tiposrepuesto getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Tiposrepuesto editar) {
        this.editar = editar;
    }
    
}
