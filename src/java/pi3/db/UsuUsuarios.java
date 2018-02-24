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
@Table(name = "usu_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuUsuarios.findAll", query = "SELECT u FROM UsuUsuarios u"),
    @NamedQuery(name = "UsuUsuarios.findByUsuId", query = "SELECT u FROM UsuUsuarios u WHERE u.usuId = :usuId"),
    @NamedQuery(name = "UsuUsuarios.findByUsuUsuario", query = "SELECT u FROM UsuUsuarios u WHERE u.usuUsuario = :usuUsuario"),
    @NamedQuery(name = "UsuUsuarios.findByUsuClave", query = "SELECT u FROM UsuUsuarios u WHERE u.usuClave = :usuClave")})
public class UsuUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private Integer usuId;
    @Size(max = 16)
    @Column(name = "USU_USUARIO")
    private String usuUsuario;
    @Size(max = 20)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")
    @ManyToOne
    private RolRoles rolId;
    @OneToMany(mappedBy = "usuId")
    private Collection<PerPersonal> perPersonalCollection;

    public UsuUsuarios() {
    }

    public UsuUsuarios(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public RolRoles getRolId() {
        return rolId;
    }

    public void setRolId(RolRoles rolId) {
        this.rolId = rolId;
    }

    @XmlTransient
    public Collection<PerPersonal> getPerPersonalCollection() {
        return perPersonalCollection;
    }

    public void setPerPersonalCollection(Collection<PerPersonal> perPersonalCollection) {
        this.perPersonalCollection = perPersonalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuUsuarios)) {
            return false;
        }
        UsuUsuarios other = (UsuUsuarios) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuId  + " " + usuUsuario;
    }
    
}
