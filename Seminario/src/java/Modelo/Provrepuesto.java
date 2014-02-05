package Modelo;
// Generated 05/02/2014 14:26:02 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Provrepuesto generated by hbm2java
 */
public class Provrepuesto  implements java.io.Serializable {


     private Integer idprovrepuesto;
     private Tipocalidad tipocalidad;
     private Repuesto repuesto;
     private Proveedor proveedor;
     private String codigoproveedor;
     private double precio;
     private String origen;
     private Set<Listarepuestos> listarepuestoses = new HashSet<Listarepuestos>(0);

    public Provrepuesto() {
    }

	
    public Provrepuesto(Tipocalidad tipocalidad, Repuesto repuesto, Proveedor proveedor, String codigoproveedor, double precio, String origen) {
        this.tipocalidad = tipocalidad;
        this.repuesto = repuesto;
        this.proveedor = proveedor;
        this.codigoproveedor = codigoproveedor;
        this.precio = precio;
        this.origen = origen;
    }
    public Provrepuesto(Tipocalidad tipocalidad, Repuesto repuesto, Proveedor proveedor, String codigoproveedor, double precio, String origen, Set<Listarepuestos> listarepuestoses) {
       this.tipocalidad = tipocalidad;
       this.repuesto = repuesto;
       this.proveedor = proveedor;
       this.codigoproveedor = codigoproveedor;
       this.precio = precio;
       this.origen = origen;
       this.listarepuestoses = listarepuestoses;
    }
   
    public Integer getIdprovrepuesto() {
        return this.idprovrepuesto;
    }
    
    public void setIdprovrepuesto(Integer idprovrepuesto) {
        this.idprovrepuesto = idprovrepuesto;
    }
    public Tipocalidad getTipocalidad() {
        return this.tipocalidad;
    }
    
    public void setTipocalidad(Tipocalidad tipocalidad) {
        this.tipocalidad = tipocalidad;
    }
    public Repuesto getRepuesto() {
        return this.repuesto;
    }
    
    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public String getCodigoproveedor() {
        return this.codigoproveedor;
    }
    
    public void setCodigoproveedor(String codigoproveedor) {
        this.codigoproveedor = codigoproveedor;
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
    public Set<Listarepuestos> getListarepuestoses() {
        return this.listarepuestoses;
    }
    
    public void setListarepuestoses(Set<Listarepuestos> listarepuestoses) {
        this.listarepuestoses = listarepuestoses;
    }




}

