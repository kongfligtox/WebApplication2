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
@Table(name = "veh_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehVehiculos.findAll", query = "SELECT v FROM VehVehiculos v"),
    @NamedQuery(name = "VehVehiculos.findByVehId", query = "SELECT v FROM VehVehiculos v WHERE v.vehId = :vehId"),
    @NamedQuery(name = "VehVehiculos.findByVehMarca", query = "SELECT v FROM VehVehiculos v WHERE v.vehMarca = :vehMarca"),
    @NamedQuery(name = "VehVehiculos.findByVehModelo", query = "SELECT v FROM VehVehiculos v WHERE v.vehModelo = :vehModelo"),
    @NamedQuery(name = "VehVehiculos.findByVehAno", query = "SELECT v FROM VehVehiculos v WHERE v.vehAno = :vehAno"),
    @NamedQuery(name = "VehVehiculos.findByVehNMotor", query = "SELECT v FROM VehVehiculos v WHERE v.vehNMotor = :vehNMotor"),
    @NamedQuery(name = "VehVehiculos.findByVehMatricula", query = "SELECT v FROM VehVehiculos v WHERE v.vehMatricula = :vehMatricula"),
    @NamedQuery(name = "VehVehiculos.findByVehColor", query = "SELECT v FROM VehVehiculos v WHERE v.vehColor = :vehColor"),
    @NamedQuery(name = "VehVehiculos.findByVehPlaca", query = "SELECT v FROM VehVehiculos v WHERE v.vehPlaca = :vehPlaca")})
public class VehVehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEH_ID")
    private Integer vehId;
    @Size(max = 80)
    @Column(name = "VEH_MARCA")
    private String vehMarca;
    @Size(max = 80)
    @Column(name = "VEH_MODELO")
    private String vehModelo;
    @Size(max = 4)
    @Column(name = "VEH_ANO")
    private String vehAno;
    @Size(max = 50)
    @Column(name = "VEH_N_MOTOR")
    private String vehNMotor;
    @Size(max = 50)
    @Column(name = "VEH_MATRICULA")
    private String vehMatricula;
    @Size(max = 50)
    @Column(name = "VEH_COLOR")
    private String vehColor;
    @Size(max = 8)
    @Column(name = "VEH_PLACA")
    private String vehPlaca;
    @OneToMany(mappedBy = "vehId")
    private Collection<CabCabecera> cabCabeceraCollection;

    public VehVehiculos() {
    }

    public VehVehiculos(Integer vehId) {
        this.vehId = vehId;
    }

    public Integer getVehId() {
        return vehId;
    }

    public void setVehId(Integer vehId) {
        this.vehId = vehId;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehAno() {
        return vehAno;
    }

    public void setVehAno(String vehAno) {
        this.vehAno = vehAno;
    }

    public String getVehNMotor() {
        return vehNMotor;
    }

    public void setVehNMotor(String vehNMotor) {
        this.vehNMotor = vehNMotor;
    }

    public String getVehMatricula() {
        return vehMatricula;
    }

    public void setVehMatricula(String vehMatricula) {
        this.vehMatricula = vehMatricula;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    @XmlTransient
    public Collection<CabCabecera> getCabCabeceraCollection() {
        return cabCabeceraCollection;
    }

    public void setCabCabeceraCollection(Collection<CabCabecera> cabCabeceraCollection) {
        this.cabCabeceraCollection = cabCabeceraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehId != null ? vehId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehVehiculos)) {
            return false;
        }
        VehVehiculos other = (VehVehiculos) object;
        if ((this.vehId == null && other.vehId != null) || (this.vehId != null && !this.vehId.equals(other.vehId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return vehId + " " + vehPlaca + " " + vehMarca;
    }
    
}
