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
@Table(name = "tdp_tipo_de_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TdpTipoDeProducto.findAll", query = "SELECT t FROM TdpTipoDeProducto t"),
    @NamedQuery(name = "TdpTipoDeProducto.findByTdpId", query = "SELECT t FROM TdpTipoDeProducto t WHERE t.tdpId = :tdpId"),
    @NamedQuery(name = "TdpTipoDeProducto.findByTdpNombre", query = "SELECT t FROM TdpTipoDeProducto t WHERE t.tdpNombre = :tdpNombre")})
public class TdpTipoDeProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TDP_ID")
    private Integer tdpId;
    @Size(max = 80)
    @Column(name = "TDP_NOMBRE")
    private String tdpNombre;
    @OneToMany(mappedBy = "tdpId")
    private Collection<ProProductos> proProductosCollection;

    public TdpTipoDeProducto() {
    }

    public TdpTipoDeProducto(Integer tdpId) {
        this.tdpId = tdpId;
    }

    public Integer getTdpId() {
        return tdpId;
    }

    public void setTdpId(Integer tdpId) {
        this.tdpId = tdpId;
    }

    public String getTdpNombre() {
        return tdpNombre;
    }

    public void setTdpNombre(String tdpNombre) {
        this.tdpNombre = tdpNombre;
    }

    @XmlTransient
    public Collection<ProProductos> getProProductosCollection() {
        return proProductosCollection;
    }

    public void setProProductosCollection(Collection<ProProductos> proProductosCollection) {
        this.proProductosCollection = proProductosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdpId != null ? tdpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TdpTipoDeProducto)) {
            return false;
        }
        TdpTipoDeProducto other = (TdpTipoDeProducto) object;
        if ((this.tdpId == null && other.tdpId != null) || (this.tdpId != null && !this.tdpId.equals(other.tdpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tdpId  + " " + tdpNombre;
    }
    
}
