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
@Table(name = "t_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCiudad.findAll", query = "SELECT t FROM TCiudad t"),
    @NamedQuery(name = "TCiudad.findByIdCiudad", query = "SELECT t FROM TCiudad t WHERE t.idCiudad = :idCiudad"),
    @NamedQuery(name = "TCiudad.findByDescripcion", query = "SELECT t FROM TCiudad t WHERE t.descripcion = :descripcion")})
public class TCiudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCiudad")
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "idDepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne(optional = false)
    private TDepartamento idDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private Collection<TZona> tZonaCollection;

    public TCiudad() {
    }

    public TCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public TCiudad(Integer idCiudad, String descripcion) {
        this.idCiudad = idCiudad;
        this.descripcion = descripcion;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TDepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(TDepartamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public Collection<TZona> getTZonaCollection() {
        return tZonaCollection;
    }

    public void setTZonaCollection(Collection<TZona> tZonaCollection) {
        this.tZonaCollection = tZonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCiudad)) {
            return false;
        }
        TCiudad other = (TCiudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmoprime.TCiudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
