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
@Table(name = "per_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerPersonal.findAll", query = "SELECT p FROM PerPersonal p"),
    @NamedQuery(name = "PerPersonal.findByPerId", query = "SELECT p FROM PerPersonal p WHERE p.perId = :perId"),
    @NamedQuery(name = "PerPersonal.findByPerNombres", query = "SELECT p FROM PerPersonal p WHERE p.perNombres = :perNombres"),
    @NamedQuery(name = "PerPersonal.findByPerApellidos", query = "SELECT p FROM PerPersonal p WHERE p.perApellidos = :perApellidos"),
    @NamedQuery(name = "PerPersonal.findByPerCid", query = "SELECT p FROM PerPersonal p WHERE p.perCid = :perCid"),
    @NamedQuery(name = "PerPersonal.findByPerTelefonos", query = "SELECT p FROM PerPersonal p WHERE p.perTelefonos = :perTelefonos"),
    @NamedQuery(name = "PerPersonal.findByPerEmail", query = "SELECT p FROM PerPersonal p WHERE p.perEmail = :perEmail"),
    @NamedQuery(name = "PerPersonal.findByPerDireccion", query = "SELECT p FROM PerPersonal p WHERE p.perDireccion = :perDireccion")})
public class PerPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private Integer perId;
    @Size(max = 80)
    @Column(name = "PER_NOMBRES")
    private String perNombres;
    @Size(max = 80)
    @Column(name = "PER_APELLIDOS")
    private String perApellidos;
    @Size(max = 25)
    @Column(name = "PER_CID")
    private String perCid;
    @Size(max = 25)
    @Column(name = "PER_TELEFONOS")
    private String perTelefonos;
    @Size(max = 150)
    @Column(name = "PER_EMAIL")
    private String perEmail;
    @Size(max = 1250)
    @Column(name = "PER_DIRECCION")
    private String perDireccion;
    @OneToMany(mappedBy = "perId")
    private Collection<OdtOrdenDeTrabajo> odtOrdenDeTrabajoCollection;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne
    private UsuUsuarios usuId;

    public PerPersonal() {
    }

    public PerPersonal(Integer perId) {
        this.perId = perId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerCid() {
        return perCid;
    }

    public void setPerCid(String perCid) {
        this.perCid = perCid;
    }

    public String getPerTelefonos() {
        return perTelefonos;
    }

    public void setPerTelefonos(String perTelefonos) {
        this.perTelefonos = perTelefonos;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    @XmlTransient
    public Collection<OdtOrdenDeTrabajo> getOdtOrdenDeTrabajoCollection() {
        return odtOrdenDeTrabajoCollection;
    }

    public void setOdtOrdenDeTrabajoCollection(Collection<OdtOrdenDeTrabajo> odtOrdenDeTrabajoCollection) {
        this.odtOrdenDeTrabajoCollection = odtOrdenDeTrabajoCollection;
    }

    public UsuUsuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(UsuUsuarios usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerPersonal)) {
            return false;
        }
        PerPersonal other = (PerPersonal) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return perId  + " " + perApellidos + " " + perNombres;
    }
    
}
