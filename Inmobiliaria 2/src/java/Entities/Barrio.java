/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Barrio", catalog = "InmobiliariaDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b"),
    @NamedQuery(name = "Barrio.findByIdBarrio", query = "SELECT b FROM Barrio b WHERE b.idBarrio = :idBarrio"),
    @NamedQuery(name = "Barrio.findByDescripcion", query = "SELECT b FROM Barrio b WHERE b.descripcion = :descripcion")})
public class Barrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBarrio", nullable = false)
    private Integer idBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;
    @JoinTable(name = "Barrio_TipoInmueble", joinColumns = {
        @JoinColumn(name = "Barrio_idBarrio", referencedColumnName = "idBarrio", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "TipoInmueble_idTipoInmueble", referencedColumnName = "idTipoInmueble", nullable = false)})
    @ManyToMany
    private Collection<TipoInmueble> tipoInmuebleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarrio")
    private Collection<Inmueble> inmuebleCollection;
    @JoinColumn(name = "idZona", referencedColumnName = "idZona", nullable = false)
    @ManyToOne(optional = false)
    private Zona idZona;

    public Barrio() {
    }

    public Barrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Barrio(Integer idBarrio, String descripcion) {
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
    public Collection<TipoInmueble> getTipoInmuebleCollection() {
        return tipoInmuebleCollection;
    }

    public void setTipoInmuebleCollection(Collection<TipoInmueble> tipoInmuebleCollection) {
        this.tipoInmuebleCollection = tipoInmuebleCollection;
    }

    @XmlTransient
    public Collection<Inmueble> getInmuebleCollection() {
        return inmuebleCollection;
    }

    public void setInmuebleCollection(Collection<Inmueble> inmuebleCollection) {
        this.inmuebleCollection = inmuebleCollection;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
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
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idBarrio == null && other.idBarrio != null) || (this.idBarrio != null && !this.idBarrio.equals(other.idBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Barrio[ idBarrio=" + idBarrio + " ]";
    }
    
}
