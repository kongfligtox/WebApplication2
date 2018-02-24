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
@Table(name = "rol_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolRoles.findAll", query = "SELECT r FROM RolRoles r"),
    @NamedQuery(name = "RolRoles.findByRolId", query = "SELECT r FROM RolRoles r WHERE r.rolId = :rolId"),
    @NamedQuery(name = "RolRoles.findByRolNombre", query = "SELECT r FROM RolRoles r WHERE r.rolNombre = :rolNombre")})
public class RolRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private Integer rolId;
    @Size(max = 150)
    @Column(name = "ROL_NOMBRE")
    private String rolNombre;
    @OneToMany(mappedBy = "rolId")
    private Collection<UsuUsuarios> usuUsuariosCollection;

    public RolRoles() {
    }

    public RolRoles(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    @XmlTransient
    public Collection<UsuUsuarios> getUsuUsuariosCollection() {
        return usuUsuariosCollection;
    }

    public void setUsuUsuariosCollection(Collection<UsuUsuarios> usuUsuariosCollection) {
        this.usuUsuariosCollection = usuUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolRoles)) {
            return false;
        }
        RolRoles other = (RolRoles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rolId  + " " + rolNombre;
    }
    
}
