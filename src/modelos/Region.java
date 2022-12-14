package modelos;
// Generated 26-jul-2022 20:25:01 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Region generated by hbm2java
 */
public class Region  implements java.io.Serializable {


     private Integer id;
     private Pais pais;
     private String nombre;
     private Float area;
     private Integer poblacion;
     private Set ciudads = new HashSet(0);

    public Region() {
    }

	
    public Region(Pais pais, String nombre) {
        this.pais = pais;
        this.nombre = nombre;
    }
    public Region(Pais pais, String nombre, Float area, Integer poblacion, Set ciudads) {
       this.pais = pais;
       this.nombre = nombre;
       this.area = area;
       this.poblacion = poblacion;
       this.ciudads = ciudads;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Float getArea() {
        return this.area;
    }
    
    public void setArea(Float area) {
        this.area = area;
    }
    public Integer getPoblacion() {
        return this.poblacion;
    }
    
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }
    public Set getCiudads() {
        return this.ciudads;
    }
    
    public void setCiudads(Set ciudads) {
        this.ciudads = ciudads;
    }




}


