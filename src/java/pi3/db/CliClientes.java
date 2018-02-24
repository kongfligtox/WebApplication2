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
@Table(name = "cli_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CliClientes.findAll", query = "SELECT c FROM CliClientes c"),
    @NamedQuery(name = "CliClientes.findByCliId", query = "SELECT c FROM CliClientes c WHERE c.cliId = :cliId"),
    @NamedQuery(name = "CliClientes.findByCliNombres", query = "SELECT c FROM CliClientes c WHERE c.cliNombres = :cliNombres"),
    @NamedQuery(name = "CliClientes.findByCliApellidos", query = "SELECT c FROM CliClientes c WHERE c.cliApellidos = :cliApellidos"),
    @NamedQuery(name = "CliClientes.findByCliCidRuc", query = "SELECT c FROM CliClientes c WHERE c.cliCidRuc = :cliCidRuc"),
    @NamedQuery(name = "CliClientes.findByCliTelefonos", query = "SELECT c FROM CliClientes c WHERE c.cliTelefonos = :cliTelefonos"),
    @NamedQuery(name = "CliClientes.findByCliEmail", query = "SELECT c FROM CliClientes c WHERE c.cliEmail = :cliEmail"),
    @NamedQuery(name = "CliClientes.findByCliDireccion", query = "SELECT c FROM CliClientes c WHERE c.cliDireccion = :cliDireccion")})
public class CliClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_ID")
    private Integer cliId;
    @Size(max = 50)
    @Column(name = "CLI_NOMBRES")
    private String cliNombres;
    @Size(max = 50)
    @Column(name = "CLI_APELLIDOS")
    private String cliApellidos;
    @Size(max = 20)
    @Column(name = "CLI_CID_RUC")
    private String cliCidRuc;
    @Size(max = 25)
    @Column(name = "CLI_TELEFONOS")
    private String cliTelefonos;
    @Size(max = 150)
    @Column(name = "CLI_EMAIL")
    private String cliEmail;
    @Size(max = 500)
    @Column(name = "CLI_DIRECCION")
    private String cliDireccion;
    @OneToMany(mappedBy = "cliId")
    private Collection<CabCabecera> cabCabeceraCollection;

    public CliClientes() {
    }

    public CliClientes(Integer cliId) {
        this.cliId = cliId;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliCidRuc() {
        return cliCidRuc;
    }

    public void setCliCidRuc(String cliCidRuc) {
        this.cliCidRuc = cliCidRuc;
    }

    public String getCliTelefonos() {
        return cliTelefonos;
    }

    public void setCliTelefonos(String cliTelefonos) {
        this.cliTelefonos = cliTelefonos;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
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
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CliClientes)) {
            return false;
        }
        CliClientes other = (CliClientes) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cliId  + " " + cliApellidos + " " + cliNombres;
    }
    
}
