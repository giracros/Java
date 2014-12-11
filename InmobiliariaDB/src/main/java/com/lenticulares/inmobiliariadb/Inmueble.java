/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.inmobiliariadb;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielfuentes
 */
@Entity
@Table(name = "inmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i"),
    @NamedQuery(name = "Inmueble.findByIdInmueble", query = "SELECT i FROM Inmueble i WHERE i.idInmueble = :idInmueble"),
    @NamedQuery(name = "Inmueble.findByCodigoInmueble", query = "SELECT i FROM Inmueble i WHERE i.codigoInmueble = :codigoInmueble"),
    @NamedQuery(name = "Inmueble.findByDireccionInmueble", query = "SELECT i FROM Inmueble i WHERE i.direccionInmueble = :direccionInmueble"),
    @NamedQuery(name = "Inmueble.findByEstrato", query = "SELECT i FROM Inmueble i WHERE i.estrato = :estrato"),
    @NamedQuery(name = "Inmueble.findByAreaMt2", query = "SELECT i FROM Inmueble i WHERE i.areaMt2 = :areaMt2"),
    @NamedQuery(name = "Inmueble.findByNivelPiso", query = "SELECT i FROM Inmueble i WHERE i.nivelPiso = :nivelPiso"),
    @NamedQuery(name = "Inmueble.findByNoAlcobas", query = "SELECT i FROM Inmueble i WHERE i.noAlcobas = :noAlcobas"),
    @NamedQuery(name = "Inmueble.findByNoBa\u00f1os", query = "SELECT i FROM Inmueble i WHERE i.noBa\u00f1os = :noBa\u00f1os"),
    @NamedQuery(name = "Inmueble.findByNoPatios", query = "SELECT i FROM Inmueble i WHERE i.noPatios = :noPatios"),
    @NamedQuery(name = "Inmueble.findByEspacios", query = "SELECT i FROM Inmueble i WHERE i.espacios = :espacios"),
    @NamedQuery(name = "Inmueble.findByTipoCocina", query = "SELECT i FROM Inmueble i WHERE i.tipoCocina = :tipoCocina"),
    @NamedQuery(name = "Inmueble.findByNoGarajes", query = "SELECT i FROM Inmueble i WHERE i.noGarajes = :noGarajes"),
    @NamedQuery(name = "Inmueble.findByZonasComunes", query = "SELECT i FROM Inmueble i WHERE i.zonasComunes = :zonasComunes"),
    @NamedQuery(name = "Inmueble.findByValorInmueble", query = "SELECT i FROM Inmueble i WHERE i.valorInmueble = :valorInmueble"),
    @NamedQuery(name = "Inmueble.findByObservaciones", query = "SELECT i FROM Inmueble i WHERE i.observaciones = :observaciones")})
public class Inmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdInmueble")
    private Integer idInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CodigoInmueble")
    private String codigoInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DireccionInmueble")
    private String direccionInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Estrato")
    private String estrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "AreaMt2")
    private String areaMt2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Nivel Piso")
    private String nivelPiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NoAlcobas")
    private String noAlcobas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NoBa\u00f1os")
    private String noBaños;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NoPatios")
    private String noPatios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Espacios")
    private String espacios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TipoCocina")
    private String tipoCocina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NoGarajes")
    private String noGarajes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ZonasComunes")
    private String zonasComunes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorInmueble")
    private BigDecimal valorInmueble;
    @Size(max = 200)
    @Column(name = "Observaciones")
    private String observaciones;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne(optional = false)
    private Barrio idBarrio;
    @JoinColumn(name = "idDisponibilidad", referencedColumnName = "idDisponibilidad")
    @ManyToOne(optional = false)
    private Disponibilidad idDisponibilidad;
    @JoinColumn(name = "idTipoInmueble", referencedColumnName = "idTipoInmueble")
    @ManyToOne(optional = false)
    private Tipoinmueble idTipoInmueble;
    @JoinColumn(name = "Empleado_IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
    private Usuarios empleadoIdUsuario;
    @JoinColumn(name = "Cliente_IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
    private Usuarios clienteIdUsuario;

    public Inmueble() {
    }

    public Inmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Inmueble(Integer idInmueble, String codigoInmueble, String direccionInmueble, String estrato, String areaMt2, String nivelPiso, String noAlcobas, String noBaños, String noPatios, String espacios, String tipoCocina, String noGarajes, String zonasComunes, BigDecimal valorInmueble) {
        this.idInmueble = idInmueble;
        this.codigoInmueble = codigoInmueble;
        this.direccionInmueble = direccionInmueble;
        this.estrato = estrato;
        this.areaMt2 = areaMt2;
        this.nivelPiso = nivelPiso;
        this.noAlcobas = noAlcobas;
        this.noBaños = noBaños;
        this.noPatios = noPatios;
        this.espacios = espacios;
        this.tipoCocina = tipoCocina;
        this.noGarajes = noGarajes;
        this.zonasComunes = zonasComunes;
        this.valorInmueble = valorInmueble;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public String getDireccionInmueble() {
        return direccionInmueble;
    }

    public void setDireccionInmueble(String direccionInmueble) {
        this.direccionInmueble = direccionInmueble;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getAreaMt2() {
        return areaMt2;
    }

    public void setAreaMt2(String areaMt2) {
        this.areaMt2 = areaMt2;
    }

    public String getNivelPiso() {
        return nivelPiso;
    }

    public void setNivelPiso(String nivelPiso) {
        this.nivelPiso = nivelPiso;
    }

    public String getNoAlcobas() {
        return noAlcobas;
    }

    public void setNoAlcobas(String noAlcobas) {
        this.noAlcobas = noAlcobas;
    }

    public String getNoBaños() {
        return noBaños;
    }

    public void setNoBaños(String noBaños) {
        this.noBaños = noBaños;
    }

    public String getNoPatios() {
        return noPatios;
    }

    public void setNoPatios(String noPatios) {
        this.noPatios = noPatios;
    }

    public String getEspacios() {
        return espacios;
    }

    public void setEspacios(String espacios) {
        this.espacios = espacios;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getNoGarajes() {
        return noGarajes;
    }

    public void setNoGarajes(String noGarajes) {
        this.noGarajes = noGarajes;
    }

    public String getZonasComunes() {
        return zonasComunes;
    }

    public void setZonasComunes(String zonasComunes) {
        this.zonasComunes = zonasComunes;
    }

    public BigDecimal getValorInmueble() {
        return valorInmueble;
    }

    public void setValorInmueble(BigDecimal valorInmueble) {
        this.valorInmueble = valorInmueble;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Disponibilidad getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Disponibilidad idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public Tipoinmueble getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Tipoinmueble idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public Usuarios getEmpleadoIdUsuario() {
        return empleadoIdUsuario;
    }

    public void setEmpleadoIdUsuario(Usuarios empleadoIdUsuario) {
        this.empleadoIdUsuario = empleadoIdUsuario;
    }

    public Usuarios getClienteIdUsuario() {
        return clienteIdUsuario;
    }

    public void setClienteIdUsuario(Usuarios clienteIdUsuario) {
        this.clienteIdUsuario = clienteIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInmueble != null ? idInmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.idInmueble == null && other.idInmueble != null) || (this.idInmueble != null && !this.idInmueble.equals(other.idInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmobiliariadb.Inmueble[ idInmueble=" + idInmueble + " ]";
    }
    
}
