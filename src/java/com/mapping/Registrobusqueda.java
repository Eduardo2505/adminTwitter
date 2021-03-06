package com.mapping;
// Generated 24/02/2016 11:52:11 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenerationTime;

/**
 * Registrobusqueda generated by hbm2java
 */
@Entity
@Table(name="registrobusqueda"
    ,catalog="twitteroperation"
)
public class Registrobusqueda  implements java.io.Serializable {


     private Long idRegistrobusqueda;
     private Cuenta cuenta;
     private String palabra;
     private Date registro;
     private Set<Search> searchs = new HashSet<Search>(0);

    public Registrobusqueda() {
    }

	
    public Registrobusqueda(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public Registrobusqueda(Cuenta cuenta, String palabra, Date registro, Set<Search> searchs) {
       this.cuenta = cuenta;
       this.palabra = palabra;
       this.registro = registro;
       this.searchs = searchs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idRegistrobusqueda", unique=true, nullable=false)
    public Long getIdRegistrobusqueda() {
        return this.idRegistrobusqueda;
    }
    
    public void setIdRegistrobusqueda(Long idRegistrobusqueda) {
        this.idRegistrobusqueda = idRegistrobusqueda;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idcuenta", nullable=false)
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    @Column(name="palabra", length=45)
    public String getPalabra() {
        return this.palabra;
    }
    
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
   @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
    @Column(name = "registro", length = 19, insertable = false, updatable = false, columnDefinition = "datetime")
    public Date getRegistro() {
        return this.registro;
    }
    
    public void setRegistro(Date registro) {
        this.registro = registro;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="registrobusqueda")
    public Set<Search> getSearchs() {
        return this.searchs;
    }
    
    public void setSearchs(Set<Search> searchs) {
        this.searchs = searchs;
    }




}


