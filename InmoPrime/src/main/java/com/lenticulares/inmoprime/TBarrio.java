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
@Table(name = "t_barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TBarrio.findAll", query = "SELECT t FROM TBarrio t"),
    @NamedQuery(name = "TBarrio.findByIdBarrio", query = "SELECT t FROM TBarrio t WHERE t.idBarrio = :idBarrio"),
    @NamedQuery(name = "TBarrio.findByDescripcion", query = "SELECT t FROM TBarrio t WHERE t.descripcion = :descripcion")})
public class TBarrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarrio")
    private Collection<TInmueble> tInmuebleCollection;
    @JoinColumn(name = "idZona", referencedColumnName = "idZona")
    @ManyToOne(optional = false)
    private TZona idZona;

    public TBarrio() {
    }

    public TBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public TBarrio(Integer idBarrio, String descripcion) {
        this.idBarrio = idBarrio;
        this.descripcion = descripcion;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
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

    public TZona getIdZona() {
        return idZona;
    }

    public void setIdZona(TZona idZona) {
        this.idZona = idZona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarrio != null ? idBarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBarrio)) {
            return false;
        }
        TBarrio other = (TBarrio) object;
        if ((this.idBarrio == null && other.idBarrio != null) || (this.idBarrio != null && !this.idBarrio.equals(other.idBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmoprime.TBarrio[ idBarrio=" + idBarrio + " ]";
    }
    
}
