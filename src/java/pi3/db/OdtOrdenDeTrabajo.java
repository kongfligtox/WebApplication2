/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi3.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kongf
 */
@Entity
@Table(name = "odt_orden_de_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdtOrdenDeTrabajo.findAll", query = "SELECT o FROM OdtOrdenDeTrabajo o"),
    @NamedQuery(name = "OdtOrdenDeTrabajo.findByOdtId", query = "SELECT o FROM OdtOrdenDeTrabajo o WHERE o.odtId = :odtId"),
    @NamedQuery(name = "OdtOrdenDeTrabajo.findByOdtFInicio", query = "SELECT o FROM OdtOrdenDeTrabajo o WHERE o.odtFInicio = :odtFInicio"),
    @NamedQuery(name = "OdtOrdenDeTrabajo.findByOdtEstado", query = "SELECT o FROM OdtOrdenDeTrabajo o WHERE o.odtEstado = :odtEstado"),
    @NamedQuery(name = "OdtOrdenDeTrabajo.findByOdtFFinal", query = "SELECT o FROM OdtOrdenDeTrabajo o WHERE o.odtFFinal = :odtFFinal")})
public class OdtOrdenDeTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ODT_ID")
    private Integer odtId;
    @Column(name = "ODT_F_INICIO")
    @Temporal(TemporalType.DATE)
    private Date odtFInicio;
    @Column(name = "ODT_ESTADO")
    private Character odtEstado;
    @Column(name = "ODT_F_FINAL")
    @Temporal(TemporalType.DATE)
    private Date odtFFinal;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne
    private PerPersonal perId;
    @JoinColumn(name = "DET_ID", referencedColumnName = "DET_ID")
    @ManyToOne
    private DetDetalle detId;

    public OdtOrdenDeTrabajo() {
    }

    public OdtOrdenDeTrabajo(Integer odtId) {
        this.odtId = odtId;
    }

    public Integer getOdtId() {
        return odtId;
    }

    public void setOdtId(Integer odtId) {
        this.odtId = odtId;
    }

    public Date getOdtFInicio() {
        return odtFInicio;
    }

    public void setOdtFInicio(Date odtFInicio) {
        this.odtFInicio = odtFInicio;
    }

    public Character getOdtEstado() {
        return odtEstado;
    }

    public void setOdtEstado(Character odtEstado) {
        this.odtEstado = odtEstado;
    }

    public Date getOdtFFinal() {
        return odtFFinal;
    }

    public void setOdtFFinal(Date odtFFinal) {
        this.odtFFinal = odtFFinal;
    }

    public PerPersonal getPerId() {
        return perId;
    }

    public void setPerId(PerPersonal perId) {
        this.perId = perId;
    }

    public DetDetalle getDetId() {
        return detId;
    }

    public void setDetId(DetDetalle detId) {
        this.detId = detId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odtId != null ? odtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdtOrdenDeTrabajo)) {
            return false;
        }
        OdtOrdenDeTrabajo other = (OdtOrdenDeTrabajo) object;
        if ((this.odtId == null && other.odtId != null) || (this.odtId != null && !this.odtId.equals(other.odtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return odtId  + " Per:" + perId + " Det:" + detId;
    }
    
}
