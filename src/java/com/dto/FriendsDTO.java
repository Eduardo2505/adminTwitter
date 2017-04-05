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
public class FriendsDTO {

    private Long idFriends;
    private Long id;
    private Integer estado;
    private Integer idcuenta;
    private Date registro;

    public FriendsDTO() {
    }

    public FriendsDTO(Long idFriends, Long id, Integer estado, Integer idcuenta, Date registro) {
        this.idFriends = idFriends;
        this.id = id;
        this.estado = estado;
        this.idcuenta = idcuenta;
        this.registro = registro;
    }

    public Long getIdFriends() {
        return idFriends;
    }

    public void setIdFriends(Long idFriends) {
        this.idFriends = idFriends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
