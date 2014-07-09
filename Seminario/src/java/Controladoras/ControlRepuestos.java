/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Daos.DaoProveedores;
import Daos.DaoRepuestos;
import Daos.DaoTiposCalidades;
import Daos.DaoTiposRespuestos;
import Modelo.Repuestos;
import Modelo.Terceros;
import Modelo.Tiposcalidad;
import Modelo.Tiposrepuesto;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author romero
 */
public class ControlRepuestos
{
    public ControlRepuestos()
    {
        try
        {
            d_repuestos=new DaoRepuestos();
            d_trepuestos=new DaoTiposRespuestos();
            d_tcalidades=new DaoTiposCalidades();
            d_proveedores=new DaoProveedores();
            ListaTRepuestos=ListarTiposRepuestos();
            ListaTCalidad=ListarTiposCalidad();
            ListaProveedores=ListarProveedores();
        }
        catch(Exception ex)
        {}
    }

    DaoRepuestos d_repuestos;
    DaoTiposRespuestos d_trepuestos;
    DaoTiposCalidades d_tcalidades;
    DaoProveedores d_proveedores;
    
    private Repuestos agregar=new Repuestos();
    
    private Repuestos editar=new Repuestos();
    
    private Tiposrepuesto[] ListaTRepuestos;
    private Tiposcalidad[] ListaTCalidad;
    private Terceros[] ListaProveedores;
    
    public void VaciarCampos() 
    {
        agregar.setCodigoprov("");
        agregar.setOrigen("");
        agregar.setPrecio(0);
        agregar.setTerceros(new Terceros());
        agregar.setTiposcalidad(new Tiposcalidad());
        agregar.setTiposrepuesto(new Tiposrepuesto());
    }
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AgregarRepuesto() 
    {
        String Salida = "agregarrepuestos";

        try
        {

            if (d_repuestos.Agregar(agregar) == 0) 
            {
                addMessage("Error al realizar la acción, verifique los datos.");
            }

            addMessage("Repuesto agregado correctamente");

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
    
    public String EliminarRepuesto(Repuestos r)
    {   
        String Salida="abmrepuestos";
        
        try
        {
            d_repuestos.Eliminar(r);
            
            addMessage("Repuesto eliminado correctamente");
            
            return Salida;
        }
        catch(Exception ex)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la acción, verifique los datos.", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return Salida;
        }
    }
    
    public String SeleccionarRepuesto(Repuestos r)
    {
        String Salida="editarrepuestos";
        
        editar=r;

        return Salida;
    }
    
    public String ActualizarRepuesto()
    {
        String Salida="abmrepuestos";
        
        try 
        {
            if (editar.getIdrepuesto() != null || editar.getIdrepuesto() != 0) 
            {
                d_repuestos.Actualizar(getEditar());

                addMessage("Repuesto editado correctamente");
            } 
            else 
            {
                addMessage("Seleccione repuesto");
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
           editar=new Repuestos();
        }
    }
    
    public ArrayList ListarRepuestos()
    {
        try
        {
            return d_repuestos.Listar();
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public Tiposrepuesto[] ListarTiposRepuestos()
    {
        try
        {
            ArrayList ListaTR=d_trepuestos.Listar();
            
            ListaTRepuestos=new Tiposrepuesto[ListaTR.size()];
            
            for( int i = 0 ; i < ListaTR.size() ; i++ )
            {
                ListaTRepuestos[i]=(Tiposrepuesto)ListaTR.get(i);
            }

            return ListaTRepuestos;
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public Tiposcalidad[] ListarTiposCalidad()
    {
        try
        {
            ArrayList ListaTC=d_tcalidades.Listar();
            
            ListaTCalidad=new Tiposcalidad[ListaTC.size()];
            
            for( int i = 0 ; i < ListaTC.size() ; i++ )
            {
                ListaTCalidad[i]=(Tiposcalidad)ListaTC.get(i);
            }

            return ListaTCalidad;
        }
        catch(Exception ex)
        {
            System.out.println("Ha ocurrido una excepcion en controladora: " +ex.getMessage());
            
            return null;
        }
    }
    
    public Terceros[] ListarProveedores()
    {
        try
        {
            ArrayList ListaP=d_proveedores.Listar();
            
            ListaProveedores=new Terceros[ListaP.size()];
            
            for( int i = 0 ; i < ListaP.size() ; i++ )
            {
                ListaProveedores[i]=(Terceros)ListaP.get(i);
            }

            return ListaProveedores;
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
    public Repuestos getAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(Repuestos agregar) {
        this.agregar = agregar;
    }

    /**
     * @return the editar
     */
    public Repuestos getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(Repuestos editar) {
        this.editar = editar;
    }

    /**
     * @return the ListaTRepuestos
     */
    public Tiposrepuesto[] getListaTRepuestos() {
        return ListaTRepuestos;
    }

    /**
     * @param ListaTRepuestos the ListaTRepuestos to set
     */
    public void setListaTRepuestos(Tiposrepuesto[] ListaTRepuestos) {
        this.ListaTRepuestos = ListaTRepuestos;
    }

    /**
     * @return the ListaTCalidad
     */
    public Tiposcalidad[] getListaTCalidad() {
        return ListaTCalidad;
    }

    /**
     * @param ListaTCalidad the ListaTCalidad to set
     */
    public void setListaTCalidad(Tiposcalidad[] ListaTCalidad) {
        this.ListaTCalidad = ListaTCalidad;
    }

    /**
     * @return the ListaProveedores
     */
    public Terceros[] getListaProveedores() {
        return ListaProveedores;
    }

    /**
     * @param ListaProveedores the ListaProveedores to set
     */
    public void setListaProveedores(Terceros[] ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }

}
