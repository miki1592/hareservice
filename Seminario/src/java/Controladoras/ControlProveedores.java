/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoProveedores;
import Modelo.Terceros;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlProveedores 
{
    public ControlProveedores()
    {
        try
        {
            d_proveedores=new DaoProveedores();
        }
        catch(Exception ex)
        {}
    }

    DaoProveedores d_proveedores;

    private Terceros agregar=new Terceros();
    
    private Terceros editar=new Terceros();

    public void VaciarCampos() 
    {
        agregar.setRazonsocial("");
        agregar.setCuit("");
        agregar.setEmail("");
        agregar.setTelefono("");
        agregar.setTelefonomovil("");
        agregar.setCalle("");
        agregar.setAltura(null);
        agregar.setDpto("");
        agregar.setEscliente(false);
        agregar.setEsproveedor(true);
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarProveedor() 
    {
        String Salida = "agregarproveedores";

        try 
        {
            agregar.setEscliente(false);
            agregar.setEsproveedor(true);
            
            if (d_proveedores.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Proveedor agregado correctamente");

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
    
    public String EliminarProveedor(Terceros c)
    {   
        String Salida="abmproveedores";
        
        try
        {
            d_proveedores.Eliminar(c);
            
            addMessage("Proveedor eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarProveedor(Terceros p)
    {
        String Salida="editarproveedores";
        
        editar=p;

        return Salida;
    }
    
    public String ActualizarProveedor()
    {
        String Salida="abmproveedores";

        try
        {
            if (editar.getIdtercero() != null || editar.getIdtercero() != 0)
            {

                d_proveedores.Actualizar(editar);

                addMessage("Proveedor editado correctamente");

            } 
            else 
            {
                addMessage("Seleccione proveedor");
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
            editar=new Terceros();
        }
    }
    
    public ArrayList ListarProveedores()
    {
        try
        {
            return d_proveedores.Listar();
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
    public Terceros getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Terceros agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Terceros getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Terceros editar) {
        this.editar = editar;
    }
}
