/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi3.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kongf
 */
@Entity
@Table(name = "cab_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabCabecera.findAll", query = "SELECT c FROM CabCabecera c"),
    @NamedQuery(name = "CabCabecera.findByCabId", query = "SELECT c FROM CabCabecera c WHERE c.cabId = :cabId"),
    @NamedQuery(name = "CabCabecera.findByCabTipo", query = "SELECT c FROM CabCabecera c WHERE c.cabTipo = :cabTipo"),
    @NamedQuery(name = "CabCabecera.findByCabNombre", query = "SELECT c FROM CabCabecera c WHERE c.cabNombre = :cabNombre"),
    @NamedQuery(name = "CabCabecera.findByCabFecha", query = "SELECT c FROM CabCabecera c WHERE c.cabFecha = :cabFecha"),
    @NamedQuery(name = "CabCabecera.findByCabRuc", query = "SELECT c FROM CabCabecera c WHERE c.cabRuc = :cabRuc"),
    @NamedQuery(name = "CabCabecera.findByCabTelefonos", query = "SELECT c FROM CabCabecera c WHERE c.cabTelefonos = :cabTelefonos"),
    @NamedQuery(name = "CabCabecera.findByCabEmail", query = "SELECT c FROM CabCabecera c WHERE c.cabEmail = :cabEmail"),
    @NamedQuery(name = "CabCabecera.findByCabDireccion", query = "SELECT c FROM CabCabecera c WHERE c.cabDireccion = :cabDireccion")})
public class CabCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAB_ID")
    private Integer cabId;
    @Size(max = 50)
    @Column(name = "CAB_TIPO")
    private String cabTipo;
    @Size(max = 250)
    @Column(name = "CAB_NOMBRE")
    private String cabNombre;
    @Column(name = "CAB_FECHA")
    @Temporal(TemporalType.DATE)
    private Date cabFecha;
    @Size(max = 20)
    @Column(name = "CAB_RUC")
    private String cabRuc;
    @Size(max = 25)
    @Column(name = "CAB_TELEFONOS")
    private String cabTelefonos;
    @Size(max = 150)
    @Column(name = "CAB_EMAIL")
    private String cabEmail;
    @Size(max = 250)
    @Column(name = "CAB_DIRECCION")
    private String cabDireccion;
    @OneToMany(mappedBy = "cabId")
    private Collection<DetDetalle> detDetalleCollection;
    @OneToMany(mappedBy = "cabId")
    private Collection<ChqChequeo> chqChequeoCollection;
    @JoinColumn(name = "VEH_ID", referencedColumnName = "VEH_ID")
    @ManyToOne
    private VehVehiculos vehId;
    @JoinColumn(name = "CLI_ID", referencedColumnName = "CLI_ID")
    @ManyToOne
    private CliClientes cliId;

    public CabCabecera() {
    }

    public CabCabecera(Integer cabId) {
        this.cabId = cabId;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public String getCabTipo() {
        return cabTipo;
    }

    public void setCabTipo(String cabTipo) {
        this.cabTipo = cabTipo;
    }

    public String getCabNombre() {
        return cabNombre;
    }

    public void setCabNombre(String cabNombre) {
        this.cabNombre = cabNombre;
    }

    public Date getCabFecha() {
        return cabFecha;
    }

    public void setCabFecha(Date cabFecha) {
        this.cabFecha = cabFecha;
    }

    public String getCabRuc() {
        return cabRuc;
    }

    public void setCabRuc(String cabRuc) {
        this.cabRuc = cabRuc;
    }

    public String getCabTelefonos() {
        return cabTelefonos;
    }

    public void setCabTelefonos(String cabTelefonos) {
        this.cabTelefonos = cabTelefonos;
    }

    public String getCabEmail() {
        return cabEmail;
    }

    public void setCabEmail(String cabEmail) {
        this.cabEmail = cabEmail;
    }

    public String getCabDireccion() {
        return cabDireccion;
    }

    public void setCabDireccion(String cabDireccion) {
        this.cabDireccion = cabDireccion;
    }

    @XmlTransient
    public Collection<DetDetalle> getDetDetalleCollection() {
        return detDetalleCollection;
    }

    public void setDetDetalleCollection(Collection<DetDetalle> detDetalleCollection) {
        this.detDetalleCollection = detDetalleCollection;
    }

    @XmlTransient
    public Collection<ChqChequeo> getChqChequeoCollection() {
        return chqChequeoCollection;
    }

    public void setChqChequeoCollection(Collection<ChqChequeo> chqChequeoCollection) {
        this.chqChequeoCollection = chqChequeoCollection;
    }

    public VehVehiculos getVehId() {
        return vehId;
    }

    public void setVehId(VehVehiculos vehId) {
        this.vehId = vehId;
    }

    public CliClientes getCliId() {
        return cliId;
    }

    public void setCliId(CliClientes cliId) {
        this.cliId = cliId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabId != null ? cabId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabCabecera)) {
            return false;
        }
        CabCabecera other = (CabCabecera) object;
        if ((this.cabId == null && other.cabId != null) || (this.cabId != null && !this.cabId.equals(other.cabId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cabId + " " + cabTipo + " " + cabNombre ;
    }
    
}
