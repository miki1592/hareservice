package Modelo;
// Generated 31/03/2014 16:06:45 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Auditoriasordenrep generated by hbm2java
 */
public class Auditoriasordenrep  implements java.io.Serializable {


     private Integer idauditoriaordenrep;
     private Ordenesreparacion ordenesreparacion;
     private boolean esnueva;
     private Date fecha;

    public Auditoriasordenrep() {
    }

    public Auditoriasordenrep(Ordenesreparacion ordenesreparacion, boolean esnueva, Date fecha) {
       this.ordenesreparacion = ordenesreparacion;
       this.esnueva = esnueva;
       this.fecha = fecha;
    }
   
    public Integer getIdauditoriaordenrep() {
        return this.idauditoriaordenrep;
    }
    
    public void setIdauditoriaordenrep(Integer idauditoriaordenrep) {
        this.idauditoriaordenrep = idauditoriaordenrep;
    }
    public Ordenesreparacion getOrdenesreparacion() {
        return this.ordenesreparacion;
    }
    
    public void setOrdenesreparacion(Ordenesreparacion ordenesreparacion) {
        this.ordenesreparacion = ordenesreparacion;
    }
    public boolean isEsnueva() {
        return this.esnueva;
    }
    
    public void setEsnueva(boolean esnueva) {
        this.esnueva = esnueva;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


