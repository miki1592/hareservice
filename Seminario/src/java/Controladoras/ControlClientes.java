/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoClientes;
import Modelo.EmailSenderService;
import Modelo.Terceros;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlClientes 
{
    public ControlClientes()
    {
        try
        {
            d_clientes=new DaoClientes();
        }
        catch(Exception ex)
        {}
    }

    DaoClientes d_clientes;

    private Terceros agregar=new Terceros();
    
    private Terceros editar=new Terceros();
    private EmailSenderService sendmail= new EmailSenderService();

    public void VaciarCampos() 
    {
        agregar.setNombre("");
        agregar.setApellido("");
        agregar.setCuit("");
        agregar.setDni(null);
        agregar.setEmail("");
        agregar.setTelefono("");
        agregar.setTelefonomovil("");
        agregar.setCalle("");
        agregar.setAltura(null);
        agregar.setDpto("");
        agregar.setEscliente(true);
        agregar.setEsproveedor(false);
        agregar.setUsuario("");
        agregar.setContraseña("");
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarCliente() 
    {
        String Salida = "agregarclientes";

        try 
        {
            agregar.setEscliente(true);
            agregar.setEsproveedor(false);
            
            if (d_clientes.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Cliente agregado correctamente");
            sendmail.sendEmail(agregar.getEmail(),agregar.getUsuario(),agregar.getContraseña());

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
    
    public String EliminarCliente(Terceros c)
    {   
        String Salida="abmclientes";
        
        try
        {
            d_clientes.Eliminar(c);
            
            addMessage("Cliente eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarCliente(Terceros c)
    {
        String Salida="editarclientes";
        
        editar=c;

        return Salida;
    }
    
    public String ActualizarCliente()
    {
        String Salida="abmclientes";

        try
        {
            if (editar.getIdtercero() != null || editar.getIdtercero() != 0)
            {

                d_clientes.Actualizar(editar);

                addMessage("Cliente editado correctamente");

            } 
            else 
            {
                addMessage("Seleccione cliente");
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
    
    public ArrayList ListarClientes()
    {
        try
        {
            return d_clientes.Listar();
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