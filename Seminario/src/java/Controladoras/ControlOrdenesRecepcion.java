/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoClientes;
import Daos.DaoOrdenesRecepcion;
import Modelo.Ordenesrecepcion;
import Modelo.Terceros;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class ControlOrdenesRecepcion 
{
    public ControlOrdenesRecepcion()
    {
        try
        {
            d_ordenes_recep=new DaoOrdenesRecepcion();
            d_clientes=new DaoClientes();
            ListaClientes=ListarClientes();
        }
        catch(Exception ex)
        {}
    }

    DaoOrdenesRecepcion d_ordenes_recep;
    DaoClientes d_clientes;
    
    private Ordenesrecepcion agregar=new Ordenesrecepcion();
    
    private Ordenesrecepcion editar=new Ordenesrecepcion();
    
    private Ordenesrecepcion detallada=new Ordenesrecepcion();

    private Terceros[] ListaClientes;
    
    public void VaciarCampos() 
    {
        agregar.setDetalle("");
        agregar.setFecha(null);
        agregar.setTerceros(new Terceros());
        agregar.setAdjunto("");
        agregar.setDescripcion("");
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public int BuscarUltimoNumOrden()
    {
        try
        {
            ArrayList lista=d_ordenes_recep.Listar();
            
            int num=100;
            
            if(lista.size()==0)
            {
                return num;
            }
            else 
            {
                for (int i = 0; i < lista.size(); i++) 
                {
                    num = ((Ordenesrecepcion)lista.get(i)).getNumero();
                }
                
                return num+1;
            }        
            
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return 100;
        }
    }
    public String AgregarOrdenRecepcion() 
    {
        String Salida = "abmordenesrecep";

        try
        {
            agregar.setNumero(BuscarUltimoNumOrden());
            
            if (d_ordenes_recep.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Orden de Recepcion agregada correctamente");

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
    
    public String EliminarOrdenRecepcion(Ordenesrecepcion o)
    {   
        String Salida="abmordenesrecep";
        
        try
        {
            d_ordenes_recep.Eliminar(o);
            
            addMessage("Orden de Recepcion eliminada correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarOrdenRecepcion(Ordenesrecepcion o)
    {
        String Salida="editarordenesrecep";
        
        editar=o;

        return Salida;
    }
    
    public String ActualizarOrdenRecepcion()
    {
        String Salida="abmordenesrecep";
        
        try 
        {
            if (editar.getIdordenrecep() != null || editar.getIdordenrecep() != 0) 
            {
                d_ordenes_recep.Actualizar(getEditar());

                addMessage("Orden de Recepcion editada correctamente");
            } 
            else 
            {
                addMessage("Seleccione orden de recepcion");
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
            editar=new Ordenesrecepcion();
        }
    }
    
    public ArrayList ListarOrdenesRecepcion()
    {
        try
        {
            return d_ordenes_recep.Listar();
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
     public ArrayList Listarordenxcliente(int idcliente)
    {
        try
        {
            return d_ordenes_recep.ListarByCliente(idcliente);
        }
        catch (Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora" + ex.getMessage());
        }
        return null;
    }  
    
    public Terceros[] ListarClientes()
    {
        try
        {
            ArrayList ListaC=d_clientes.Listar();
            
            ListaClientes=new Terceros[ListaC.size()];
            
            for( int i = 0 ; i < ListaC.size() ; i++ )
            {
                ListaClientes[i]=(Terceros)ListaC.get(i);
            }

            return ListaClientes;
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public String VerDetalles(Ordenesrecepcion o)
    {
        String Salida="detalleordenesrecep";
        
        detallada=o;
        
        return Salida;
    }
    
    /**
     * @return the agregar
     */
    public Ordenesrecepcion getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Ordenesrecepcion agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Ordenesrecepcion getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Ordenesrecepcion editar) {
        this.editar = editar;
    }

    /**
     * @return the ListaClientes
     */
    public Terceros[] getListaClientes() {
        return ListaClientes;
    }

    /**
     * @param ListaClientes the ListaClientes to set
     */
    public void setListaClientes(Terceros[] ListaClientes) {
        this.ListaClientes = ListaClientes;
    }

    /**
     * @return the detalle
     */
    public Ordenesrecepcion getDetallada() {
        return detallada;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetallada(Ordenesrecepcion detallada) {
        this.detallada = detallada;
    }
}
