/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoTiposCalidades;
import Modelo.Tiposcalidad;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlTiposCalidades 
{
    public ControlTiposCalidades()
    {
        try
        {
            d_tipocalidades=new DaoTiposCalidades();
        }
        catch(Exception ex)
        {}
    }

    DaoTiposCalidades d_tipocalidades;

    private Tiposcalidad agregar=new Tiposcalidad();
    
    private Tiposcalidad editar=new Tiposcalidad();

    public void VaciarCampos() 
    {
        agregar.setTipo("");
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarTipoCalidad() 
    {
        String Salida = "abmtipocalidades";

        try 
        {
            if (d_tipocalidades.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Tipo de Calidad agregada correctamente");

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
    
    public String EliminarTipoCalidad(Tiposcalidad t)
    {   
        String Salida="abmtipocalidades";
        
        try
        {
            d_tipocalidades.Eliminar(t);
            
            addMessage("Tipo de Calidad eliminada correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarTipoCalidad(Tiposcalidad t)
    {
        String Salida="editartipocalidades";
        
        editar=t;

        return Salida;
    }
    
    public String ActualizarTipoCalidad()
    {
        String Salida="abmtipocalidades";

        try
        {
            if (editar.getIdtipocalidad() != null || editar.getIdtipocalidad() != 0)
            {

                d_tipocalidades.Actualizar(editar);

                addMessage("Tipo de Calidad editada correctamente");

            } 
            else 
            {
                addMessage("Seleccione tipo de calidad");
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
            editar=new Tiposcalidad();
        }
    }
    
    public ArrayList ListarTiposCalidades()
    {
        try
        {
            return d_tipocalidades.Listar();
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
    public Tiposcalidad getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Tiposcalidad agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Tiposcalidad getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Tiposcalidad editar) {
        this.editar = editar;
    }

}
