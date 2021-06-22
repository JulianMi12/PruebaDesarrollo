/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dev.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a"),
    @NamedQuery(name = "Asignacion.findByCodigo", query = "SELECT a FROM Asignacion a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Asignacion.findByNomAgente", query = "SELECT a FROM Asignacion a WHERE a.nomAgente = :nomAgente"),
    @NamedQuery(name = "Asignacion.findByViaAsignada", query = "SELECT a FROM Asignacion a WHERE a.viaAsignada = :viaAsignada")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nom_agente")
    private String nomAgente;
    @Column(name = "via_asignada")
    private String viaAsignada;

    public Asignacion() {
    }

    public Asignacion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomAgente() {
        return nomAgente;
    }

    public void setNomAgente(String nomAgente) {
        this.nomAgente = nomAgente;
    }

    public String getViaAsignada() {
        return viaAsignada;
    }

    public void setViaAsignada(String viaAsignada) {
        this.viaAsignada = viaAsignada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.dev.entity.Asignacion[ codigo=" + codigo + " ]";
    }
    
}
