/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi3.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author kongf
 */
@Entity
@Table(name = "ldp_lista_de_problemas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LdpListaDeProblemas.findAll", query = "SELECT l FROM LdpListaDeProblemas l"),
    @NamedQuery(name = "LdpListaDeProblemas.findByLdpId", query = "SELECT l FROM LdpListaDeProblemas l WHERE l.ldpId = :ldpId"),
    @NamedQuery(name = "LdpListaDeProblemas.findByLdpCodigo", query = "SELECT l FROM LdpListaDeProblemas l WHERE l.ldpCodigo = :ldpCodigo"),
    @NamedQuery(name = "LdpListaDeProblemas.findByLdpNombre", query = "SELECT l FROM LdpListaDeProblemas l WHERE l.ldpNombre = :ldpNombre"),
    @NamedQuery(name = "LdpListaDeProblemas.findByLdpDescripcion", query = "SELECT l FROM LdpListaDeProblemas l WHERE l.ldpDescripcion = :ldpDescripcion")})
public class LdpListaDeProblemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LDP_ID")
    private Integer ldpId;
    @Column(name = "LDP_CODIGO")
    private Character ldpCodigo;
    @Size(max = 250)
    @Column(name = "LDP_NOMBRE")
    private String ldpNombre;
    @Size(max = 1250)
    @Column(name = "LDP_DESCRIPCION")
    private String ldpDescripcion;
    @OneToMany(mappedBy = "ldpId")
    private Collection<ChqChequeo> chqChequeoCollection;

    public LdpListaDeProblemas() {
    }

    public LdpListaDeProblemas(Integer ldpId) {
        this.ldpId = ldpId;
    }

    public Integer getLdpId() {
        return ldpId;
    }

    public void setLdpId(Integer ldpId) {
        this.ldpId = ldpId;
    }

    public Character getLdpCodigo() {
        return ldpCodigo;
    }

    public void setLdpCodigo(Character ldpCodigo) {
        this.ldpCodigo = ldpCodigo;
    }

    public String getLdpNombre() {
        return ldpNombre;
    }

    public void setLdpNombre(String ldpNombre) {
        this.ldpNombre = ldpNombre;
    }

    public String getLdpDescripcion() {
        return ldpDescripcion;
    }

    public void setLdpDescripcion(String ldpDescripcion) {
        this.ldpDescripcion = ldpDescripcion;
    }

    @XmlTransient
    public Collection<ChqChequeo> getChqChequeoCollection() {
        return chqChequeoCollection;
    }

    public void setChqChequeoCollection(Collection<ChqChequeo> chqChequeoCollection) {
        this.chqChequeoCollection = chqChequeoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ldpId != null ? ldpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LdpListaDeProblemas)) {
            return false;
        }
        LdpListaDeProblemas other = (LdpListaDeProblemas) object;
        if ((this.ldpId == null && other.ldpId != null) || (this.ldpId != null && !this.ldpId.equals(other.ldpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ldpId  + " " + ldpNombre;
    }
    
}
