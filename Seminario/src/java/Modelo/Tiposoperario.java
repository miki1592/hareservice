package Modelo;
// Generated 31/03/2014 16:06:45 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Tiposoperario generated by hbm2java
 */
public class Tiposoperario  implements java.io.Serializable {

     private Integer idtipooperario;
     private String tipo;
     
     private Set<Operarios> operarioses = new HashSet<Operarios>(0);

    public Tiposoperario() {
    }

	
    public Tiposoperario(String tipo) {
        this.tipo = tipo;
    }
    public Tiposoperario(String tipo, Set<Operarios> operarioses) {
       this.tipo = tipo;
       this.operarioses = operarioses;
    }
   
    public Integer getIdtipooperario() {
        return this.idtipooperario;
    }
    
    public void setIdtipooperario(Integer idtipooperario) {
        this.idtipooperario = idtipooperario;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Set<Operarios> getOperarioses() {
        return this.operarioses;
    }
    
    public void setOperarioses(Set<Operarios> operarioses) {
        this.operarioses = operarioses;
    }




}


