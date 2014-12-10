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
@Table(name = "t_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsuarios.findAll", query = "SELECT t FROM TUsuarios t"),
    @NamedQuery(name = "TUsuarios.findByIdUsuario", query = "SELECT t FROM TUsuarios t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TUsuarios.findByCedula", query = "SELECT t FROM TUsuarios t WHERE t.cedula = :cedula"),
    @NamedQuery(name = "TUsuarios.findByNombres", query = "SELECT t FROM TUsuarios t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TUsuarios.findByApellidos", query = "SELECT t FROM TUsuarios t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TUsuarios.findByEmail", query = "SELECT t FROM TUsuarios t WHERE t.email = :email"),
    @NamedQuery(name = "TUsuarios.findByTelefonoFijo", query = "SELECT t FROM TUsuarios t WHERE t.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "TUsuarios.findByCelular", query = "SELECT t FROM TUsuarios t WHERE t.celular = :celular"),
    @NamedQuery(name = "TUsuarios.findByDireccion", query = "SELECT t FROM TUsuarios t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TUsuarios.findByTipoUsuario", query = "SELECT t FROM TUsuarios t WHERE t.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "TUsuarios.findByPassword", query = "SELECT t FROM TUsuarios t WHERE t.password = :password")})
public class TUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TelefonoFijo")
    private String telefonoFijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TipoUsuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Password")
    private String password;
    @ManyToMany(mappedBy = "tUsuariosCollection")
    private Collection<TRol> tRolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdUsuario")
    private Collection<TInmueble> tInmuebleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdUsuario")
    private Collection<TInmueble> tInmuebleCollection1;

    public TUsuarios() {
    }

    public TUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TUsuarios(Integer idUsuario, String cedula, String nombres, String apellidos, String email, String telefonoFijo, String celular, String direccion, String tipoUsuario, String password) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<TRol> getTRolCollection() {
        return tRolCollection;
    }

    public void setTRolCollection(Collection<TRol> tRolCollection) {
        this.tRolCollection = tRolCollection;
    }

    @XmlTransient
    public Collection<TInmueble> getTInmuebleCollection() {
        return tInmuebleCollection;
    }

    public void setTInmuebleCollection(Collection<TInmueble> tInmuebleCollection) {
        this.tInmuebleCollection = tInmuebleCollection;
    }

    @XmlTransient
    public Collection<TInmueble> getTInmuebleCollection1() {
        return tInmuebleCollection1;
    }

    public void setTInmuebleCollection1(Collection<TInmueble> tInmuebleCollection1) {
        this.tInmuebleCollection1 = tInmuebleCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUsuarios)) {
            return false;
        }
        TUsuarios other = (TUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lenticulares.inmoprime.TUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
