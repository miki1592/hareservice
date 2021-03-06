package Modelo;
// Generated 31/03/2014 16:06:45 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Repuestos generated by hbm2java
 */
public class Repuestos  implements java.io.Serializable {


     private Integer idrepuesto;
     private Terceros terceros;
     private Tiposcalidad tiposcalidad;
     private Tiposrepuesto tiposrepuesto;
     private double precio;
     private String origen;
     private String codigoprov;
     private Set<Listasrepuestos> listasrepuestoses = new HashSet<Listasrepuestos>(0);

    public Repuestos() {
        terceros=new Terceros();
        tiposcalidad=new Tiposcalidad();
        tiposrepuesto=new Tiposrepuesto();
    }

	
    public Repuestos(Terceros terceros, Tiposcalidad tiposcalidad, Tiposrepuesto tiposrepuesto, double precio) {
        this.terceros = terceros;
        this.tiposcalidad = tiposcalidad;
        this.tiposrepuesto = tiposrepuesto;
        this.precio = precio;
    }
    public Repuestos(Terceros terceros, Tiposcalidad tiposcalidad, Tiposrepuesto tiposrepuesto, double precio, String origen, String codigoprov, Set<Listasrepuestos> listasrepuestoses) {
       this.terceros = terceros;
       this.tiposcalidad = tiposcalidad;
       this.tiposrepuesto = tiposrepuesto;
       this.precio = precio;
       this.origen = origen;
       this.codigoprov = codigoprov;
       this.listasrepuestoses = listasrepuestoses;
    }
   
    public Integer getIdrepuesto() {
        return this.idrepuesto;
    }
    
    public void setIdrepuesto(Integer idrepuesto) {
        this.idrepuesto = idrepuesto;
    }
    public Terceros getTerceros() {
        return this.terceros;
    }
    
    public void setTerceros(Terceros terceros) {
        this.terceros = terceros;
    }
    public Tiposcalidad getTiposcalidad() {
        return this.tiposcalidad;
    }
    
    public void setTiposcalidad(Tiposcalidad tiposcalidad) {
        this.tiposcalidad = tiposcalidad;
    }
    public Tiposrepuesto getTiposrepuesto() {
        return this.tiposrepuesto;
    }
    
    public void setTiposrepuesto(Tiposrepuesto tiposrepuesto) {
        this.tiposrepuesto = tiposrepuesto;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getOrigen() {
        return this.origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getCodigoprov() {
        return this.codigoprov;
    }
    
    public void setCodigoprov(String codigoprov) {
        this.codigoprov = codigoprov;
    }
    public Set<Listasrepuestos> getListasrepuestoses() {
        return this.listasrepuestoses;
    }
    
    public void setListasrepuestoses(Set<Listasrepuestos> listasrepuestoses) {
        this.listasrepuestoses = listasrepuestoses;
    }




}


