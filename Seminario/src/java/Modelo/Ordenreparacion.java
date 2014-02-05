package Modelo;
// Generated 05/02/2014 14:26:02 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ordenreparacion generated by hbm2java
 */
public class Ordenreparacion  implements java.io.Serializable {


     private Integer idordenreparacion;
     private Cliente cliente;
     private Estadoreparacion estadoreparacion;
     private Date fechaInicio;
     private Date fechaEstipulada;
     private Date fechaFinalizacion;
     private double precio;
     private Set<Tarea> tareas = new HashSet<Tarea>(0);
     private Set<Auditoriaordenrep> auditoriaordenreps = new HashSet<Auditoriaordenrep>(0);

    public Ordenreparacion() {
    }

	
    public Ordenreparacion(Cliente cliente, Estadoreparacion estadoreparacion, Date fechaInicio, double precio) {
        this.cliente = cliente;
        this.estadoreparacion = estadoreparacion;
        this.fechaInicio = fechaInicio;
        this.precio = precio;
    }
    public Ordenreparacion(Cliente cliente, Estadoreparacion estadoreparacion, Date fechaInicio, Date fechaEstipulada, Date fechaFinalizacion, double precio, Set<Tarea> tareas, Set<Auditoriaordenrep> auditoriaordenreps) {
       this.cliente = cliente;
       this.estadoreparacion = estadoreparacion;
       this.fechaInicio = fechaInicio;
       this.fechaEstipulada = fechaEstipulada;
       this.fechaFinalizacion = fechaFinalizacion;
       this.precio = precio;
       this.tareas = tareas;
       this.auditoriaordenreps = auditoriaordenreps;
    }
   
    public Integer getIdordenreparacion() {
        return this.idordenreparacion;
    }
    
    public void setIdordenreparacion(Integer idordenreparacion) {
        this.idordenreparacion = idordenreparacion;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Estadoreparacion getEstadoreparacion() {
        return this.estadoreparacion;
    }
    
    public void setEstadoreparacion(Estadoreparacion estadoreparacion) {
        this.estadoreparacion = estadoreparacion;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaEstipulada() {
        return this.fechaEstipulada;
    }
    
    public void setFechaEstipulada(Date fechaEstipulada) {
        this.fechaEstipulada = fechaEstipulada;
    }
    public Date getFechaFinalizacion() {
        return this.fechaFinalizacion;
    }
    
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Set<Tarea> getTareas() {
        return this.tareas;
    }
    
    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }
    public Set<Auditoriaordenrep> getAuditoriaordenreps() {
        return this.auditoriaordenreps;
    }
    
    public void setAuditoriaordenreps(Set<Auditoriaordenrep> auditoriaordenreps) {
        this.auditoriaordenreps = auditoriaordenreps;
    }




}

