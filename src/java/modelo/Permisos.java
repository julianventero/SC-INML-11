/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByIdPERMISOS", query = "SELECT p FROM Permisos p WHERE p.idPERMISOS = :idPERMISOS")
    , @NamedQuery(name = "Permisos.findByNombre", query = "SELECT p FROM Permisos p WHERE p.nombre = :nombre")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPERMISOS")
    private Integer idPERMISOS;
    @Size(max = 10)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "permisos_usuario", joinColumns = {
        @JoinColumn(name = "PERMISOS_idPERMISOS", referencedColumnName = "idPERMISOS")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO_cedula", referencedColumnName = "cedula")})
    @ManyToMany
    private List<Usuario> usuarioList;

    public Permisos() {
    }

    public Permisos(Integer idPERMISOS) {
        this.idPERMISOS = idPERMISOS;
    }

    public Integer getIdPERMISOS() {
        return idPERMISOS;
    }

    public void setIdPERMISOS(Integer idPERMISOS) {
        this.idPERMISOS = idPERMISOS;
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
        hash += (idPERMISOS != null ? idPERMISOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPERMISOS == null && other.idPERMISOS != null) || (this.idPERMISOS != null && !this.idPERMISOS.equals(other.idPERMISOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Permisos[ idPERMISOS=" + idPERMISOS + " ]";
    }
    
}
