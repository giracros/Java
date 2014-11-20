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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "TipoInmueble", catalog = "InmobiliariaDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInmueble.findAll", query = "SELECT t FROM TipoInmueble t"),
    @NamedQuery(name = "TipoInmueble.findByIdTipoInmueble", query = "SELECT t FROM TipoInmueble t WHERE t.idTipoInmueble = :idTipoInmueble"),
    @NamedQuery(name = "TipoInmueble.findByDescripcion", query = "SELECT t FROM TipoInmueble t WHERE t.descripcion = :descripcion")})
public class TipoInmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoInmueble", nullable = false)
    private Integer idTipoInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion", nullable = false, length = 45)
    private String descripcion;
    @ManyToMany(mappedBy = "tipoInmuebleCollection")
    private Collection<Disponibilidad> disponibilidadCollection;
    @ManyToMany(mappedBy = "tipoInmuebleCollection")
    private Collection<Barrio> barrioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoInmueble")
    private Collection<Inmueble> inmuebleCollection;

    public TipoInmueble() {
    }

    public TipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public TipoInmueble(Integer idTipoInmueble, String descripcion) {
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
    public Collection<Disponibilidad> getDisponibilidadCollection() {
        return disponibilidadCollection;
    }

    public void setDisponibilidadCollection(Collection<Disponibilidad> disponibilidadCollection) {
        this.disponibilidadCollection = disponibilidadCollection;
    }

    @XmlTransient
    public Collection<Barrio> getBarrioCollection() {
        return barrioCollection;
    }

    public void setBarrioCollection(Collection<Barrio> barrioCollection) {
        this.barrioCollection = barrioCollection;
    }

    @XmlTransient
    public Collection<Inmueble> getInmuebleCollection() {
        return inmuebleCollection;
    }

    public void setInmuebleCollection(Collection<Inmueble> inmuebleCollection) {
        this.inmuebleCollection = inmuebleCollection;
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
        if (!(object instanceof TipoInmueble)) {
            return false;
        }
        TipoInmueble other = (TipoInmueble) object;
        if ((this.idTipoInmueble == null && other.idTipoInmueble != null) || (this.idTipoInmueble != null && !this.idTipoInmueble.equals(other.idTipoInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoInmueble[ idTipoInmueble=" + idTipoInmueble + " ]";
    }
    
}
