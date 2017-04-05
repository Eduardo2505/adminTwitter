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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenerationTime;

/**
 * Cuenta generated by hbm2java
 */
@Entity
@Table(name = "cuenta", catalog = "twitteroperation")
public class Cuenta implements java.io.Serializable {

    private Integer idcuenta;
    private Long id;
    private String usuario;
    private String accessToken;
    private String accessTokenSecret;
    private String consumerKey;
    private String consumerSecret;
    private Date registro;
    private Set<Friends> friendses = new HashSet<Friends>(0);
    private Set<Registrobusqueda> registrobusquedas = new HashSet<Registrobusqueda>(0);
    private Set<Followers> followerses = new HashSet<Followers>(0);

    public Cuenta() {
    }

    public Cuenta(Long id, String usuario, String accessToken, String accessTokenSecret, String consumerKey, String consumerSecret, Date registro, Set<Friends> friendses, Set<Registrobusqueda> registrobusquedas, Set<Followers> followerses) {
        this.id = id;
        this.usuario = usuario;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.registro = registro;
        this.friendses = friendses;
        this.registrobusquedas = registrobusquedas;
        this.followerses = followerses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idcuenta", unique = true, nullable = false)
    public Integer getIdcuenta() {
        return this.idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "usuario", length = 45)
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "AccessToken", length = 450)
    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Column(name = "AccessTokenSecret", length = 450)
    public String getAccessTokenSecret() {
        return this.accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    @Column(name = "ConsumerKey", length = 450)
    public String getConsumerKey() {
        return this.consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    @Column(name = "ConsumerSecret", length = 450)
    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cuenta")
    public Set<Friends> getFriendses() {
        return this.friendses;
    }

    public void setFriendses(Set<Friends> friendses) {
        this.friendses = friendses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cuenta")
    public Set<Registrobusqueda> getRegistrobusquedas() {
        return this.registrobusquedas;
    }

    public void setRegistrobusquedas(Set<Registrobusqueda> registrobusquedas) {
        this.registrobusquedas = registrobusquedas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cuenta")
    public Set<Followers> getFollowerses() {
        return this.followerses;
    }

    public void setFollowerses(Set<Followers> followerses) {
        this.followerses = followerses;
    }
}
