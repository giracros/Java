/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Inmueble", catalog = "InmobiliariaDB", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i"),
    @NamedQuery(name = "Inmueble.findByCodigoInmueble", query = "SELECT i FROM Inmueble i WHERE i.codigoInmueble = :codigoInmueble"),
    @NamedQuery(name = "Inmueble.findByEstrato", query = "SELECT i FROM Inmueble i WHERE i.estrato = :estrato"),
    @NamedQuery(name = "Inmueble.findByArea", query = "SELECT i FROM Inmueble i WHERE i.area = :area"),
    @NamedQuery(name = "Inmueble.findByNivelPiso", query = "SELECT i FROM Inmueble i WHERE i.nivelPiso = :nivelPiso"),
    @NamedQuery(name = "Inmueble.findByAlcobas", query = "SELECT i FROM Inmueble i WHERE i.alcobas = :alcobas"),
    @NamedQuery(name = "Inmueble.findByBa\u00f1os", query = "SELECT i FROM Inmueble i WHERE i.ba\u00f1os = :ba\u00f1os"),
    @NamedQuery(name = "Inmueble.findByPatios", query = "SELECT i FROM Inmueble i WHERE i.patios = :patios"),
    @NamedQuery(name = "Inmueble.findByEspacios", query = "SELECT i FROM Inmueble i WHERE i.espacios = :espacios"),
    @NamedQuery(name = "Inmueble.findByCocina", query = "SELECT i FROM Inmueble i WHERE i.cocina = :cocina"),
    @NamedQuery(name = "Inmueble.findByGaraje", query = "SELECT i FROM Inmueble i WHERE i.garaje = :garaje"),
    @NamedQuery(name = "Inmueble.findByZonaComun", query = "SELECT i FROM Inmueble i WHERE i.zonaComun = :zonaComun"),
    @NamedQuery(name = "Inmueble.findByObservaciones", query = "SELECT i FROM Inmueble i WHERE i.observaciones = :observaciones")})
public class Inmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodigoInmueble", nullable = false, length = 20)
    private String codigoInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Estrato", nullable = false, length = 2)
    private String estrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Area", nullable = false, length = 4)
    private String area;
    @Size(max = 4)
    @Column(name = "NivelPiso", length = 4)
    private String nivelPiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Alcobas", nullable = false, length = 4)
    private String alcobas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Ba\u00f1os", nullable = false, length = 4)
    private String baños;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Patios", nullable = false, length = 4)
    private String patios;
    @Size(max = 45)
    @Column(name = "Espacios", length = 45)
    private String espacios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cocina", nullable = false, length = 45)
    private String cocina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Garaje", nullable = false, length = 4)
    private String garaje;
    @Size(max = 45)
    @Column(name = "ZonaComun", length = 45)
    private String zonaComun;
    @Size(max = 250)
    @Column(name = "Observaciones", length = 250)
    private String observaciones;
    @JoinTable(name = "Persona_Inmueble", joinColumns = {
        @JoinColumn(name = "Inmueble_CodigoInmueble", referencedColumnName = "CodigoInmueble", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "Persona_idPersona", referencedColumnName = "idPersona", nullable = false)})
    @ManyToMany
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio", nullable = false)
    @ManyToOne(optional = false)
    private Barrio idBarrio;
    @JoinColumn(name = "idTipoInmueble", referencedColumnName = "idTipoInmueble", nullable = false)
    @ManyToOne(optional = false)
    private TipoInmueble idTipoInmueble;
    @JoinColumn(name = "idDisponibilidad", referencedColumnName = "idDisponibilidad", nullable = false)
    @ManyToOne(optional = false)
    private Disponibilidad idDisponibilidad;
    @JoinColumn(name = "idRangoPrecio", referencedColumnName = "idRangoPrecio", nullable = false)
    @ManyToOne(optional = false)
    private RangoPrecio idRangoPrecio;

    public Inmueble() {
    }

    public Inmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public Inmueble(String codigoInmueble, String estrato, String area, String alcobas, String baños, String patios, String cocina, String garaje) {
        this.codigoInmueble = codigoInmueble;
        this.estrato = estrato;
        this.area = area;
        this.alcobas = alcobas;
        this.baños = baños;
        this.patios = patios;
        this.cocina = cocina;
        this.garaje = garaje;
    }

    public String getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNivelPiso() {
        return nivelPiso;
    }

    public void setNivelPiso(String nivelPiso) {
        this.nivelPiso = nivelPiso;
    }

    public String getAlcobas() {
        return alcobas;
    }

    public void setAlcobas(String alcobas) {
        this.alcobas = alcobas;
    }

    public String getBaños() {
        return baños;
    }

    public void setBaños(String baños) {
        this.baños = baños;
    }

    public String getPatios() {
        return patios;
    }

    public void setPatios(String patios) {
        this.patios = patios;
    }

    public String getEspacios() {
        return espacios;
    }

    public void setEspacios(String espacios) {
        this.espacios = espacios;
    }

    public String getCocina() {
        return cocina;
    }

    public void setCocina(String cocina) {
        this.cocina = cocina;
    }

    public String getGaraje() {
        return garaje;
    }

    public void setGaraje(String garaje) {
        this.garaje = garaje;
    }

    public String getZonaComun() {
        return zonaComun;
    }

    public void setZonaComun(String zonaComun) {
        this.zonaComun = zonaComun;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public TipoInmueble getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(TipoInmueble idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public Disponibilidad getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Disponibilidad idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public RangoPrecio getIdRangoPrecio() {
        return idRangoPrecio;
    }

    public void setIdRangoPrecio(RangoPrecio idRangoPrecio) {
        this.idRangoPrecio = idRangoPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInmueble != null ? codigoInmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.codigoInmueble == null && other.codigoInmueble != null) || (this.codigoInmueble != null && !this.codigoInmueble.equals(other.codigoInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Inmueble[ codigoInmueble=" + codigoInmueble + " ]";
    }
    
}
