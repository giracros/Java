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
@Table(name = "RangoPrecio", catalog = "InmobiliariaDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RangoPrecio.findAll", query = "SELECT r FROM RangoPrecio r"),
    @NamedQuery(name = "RangoPrecio.findByIdRangoPrecio", query = "SELECT r FROM RangoPrecio r WHERE r.idRangoPrecio = :idRangoPrecio"),
    @NamedQuery(name = "RangoPrecio.findByDescripcion", query = "SELECT r FROM RangoPrecio r WHERE r.descripcion = :descripcion")})
public class RangoPrecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRangoPrecio", nullable = false)
    private Integer idRangoPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Descripcion", nullable = false, length = 12)
    private String descripcion;
    @ManyToMany(mappedBy = "rangoPrecioCollection")
    private Collection<Disponibilidad> disponibilidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRangoPrecio")
    private Collection<Inmueble> inmuebleCollection;

    public RangoPrecio() {
    }

    public RangoPrecio(Integer idRangoPrecio) {
        this.idRangoPrecio = idRangoPrecio;
    }

    public RangoPrecio(Integer idRangoPrecio, String descripcion) {
        this.idRangoPrecio = idRangoPrecio;
        this.descripcion = descripcion;
    }

    public Integer getIdRangoPrecio() {
        return idRangoPrecio;
    }

    public void setIdRangoPrecio(Integer idRangoPrecio) {
        this.idRangoPrecio = idRangoPrecio;
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
    public Collection<Inmueble> getInmuebleCollection() {
        return inmuebleCollection;
    }

    public void setInmuebleCollection(Collection<Inmueble> inmuebleCollection) {
        this.inmuebleCollection = inmuebleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRangoPrecio != null ? idRangoPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangoPrecio)) {
            return false;
        }
        RangoPrecio other = (RangoPrecio) object;
        if ((this.idRangoPrecio == null && other.idRangoPrecio != null) || (this.idRangoPrecio != null && !this.idRangoPrecio.equals(other.idRangoPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RangoPrecio[ idRangoPrecio=" + idRangoPrecio + " ]";
    }
    
}
