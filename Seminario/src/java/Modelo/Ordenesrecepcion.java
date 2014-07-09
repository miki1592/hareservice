package Modelo;
// Generated 31/03/2014 16:06:45 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ordenesrecepcion generated by hbm2java
 */
public class Ordenesrecepcion  implements java.io.Serializable {


     private Integer idordenrecep;
     private Terceros terceros;
     private String detalle;
     private Date fecha;
     private String descripcion;
     private String adjunto;
     private Integer numero;
     private Set<Presupuestos> presupuestoses = new HashSet<Presupuestos>(0);

    public Ordenesrecepcion() {
        terceros=new Terceros();
    }

	
    public Ordenesrecepcion(Terceros terceros, String detalle, Date fecha,String descripcion,String adjunto,int numero) {
        this.terceros = terceros;
        this.detalle = detalle;
        this.fecha = fecha;
        this.descripcion=descripcion;
        this.adjunto=adjunto;
        this.numero=numero;
    }
    public Ordenesrecepcion(Terceros terceros, String detalle, Date fecha,String descripcion,String adjunto,int numero,Set<Presupuestos> presupuestoses) {
       this.terceros = terceros;
       this.detalle = detalle;
       this.fecha = fecha;
       this.descripcion=descripcion;
       this.adjunto=adjunto;
       this.presupuestoses = presupuestoses;
       this.numero=numero;
    }
   
    public Integer getIdordenrecep() {
        return this.idordenrecep;
    }
    
    public void setIdordenrecep(Integer idordenrecep) {
        this.idordenrecep = idordenrecep;
    }
    public Terceros getTerceros() {
        return this.terceros;
    }
    
    public void setTerceros(Terceros terceros) {
        this.terceros = terceros;
    }
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set<Presupuestos> getPresupuestoses() {
        return this.presupuestoses;
    }
    
    public void setPresupuestoses(Set<Presupuestos> presupuestoses) {
        this.presupuestoses = presupuestoses;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}


