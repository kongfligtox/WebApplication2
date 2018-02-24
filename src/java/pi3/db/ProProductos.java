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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pro_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProProductos.findAll", query = "SELECT p FROM ProProductos p"),
    @NamedQuery(name = "ProProductos.findByProId", query = "SELECT p FROM ProProductos p WHERE p.proId = :proId"),
    @NamedQuery(name = "ProProductos.findByProNombre", query = "SELECT p FROM ProProductos p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "ProProductos.findByProDescripcion", query = "SELECT p FROM ProProductos p WHERE p.proDescripcion = :proDescripcion"),
    @NamedQuery(name = "ProProductos.findByProPrecioUnitario", query = "SELECT p FROM ProProductos p WHERE p.proPrecioUnitario = :proPrecioUnitario"),
    @NamedQuery(name = "ProProductos.findByProCantidad", query = "SELECT p FROM ProProductos p WHERE p.proCantidad = :proCantidad")})
public class ProProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID")
    private Integer proId;
    @Size(max = 80)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Size(max = 1250)
    @Column(name = "PRO_DESCRIPCION")
    private String proDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRO_PRECIO_UNITARIO")
    private Float proPrecioUnitario;
    @Column(name = "PRO_CANTIDAD")
    private Integer proCantidad;
    @OneToMany(mappedBy = "proId")
    private Collection<DetDetalle> detDetalleCollection;
    @JoinColumn(name = "TDP_ID", referencedColumnName = "TDP_ID")
    @ManyToOne
    private TdpTipoDeProducto tdpId;

    public ProProductos() {
    }

    public ProProductos(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public Float getProPrecioUnitario() {
        return proPrecioUnitario;
    }

    public void setProPrecioUnitario(Float proPrecioUnitario) {
        this.proPrecioUnitario = proPrecioUnitario;
    }

    public Integer getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(Integer proCantidad) {
        this.proCantidad = proCantidad;
    }

    @XmlTransient
    public Collection<DetDetalle> getDetDetalleCollection() {
        return detDetalleCollection;
    }

    public void setDetDetalleCollection(Collection<DetDetalle> detDetalleCollection) {
        this.detDetalleCollection = detDetalleCollection;
    }

    public TdpTipoDeProducto getTdpId() {
        return tdpId;
    }

    public void setTdpId(TdpTipoDeProducto tdpId) {
        this.tdpId = tdpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProProductos)) {
            return false;
        }
        ProProductos other = (ProProductos) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return proId  + " " + proNombre + " " + proDescripcion;
    }
    
}
