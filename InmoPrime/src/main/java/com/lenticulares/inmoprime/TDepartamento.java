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
@Table(name = "t_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDepartamento.findAll", query = "SELECT t FROM TDepartamento t"),
    @NamedQuery(name = "TDepartamento.findByIdDepartamento", query = "SELECT t FROM TDepartamento t WHERE t.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "TDepartamento.findByDescripcion", query = "SELECT t FROM TDepartamento t WHERE t.descripcion = :descripcion")})
public class TDepartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartamento")
    private Integer idDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private Collection<TCiudad> tCiudadCollection;

    public TDepartamento() {
    }

    public TDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public TDepartamento(Integer idDepartamento, String descripcion) {
        this.idDepartamento = idDepartamento;
        this.descripcion = descripcion;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<TCiudad> getTCiudadCollection() {
        return tCiudadCollection;
    }

    public void setTCiudadCollection(Collection<TCiudad> tCiudadCollection) {
        this.tCiudadCollection = tCiudadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDepartamento)) {
            return false;
        }
        TDepartamento other = (TDepartamento) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmoprime.TDepartamento[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
