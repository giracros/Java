/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.inmobiliaria;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "t_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRol.findAll", query = "SELECT t FROM TRol t"),
    @NamedQuery(name = "TRol.findByIdRol", query = "SELECT t FROM TRol t WHERE t.idRol = :idRol"),
    @NamedQuery(name = "TRol.findByDescripcion", query = "SELECT t FROM TRol t WHERE t.descripcion = :descripcion")})
public class TRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRol")
    private Integer idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinTable(name = "t_rolusuarios", joinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")}, inverseJoinColumns = {
        @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")})
    @ManyToMany
    private Collection<TUsuarios> tUsuariosCollection;

    public TRol() {
    }

    public TRol(Integer idRol) {
        this.idRol = idRol;
    }

    public TRol(Integer idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<TUsuarios> getTUsuariosCollection() {
        return tUsuariosCollection;
    }

    public void setTUsuariosCollection(Collection<TUsuarios> tUsuariosCollection) {
        this.tUsuariosCollection = tUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRol)) {
            return false;
        }
        TRol other = (TRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmobiliaria.TRol[ idRol=" + idRol + " ]";
    }
    
}
