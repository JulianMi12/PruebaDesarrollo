/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dev.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "via")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Via.findAll", query = "SELECT v FROM Via v"),
    @NamedQuery(name = "Via.findById", query = "SELECT v FROM Via v WHERE v.id = :id"),
    @NamedQuery(name = "Via.findByTipo", query = "SELECT v FROM Via v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "Via.findByCllCrr", query = "SELECT v FROM Via v WHERE v.cllCrr = :cllCrr"),
    @NamedQuery(name = "Via.findByNumero", query = "SELECT v FROM Via v WHERE v.numero = :numero"),
    @NamedQuery(name = "Via.findByCongestion", query = "SELECT v FROM Via v WHERE v.congestion = :congestion")})
public class Via implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "cll_crr")
    private String cllCrr;
    @Column(name = "numero")
    private Integer numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "congestion")
    private BigDecimal congestion;
    @OneToMany(mappedBy = "viaActual")
    private Collection<Agente> agenteCollection;

    public Via() {
    }

    public Via(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCllCrr() {
        return cllCrr;
    }

    public void setCllCrr(String cllCrr) {
        this.cllCrr = cllCrr;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getCongestion() {
        return congestion;
    }

    public void setCongestion(BigDecimal congestion) {
        this.congestion = congestion;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Via)) {
            return false;
        }
        Via other = (Via) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.dev.entity.Via[ id=" + id + " ]";
    }
    
}
