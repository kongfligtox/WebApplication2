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
@Table(name = "det_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetDetalle.findAll", query = "SELECT d FROM DetDetalle d"),
    @NamedQuery(name = "DetDetalle.findByDetId", query = "SELECT d FROM DetDetalle d WHERE d.detId = :detId"),
    @NamedQuery(name = "DetDetalle.findByDetCantidad", query = "SELECT d FROM DetDetalle d WHERE d.detCantidad = :detCantidad"),
    @NamedQuery(name = "DetDetalle.findByDetPrecioTotal", query = "SELECT d FROM DetDetalle d WHERE d.detPrecioTotal = :detPrecioTotal"),
    @NamedQuery(name = "DetDetalle.findByDetVSubtotal", query = "SELECT d FROM DetDetalle d WHERE d.detVSubtotal = :detVSubtotal"),
    @NamedQuery(name = "DetDetalle.findByDetIva", query = "SELECT d FROM DetDetalle d WHERE d.detIva = :detIva"),
    @NamedQuery(name = "DetDetalle.findByDetVTotal", query = "SELECT d FROM DetDetalle d WHERE d.detVTotal = :detVTotal")})
public class DetDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_ID")
    private Integer detId;
    @Column(name = "DET_CANTIDAD")
    private Integer detCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DET_PRECIO_TOTAL")
    private Float detPrecioTotal;
    @Column(name = "DET_V_SUBTOTAL")
    private Float detVSubtotal;
    @Size(max = 5)
    @Column(name = "DET_IVA")
    private String detIva;
    @Column(name = "DET_V_TOTAL")
    private Float detVTotal;
    @JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
    @ManyToOne
    private ProProductos proId;
    @JoinColumn(name = "CAB_ID", referencedColumnName = "CAB_ID")
    @ManyToOne
    private CabCabecera cabId;
    @OneToMany(mappedBy = "detId")
    private Collection<OdtOrdenDeTrabajo> odtOrdenDeTrabajoCollection;

    public DetDetalle() {
    }

    public DetDetalle(Integer detId) {
        this.detId = detId;
    }

    public Integer getDetId() {
        return detId;
    }

    public void setDetId(Integer detId) {
        this.detId = detId;
    }

    public Integer getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(Integer detCantidad) {
        this.detCantidad = detCantidad;
    }

    public Float getDetPrecioTotal() {
        return detPrecioTotal;
    }

    public void setDetPrecioTotal(Float detPrecioTotal) {
        this.detPrecioTotal = detPrecioTotal;
    }

    public Float getDetVSubtotal() {
        return detVSubtotal;
    }

    public void setDetVSubtotal(Float detVSubtotal) {
        this.detVSubtotal = detVSubtotal;
    }

    public String getDetIva() {
        return detIva;
    }

    public void setDetIva(String detIva) {
        this.detIva = detIva;
    }

    public Float getDetVTotal() {
        return detVTotal;
    }

    public void setDetVTotal(Float detVTotal) {
        this.detVTotal = detVTotal;
    }

    public ProProductos getProId() {
        return proId;
    }

    public void setProId(ProProductos proId) {
        this.proId = proId;
    }

    public CabCabecera getCabId() {
        return cabId;
    }

    public void setCabId(CabCabecera cabId) {
        this.cabId = cabId;
    }

    @XmlTransient
    public Collection<OdtOrdenDeTrabajo> getOdtOrdenDeTrabajoCollection() {
        return odtOrdenDeTrabajoCollection;
    }

    public void setOdtOrdenDeTrabajoCollection(Collection<OdtOrdenDeTrabajo> odtOrdenDeTrabajoCollection) {
        this.odtOrdenDeTrabajoCollection = odtOrdenDeTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detId != null ? detId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetDetalle)) {
            return false;
        }
        DetDetalle other = (DetDetalle) object;
        if ((this.detId == null && other.detId != null) || (this.detId != null && !this.detId.equals(other.detId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return detId  + " Cab:" + cabId + " Pro:" + proId;
    }
    
}
