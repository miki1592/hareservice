/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoEstadosReparaciones;
import Modelo.Estadosreparacion;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlEstadosReparaciones 
{
    public ControlEstadosReparaciones()
    {
        try
        {
            d_estados=new DaoEstadosReparaciones();
        }
        catch(Exception ex)
        {}
    }

    DaoEstadosReparaciones d_estados;

    private Estadosreparacion agregar=new Estadosreparacion();
    
    private Estadosreparacion editar=new Estadosreparacion();

    public void VaciarCampos() 
    {
        agregar.setEstado("");
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarEstadoReparacion() 
    {
        String Salida = "abmestadosreparacion";

        try 
        {
            if (d_estados.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Estado de Reparacion agregado correctamente");

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
    
    public String EliminarEstadoReparacion(Estadosreparacion e)
    {   
        String Salida="abmestadosreparacion";
        
        try
        {
            d_estados.Eliminar(e);
            
            addMessage("Estado de Reparacion eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarEstadoReparacion(Estadosreparacion e)
    {
        String Salida="editarestadosreparacion";
        
        editar=e;

        return Salida;
    }
    
    public String ActualizarEstadoReparacion()
    {
        String Salida="abmestadosreparacion";

        try
        {
            if (editar.getIdestado() != null || editar.getIdestado() != 0)
            {

                d_estados.Actualizar(editar);

                addMessage("Estado de reparacion editado correctamente");

            } 
            else 
            {
                addMessage("Seleccione estado de reparacion");
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
            editar=new Estadosreparacion();
        }
    }
    
    public ArrayList ListarEstadosReparacion()
    {
        try
        {
            return d_estados.Listar();
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
    public Estadosreparacion getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Estadosreparacion agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Estadosreparacion getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Estadosreparacion editar) {
        this.editar = editar;
    }
}
