package Modelo;
// Generated 31/03/2014 16:06:45 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Tareas generated by hbm2java
 */
public class Tareas  implements java.io.Serializable {


     private Integer idtarea;
     private Ordenesreparacion ordenesreparacion;
     private Presupuestos presupuestos;
     private Operarios operarios;
     private String detalle;
     private double precio;
     private boolean esobligatoria;
     private Set<Listasrepuestos> listasrepuestoses = new HashSet<Listasrepuestos>(0);

    public Tareas() {
    }

	
    public Tareas(Presupuestos presupuestos, String detalle, double precio, boolean esobligatoria) {
        this.presupuestos = presupuestos;
        this.detalle = detalle;
        this.precio = precio;
        this.esobligatoria = esobligatoria;
    }
    public Tareas(Ordenesreparacion ordenesreparacion, Presupuestos presupuestos, Operarios operarios, String detalle, double precio, boolean esobligatoria, Set<Listasrepuestos> listasrepuestoses) {
       this.ordenesreparacion = ordenesreparacion;
       this.presupuestos = presupuestos;
       this.operarios = operarios;
       this.detalle = detalle;
       this.precio = precio;
       this.esobligatoria = esobligatoria;
       this.listasrepuestoses = listasrepuestoses;
    }
   
    public Integer getIdtarea() {
        return this.idtarea;
    }
    
    public void setIdtarea(Integer idtarea) {
        this.idtarea = idtarea;
    }
    public Ordenesreparacion getOrdenesreparacion() {
        return this.ordenesreparacion;
    }
    
    public void setOrdenesreparacion(Ordenesreparacion ordenesreparacion) {
        this.ordenesreparacion = ordenesreparacion;
    }
    public Presupuestos getPresupuestos() {
        return this.presupuestos;
    }
    
    public void setPresupuestos(Presupuestos presupuestos) {
        this.presupuestos = presupuestos;
    }
    public Operarios getOperarios() {
        return this.operarios;
    }
    
    public void setOperarios(Operarios operarios) {
        this.operarios = operarios;
    }
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public boolean isEsobligatoria() {
        return this.esobligatoria;
    }
    
    public void setEsobligatoria(boolean esobligatoria) {
        this.esobligatoria = esobligatoria;
    }
    public Set<Listasrepuestos> getListasrepuestoses() {
        return this.listasrepuestoses;
    }
    
    public void setListasrepuestoses(Set<Listasrepuestos> listasrepuestoses) {
        this.listasrepuestoses = listasrepuestoses;
    }




}


