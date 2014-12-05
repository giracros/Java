/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenticulares.inmobiliaria;

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
@Table(name = "t_inmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TInmueble.findAll", query = "SELECT t FROM TInmueble t"),
    @NamedQuery(name = "TInmueble.findByIdInmueble", query = "SELECT t FROM TInmueble t WHERE t.idInmueble = :idInmueble"),
    @NamedQuery(name = "TInmueble.findByCodigoInmueble", query = "SELECT t FROM TInmueble t WHERE t.codigoInmueble = :codigoInmueble"),
    @NamedQuery(name = "TInmueble.findByDireccionInmueble", query = "SELECT t FROM TInmueble t WHERE t.direccionInmueble = :direccionInmueble"),
    @NamedQuery(name = "TInmueble.findByEstrato", query = "SELECT t FROM TInmueble t WHERE t.estrato = :estrato"),
    @NamedQuery(name = "TInmueble.findByAreaMt2", query = "SELECT t FROM TInmueble t WHERE t.areaMt2 = :areaMt2"),
    @NamedQuery(name = "TInmueble.findByNivelPiso", query = "SELECT t FROM TInmueble t WHERE t.nivelPiso = :nivelPiso"),
    @NamedQuery(name = "TInmueble.findByNoAlcobas", query = "SELECT t FROM TInmueble t WHERE t.noAlcobas = :noAlcobas"),
    @NamedQuery(name = "TInmueble.findByNoBa\u00f1os", query = "SELECT t FROM TInmueble t WHERE t.noBa\u00f1os = :noBa\u00f1os"),
    @NamedQuery(name = "TInmueble.findByNoPatios", query = "SELECT t FROM TInmueble t WHERE t.noPatios = :noPatios"),
    @NamedQuery(name = "TInmueble.findByEspacios", query = "SELECT t FROM TInmueble t WHERE t.espacios = :espacios"),
    @NamedQuery(name = "TInmueble.findByTipoCocina", query = "SELECT t FROM TInmueble t WHERE t.tipoCocina = :tipoCocina"),
    @NamedQuery(name = "TInmueble.findByNoGarajes", query = "SELECT t FROM TInmueble t WHERE t.noGarajes = :noGarajes"),
    @NamedQuery(name = "TInmueble.findByZonasComunes", query = "SELECT t FROM TInmueble t WHERE t.zonasComunes = :zonasComunes"),
    @NamedQuery(name = "TInmueble.findByValorInmueble", query = "SELECT t FROM TInmueble t WHERE t.valorInmueble = :valorInmueble"),
    @NamedQuery(name = "TInmueble.findByObservaciones", query = "SELECT t FROM TInmueble t WHERE t.observaciones = :observaciones")})
public class TInmueble implements Serializable {
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
    private TBarrio idBarrio;
    @JoinColumn(name = "idDisponibilidad", referencedColumnName = "idDisponibilidad")
    @ManyToOne(optional = false)
    private TDisponibilidad idDisponibilidad;
    @JoinColumn(name = "idTipoInmueble", referencedColumnName = "idTipoInmueble")
    @ManyToOne(optional = false)
    private TTipoinmueble idTipoInmueble;
    @JoinColumn(name = "Empleado_IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
    private TUsuarios empleadoIdUsuario;
    @JoinColumn(name = "Cliente_IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
    private TUsuarios clienteIdUsuario;

    public TInmueble() {
    }

    public TInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public TInmueble(Integer idInmueble, String codigoInmueble, String direccionInmueble, String estrato, String areaMt2, String nivelPiso, String noAlcobas, String noBaños, String noPatios, String espacios, String tipoCocina, String noGarajes, String zonasComunes, BigDecimal valorInmueble) {
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

    public TBarrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(TBarrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public TDisponibilidad getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(TDisponibilidad idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public TTipoinmueble getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(TTipoinmueble idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public TUsuarios getEmpleadoIdUsuario() {
        return empleadoIdUsuario;
    }

    public void setEmpleadoIdUsuario(TUsuarios empleadoIdUsuario) {
        this.empleadoIdUsuario = empleadoIdUsuario;
    }

    public TUsuarios getClienteIdUsuario() {
        return clienteIdUsuario;
    }

    public void setClienteIdUsuario(TUsuarios clienteIdUsuario) {
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
        if (!(object instanceof TInmueble)) {
            return false;
        }
        TInmueble other = (TInmueble) object;
        if ((this.idInmueble == null && other.idInmueble != null) || (this.idInmueble != null && !this.idInmueble.equals(other.idInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmobiliaria.TInmueble[ idInmueble=" + idInmueble + " ]";
    }
    
}
