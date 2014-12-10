/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.inmoprime;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danielfuentes
 */
@Entity
@Table(name = "t_zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TZona.findAll", query = "SELECT t FROM TZona t"),
    @NamedQuery(name = "TZona.findByIdZona", query = "SELECT t FROM TZona t WHERE t.idZona = :idZona"),
    @NamedQuery(name = "TZona.findByDescripcion", query = "SELECT t FROM TZona t WHERE t.descripcion = :descripcion")})
public class TZona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idZona")
    private Integer idZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private TCiudad idCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZona")
    private Collection<TBarrio> tBarrioCollection;

    public TZona() {
    }

    public TZona(Integer idZona) {
        this.idZona = idZona;
    }

    public TZona(Integer idZona, String descripcion) {
        this.idZona = idZona;
        this.descripcion = descripcion;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TCiudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(TCiudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @XmlTransient
    public Collection<TBarrio> getTBarrioCollection() {
        return tBarrioCollection;
    }

    public void setTBarrioCollection(Collection<TBarrio> tBarrioCollection) {
        this.tBarrioCollection = tBarrioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TZona)) {
            return false;
        }
        TZona other = (TZona) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmoprime.TZona[ idZona=" + idZona + " ]";
    }
    
}
