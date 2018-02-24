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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kongf
 */
@Entity
@Table(name = "chq_chequeo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChqChequeo.findAll", query = "SELECT c FROM ChqChequeo c"),
    @NamedQuery(name = "ChqChequeo.findByChqId", query = "SELECT c FROM ChqChequeo c WHERE c.chqId = :chqId"),
    @NamedQuery(name = "ChqChequeo.findByChqFInicial", query = "SELECT c FROM ChqChequeo c WHERE c.chqFInicial = :chqFInicial"),
    @NamedQuery(name = "ChqChequeo.findByChqFFinal", query = "SELECT c FROM ChqChequeo c WHERE c.chqFFinal = :chqFFinal"),
    @NamedQuery(name = "ChqChequeo.findByChqEstado", query = "SELECT c FROM ChqChequeo c WHERE c.chqEstado = :chqEstado"),
    @NamedQuery(name = "ChqChequeo.findByChqDetalle", query = "SELECT c FROM ChqChequeo c WHERE c.chqDetalle = :chqDetalle")})
public class ChqChequeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHQ_ID")
    private Integer chqId;
    @Column(name = "CHQ_F_INICIAL")
    @Temporal(TemporalType.DATE)
    private Date chqFInicial;
    @Column(name = "CHQ_F_FINAL")
    @Temporal(TemporalType.DATE)
    private Date chqFFinal;
    @Column(name = "CHQ_ESTADO")
    private Character chqEstado;
    @Size(max = 1250)
    @Column(name = "CHQ_DETALLE")
    private String chqDetalle;
    @JoinColumn(name = "LDP_ID", referencedColumnName = "LDP_ID")
    @ManyToOne
    private LdpListaDeProblemas ldpId;
    @JoinColumn(name = "CAB_ID", referencedColumnName = "CAB_ID")
    @ManyToOne
    private CabCabecera cabId;

    public ChqChequeo() {
    }

    public ChqChequeo(Integer chqId) {
        this.chqId = chqId;
    }

    public Integer getChqId() {
        return chqId;
    }

    public void setChqId(Integer chqId) {
        this.chqId = chqId;
    }

    public Date getChqFInicial() {
        return chqFInicial;
    }

    public void setChqFInicial(Date chqFInicial) {
        this.chqFInicial = chqFInicial;
    }

    public Date getChqFFinal() {
        return chqFFinal;
    }

    public void setChqFFinal(Date chqFFinal) {
        this.chqFFinal = chqFFinal;
    }

    public Character getChqEstado() {
        return chqEstado;
    }

    public void setChqEstado(Character chqEstado) {
        this.chqEstado = chqEstado;
    }

    public String getChqDetalle() {
        return chqDetalle;
    }

    public void setChqDetalle(String chqDetalle) {
        this.chqDetalle = chqDetalle;
    }

    public LdpListaDeProblemas getLdpId() {
        return ldpId;
    }

    public void setLdpId(LdpListaDeProblemas ldpId) {
        this.ldpId = ldpId;
    }

    public CabCabecera getCabId() {
        return cabId;
    }

    public void setCabId(CabCabecera cabId) {
        this.cabId = cabId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chqId != null ? chqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChqChequeo)) {
            return false;
        }
        ChqChequeo other = (ChqChequeo) object;
        if ((this.chqId == null && other.chqId != null) || (this.chqId != null && !this.chqId.equals(other.chqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return chqId  + " LDP:" + ldpId + " " + chqEstado;
    }
    
}
