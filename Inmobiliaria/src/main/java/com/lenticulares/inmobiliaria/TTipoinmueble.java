/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.inmobiliaria;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "t_tipoinmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoinmueble.findAll", query = "SELECT t FROM TTipoinmueble t"),
    @NamedQuery(name = "TTipoinmueble.findByIdTipoInmueble", query = "SELECT t FROM TTipoinmueble t WHERE t.idTipoInmueble = :idTipoInmueble"),
    @NamedQuery(name = "TTipoinmueble.findByDescripcion", query = "SELECT t FROM TTipoinmueble t WHERE t.descripcion = :descripcion")})
public class TTipoinmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoInmueble")
    private Integer idTipoInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoInmueble")
    private Collection<TInmueble> tInmuebleCollection;

    public TTipoinmueble() {
    }

    public TTipoinmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public TTipoinmueble(Integer idTipoInmueble, String descripcion) {
        this.idTipoInmueble = idTipoInmueble;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<TInmueble> getTInmuebleCollection() {
        return tInmuebleCollection;
    }

    public void setTInmuebleCollection(Collection<TInmueble> tInmuebleCollection) {
        this.tInmuebleCollection = tInmuebleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInmueble != null ? idTipoInmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipoinmueble)) {
            return false;
        }
        TTipoinmueble other = (TTipoinmueble) object;
        if ((this.idTipoInmueble == null && other.idTipoInmueble != null) || (this.idTipoInmueble != null && !this.idTipoInmueble.equals(other.idTipoInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmobiliaria.TTipoinmueble[ idTipoInmueble=" + idTipoInmueble + " ]";
    }
    
}
