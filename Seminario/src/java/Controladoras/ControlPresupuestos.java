/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoOrdenesRecepcion;
import Daos.DaoPresupuestos;
import Modelo.Ordenesrecepcion;
import Modelo.Presupuestos;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlPresupuestos
{
    public ControlPresupuestos()
    {
        try
        {
            d_presupuestos=new DaoPresupuestos();
            d_ordenes_recep=new DaoOrdenesRecepcion();
            ListaOrdenesRecep=ListarOrdenes_Recep();
        }
        catch(Exception ex)
        {}
    }

    DaoOrdenesRecepcion d_ordenes_recep;
    DaoPresupuestos d_presupuestos;
    
    private Presupuestos agregar=new Presupuestos();
    
    private Presupuestos editar=new Presupuestos();
    
    private Presupuestos detallado=new Presupuestos();

    private Ordenesrecepcion[] ListaOrdenesRecep;
    
    public void VaciarCampos() 
    {
        agregar.setTareas("");
        agregar.setOpcional("");
        agregar.setPrecioestimado(0);
        agregar.setEsaceptado(false);
        agregar.setOrdenesrecepcion(new Ordenesrecepcion());
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
    
    public String AgregarPresupuesto() 
    {
        String Salida = "abmpresupuestos";

        try
        {
            if (agregar.getOrdenesrecepcion().getIdordenrecep() != null || agregar.getOrdenesrecepcion().getIdordenrecep() != 0) 
            {
                agregar.setEsaceptado(false);

                if (d_presupuestos.Agregar(agregar) == 0) 
                {
                    addMessage("Error al realizar la acción, verifique los datos.");
                }

                addMessage("Presupuesto agregado correctamente");

                return Salida;
            }
            else
            {
                addMessage("Seleccione orden de recepcion a la que desea crear presupuesto");
                
                return "abmordenesrecep";
            }
        }
        catch (Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return "abmordenesrecep";
        } 
        finally 
        {
            VaciarCampos();
        }
    }
    
    public String EliminarPresupuesto(Presupuestos p)
    {   
        String Salida="abmpresupuestos";
        
        try
        {
            d_presupuestos.Eliminar(p);
            
            addMessage("Presupuesto eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarPresupuesto(Presupuestos p)
    {
        String Salida="editarpresupuestos";
        
        editar=p;

        return Salida;
    }
    
    public String ActualizarPresupuesto()
    {
        String Salida="abmpresupuestos";
        
        try 
        {
            if (editar.getIdpresupuesto() != null || editar.getIdpresupuesto() != 0) 
            {
                d_presupuestos.Actualizar(editar);

                addMessage("Presupuesto editado correctamente");
            } 
            else 
            {
                addMessage("Seleccione presupuesto");
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
            editar=new Presupuestos();
        }
    }
    
    public ArrayList ListarPresupuestos()
    {
        try
        {
            return d_presupuestos.Listar();
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public Ordenesrecepcion[] ListarOrdenes_Recep()
    {
        try
        {
            ArrayList ListaO=d_ordenes_recep.Listar();
            
            ListaOrdenesRecep=new Ordenesrecepcion[ListaO.size()];
            
            for( int i = 0 ; i < ListaO.size() ; i++ )
            {
                ListaOrdenesRecep[i]=(Ordenesrecepcion)ListaO.get(i);
            }

            return ListaOrdenesRecep;
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public String VerDetalles(Presupuestos p)
    {
        String Salida="detallepresupuesto";
        
        detallado=p;
        
        return Salida;
    }
    
    public String CrearPresupuesto(Ordenesrecepcion o)
    {
        String Salida="agregarpresupuestos";
        
        try
        {
            agregar.setOrdenesrecepcion(o);
            
            return Salida;
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return Salida;
        }
    }

    /**
     * @return the agregar
     */
    public Presupuestos getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Presupuestos agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Presupuestos getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Presupuestos editar) {
        this.editar = editar;
    }

    /**
     * @return the detallado
     */
    public Presupuestos getDetallado() {
        return detallado;
    }

    /**
     * @param detallado the detallado to set
     */
    public void setDetallado(Presupuestos detallado) {
        this.detallado = detallado;
    }

    /**
     * @return the ListaOrdenesRecep
     */
    public Ordenesrecepcion[] getListaOrdenesRecep() {
        return ListaOrdenesRecep;
    }

    /**
     * @param ListaOrdenesRecep the ListaOrdenesRecep to set
     */
    public void setListaOrdenesRecep(Ordenesrecepcion[] ListaOrdenesRecep) {
        this.ListaOrdenesRecep = ListaOrdenesRecep;
    }
}
