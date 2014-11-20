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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Disponibilidad", catalog = "InmobiliariaDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilidad.findAll", query = "SELECT d FROM Disponibilidad d"),
    @NamedQuery(name = "Disponibilidad.findByIdDisponibilidad", query = "SELECT d FROM Disponibilidad d WHERE d.idDisponibilidad = :idDisponibilidad"),
    @NamedQuery(name = "Disponibilidad.findByDescripcion", query = "SELECT d FROM Disponibilidad d WHERE d.descripcion = :descripcion")})
public class Disponibilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDisponibilidad", nullable = false)
    private Integer idDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion", nullable = false, length = 45)
    private String descripcion;
    @JoinTable(name = "TipoInmueble_Disponibilidad", joinColumns = {
        @JoinColumn(name = "Disponibilidad_idDisponibilidad", referencedColumnName = "idDisponibilidad", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "TipoInmueble_idTipoInmueble", referencedColumnName = "idTipoInmueble", nullable = false)})
    @ManyToMany
    private Collection<TipoInmueble> tipoInmuebleCollection;
    @JoinTable(name = "Disponibilidad_RangoPrecio", joinColumns = {
        @JoinColumn(name = "Disponibilidad_idDisponibilidad", referencedColumnName = "idDisponibilidad", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "RangoPrecio_idRangoPrecio", referencedColumnName = "idRangoPrecio", nullable = false)})
    @ManyToMany
    private Collection<RangoPrecio> rangoPrecioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisponibilidad")
    private Collection<Inmueble> inmuebleCollection;

    public Disponibilidad() {
    }

    public Disponibilidad(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public Disponibilidad(Integer idDisponibilidad, String descripcion) {
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
    public Collection<TipoInmueble> getTipoInmuebleCollection() {
        return tipoInmuebleCollection;
    }

    public void setTipoInmuebleCollection(Collection<TipoInmueble> tipoInmuebleCollection) {
        this.tipoInmuebleCollection = tipoInmuebleCollection;
    }

    @XmlTransient
    public Collection<RangoPrecio> getRangoPrecioCollection() {
        return rangoPrecioCollection;
    }

    public void setRangoPrecioCollection(Collection<RangoPrecio> rangoPrecioCollection) {
        this.rangoPrecioCollection = rangoPrecioCollection;
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
        hash += (idDisponibilidad != null ? idDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilidad)) {
            return false;
        }
        Disponibilidad other = (Disponibilidad) object;
        if ((this.idDisponibilidad == null && other.idDisponibilidad != null) || (this.idDisponibilidad != null && !this.idDisponibilidad.equals(other.idDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Disponibilidad[ idDisponibilidad=" + idDisponibilidad + " ]";
    }
    
}
