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
@Table(name = "t_disponibilidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDisponibilidad.findAll", query = "SELECT t FROM TDisponibilidad t"),
    @NamedQuery(name = "TDisponibilidad.findByIdDisponibilidad", query = "SELECT t FROM TDisponibilidad t WHERE t.idDisponibilidad = :idDisponibilidad"),
    @NamedQuery(name = "TDisponibilidad.findByDescripcion", query = "SELECT t FROM TDisponibilidad t WHERE t.descripcion = :descripcion")})
public class TDisponibilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDisponibilidad")
    private Integer idDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisponibilidad")
    private Collection<TInmueble> tInmuebleCollection;

    public TDisponibilidad() {
    }

    public TDisponibilidad(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public TDisponibilidad(Integer idDisponibilidad, String descripcion) {
        this.idDisponibilidad = idDisponibilidad;
        this.descripcion = descripcion;
    }

    public Integer getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
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
        hash += (idDisponibilidad != null ? idDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDisponibilidad)) {
            return false;
        }
        TDisponibilidad other = (TDisponibilidad) object;
        if ((this.idDisponibilidad == null && other.idDisponibilidad != null) || (this.idDisponibilidad != null && !this.idDisponibilidad.equals(other.idDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmobiliaria.TDisponibilidad[ idDisponibilidad=" + idDisponibilidad + " ]";
    }
    
}
