/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "agente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agente.findAll", query = "SELECT a FROM Agente a"),
    @NamedQuery(name = "Agente.findByNombre", query = "SELECT a FROM Agente a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Agente.findByCodigo", query = "SELECT a FROM Agente a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Agente.findByA\u00f1osExperiencia", query = "SELECT a FROM Agente a WHERE a.a\u00f1osExperiencia = :a\u00f1osExperiencia")})
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "a\u00f1os_experiencia")
    private BigDecimal añosExperiencia;
    @JoinColumn(name = "cod_secretaria", referencedColumnName = "codigo")
    @ManyToOne
    private Secretaria codSecretaria;
    @JoinColumn(name = "via_actual", referencedColumnName = "id")
    @ManyToOne
    private Via viaActual;

    public Agente() {
    }

    public Agente(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(BigDecimal añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public Secretaria getCodSecretaria() {
        return codSecretaria;
    }

    public void setCodSecretaria(Secretaria codSecretaria) {
        this.codSecretaria = codSecretaria;
    }

    public Via getViaActual() {
        return viaActual;
    }

    public void setViaActual(Via viaActual) {
        this.viaActual = viaActual;
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
        if (!(object instanceof Agente)) {
            return false;
        }
        Agente other = (Agente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.dev.entity.Agente[ codigo=" + codigo + " ]";
    }
    
}
