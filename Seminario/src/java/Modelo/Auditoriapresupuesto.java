package Modelo;
// Generated 05/02/2014 14:26:02 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Auditoriapresupuesto generated by hbm2java
 */
public class Auditoriapresupuesto  implements java.io.Serializable {


     private Integer idauditoriapres;
     private Presupuesto presupuesto;
     private boolean esnueva;
     private Date fecha;

    public Auditoriapresupuesto() {
    }

    public Auditoriapresupuesto(Presupuesto presupuesto, boolean esnueva, Date fecha) {
       this.presupuesto = presupuesto;
       this.esnueva = esnueva;
       this.fecha = fecha;
    }
   
    public Integer getIdauditoriapres() {
        return this.idauditoriapres;
    }
    
    public void setIdauditoriapres(Integer idauditoriapres) {
        this.idauditoriapres = idauditoriapres;
    }
    public Presupuesto getPresupuesto() {
        return this.presupuesto;
    }
    
    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
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

