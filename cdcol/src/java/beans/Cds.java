/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielfuentes
 */
@Entity
@Table(name = "cds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cds.findAll", query = "SELECT c FROM Cds c"),
    @NamedQuery(name = "Cds.findByTitel", query = "SELECT c FROM Cds c WHERE c.titel = :titel"),
    @NamedQuery(name = "Cds.findByInterpret", query = "SELECT c FROM Cds c WHERE c.interpret = :interpret"),
    @NamedQuery(name = "Cds.findByJahr", query = "SELECT c FROM Cds c WHERE c.jahr = :jahr"),
    @NamedQuery(name = "Cds.findById", query = "SELECT c FROM Cds c WHERE c.id = :id")})
public class Cds implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 200)
    @Column(name = "titel")
    private String titel;
    @Size(max = 200)
    @Column(name = "interpret")
    private String interpret;
    @Column(name = "jahr")
    private Integer jahr;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    public Cds() {
    }

    public Cds(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public Integer getJahr() {
        return jahr;
    }

    public void setJahr(Integer jahr) {
        this.jahr = jahr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cds)) {
            return false;
        }
        Cds other = (Cds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Cds[ id=" + id + " ]";
    }
    
}
