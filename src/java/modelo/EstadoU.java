/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "estado_u")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoU.findAll", query = "SELECT e FROM EstadoU e")
    , @NamedQuery(name = "EstadoU.findByIdESTADO", query = "SELECT e FROM EstadoU e WHERE e.idESTADO = :idESTADO")
    , @NamedQuery(name = "EstadoU.findByNombre", query = "SELECT e FROM EstadoU e WHERE e.nombre = :nombre")})
public class EstadoU implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idESTADO")
    private Integer idESTADO;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eSTADOUidESTADO")
    private List<Usuario> usuarioList;

    public EstadoU() {
    }

    public EstadoU(Integer idESTADO) {
        this.idESTADO = idESTADO;
    }

    public Integer getIdESTADO() {
        return idESTADO;
    }

    public void setIdESTADO(Integer idESTADO) {
        this.idESTADO = idESTADO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idESTADO != null ? idESTADO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoU)) {
            return false;
        }
        EstadoU other = (EstadoU) object;
        if ((this.idESTADO == null && other.idESTADO != null) || (this.idESTADO != null && !this.idESTADO.equals(other.idESTADO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoU[ idESTADO=" + idESTADO + " ]";
    }
    
}
