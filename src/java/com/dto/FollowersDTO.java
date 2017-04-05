/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import java.util.Date;

/**
 *
 * @author INE
 */
public class FollowersDTO {

    private Long idFollowers;
    private String id;
    private Integer estado;
    private Integer idcuenta;
    private Date registro;

    public FollowersDTO() {
    }

    public FollowersDTO(Long idFollowers, String id, Integer estado, Integer idcuenta, Date registro) {
        this.idFollowers = idFollowers;
        this.id = id;
        this.estado = estado;
        this.idcuenta = idcuenta;
        this.registro = registro;
    }

    public Long getIdFollowers() {
        return idFollowers;
    }

    public void setIdFollowers(Long idFollowers) {
        this.idFollowers = idFollowers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }
    
    
}
