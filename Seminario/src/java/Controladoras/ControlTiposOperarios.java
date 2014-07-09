/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoTiposOperarios;
import Modelo.Tiposoperario;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlTiposOperarios 
{
    public ControlTiposOperarios()
    {
        try
        {
            d_tipooperarios=new DaoTiposOperarios();
        }
        catch(Exception ex)
        {}
    }

    DaoTiposOperarios d_tipooperarios;

    private Tiposoperario agregar=new Tiposoperario();
    
    private Tiposoperario editar=new Tiposoperario();

    public void VaciarCampos() 
    {
        agregar.setTipo("");
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarTipoOperario() 
    {
        String Salida = "abmtipooperarios";

        try 
        {
            if (d_tipooperarios.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Tipo de Operario agregado correctamente");

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
    
    public String EliminarTipoOperario(Tiposoperario t)
    {   
        String Salida="abmtipooperarios";
        
        try
        {
            d_tipooperarios.Eliminar(t);
            
            addMessage("Tipo de Operario eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarTipoOperario(Tiposoperario t)
    {
        String Salida="editartipooperarios";
        
        editar=t;

        return Salida;
    }
    
    public String ActualizarTipoOperario()
    {
        String Salida="abmtipooperarios";

        try
        {
            if (editar.getIdtipooperario() != null || editar.getIdtipooperario() != 0)
            {

                d_tipooperarios.Actualizar(editar);

                addMessage("Tipo de Operario editado correctamente");

            } 
            else 
            {
                addMessage("Seleccione tipo de operario");
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
            editar=new Tiposoperario();
        }
    }
    
    public ArrayList ListarTiposOperarios()
    {
        try
        {
            return d_tipooperarios.Listar();
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
    public Tiposoperario getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Tiposoperario agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Tiposoperario getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Tiposoperario editar) {
        this.editar = editar;
    }
}
