/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "cliente_regional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteRegional.findAll", query = "SELECT c FROM ClienteRegional c")
    , @NamedQuery(name = "ClienteRegional.findByIdCLIENTEREGIONAL", query = "SELECT c FROM ClienteRegional c WHERE c.idCLIENTEREGIONAL = :idCLIENTEREGIONAL")})
public class ClienteRegional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCLIENTE_REGIONAL")
    private Integer idCLIENTEREGIONAL;
    @JoinColumn(name = "CLIENTE_idCLIENTE", referencedColumnName = "idCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cLIENTEidCLIENTE;
    @JoinColumn(name = "REGIONAL_idREGIONAL", referencedColumnName = "idREGIONAL")
    @ManyToOne(optional = false)
    private Regional rEGIONALidREGIONAL;

    public ClienteRegional() {
    }

    public ClienteRegional(Integer idCLIENTEREGIONAL) {
        this.idCLIENTEREGIONAL = idCLIENTEREGIONAL;
    }

    public Integer getIdCLIENTEREGIONAL() {
        return idCLIENTEREGIONAL;
    }

    public void setIdCLIENTEREGIONAL(Integer idCLIENTEREGIONAL) {
        this.idCLIENTEREGIONAL = idCLIENTEREGIONAL;
    }

    public Cliente getCLIENTEidCLIENTE() {
        return cLIENTEidCLIENTE;
    }

    public void setCLIENTEidCLIENTE(Cliente cLIENTEidCLIENTE) {
        this.cLIENTEidCLIENTE = cLIENTEidCLIENTE;
    }

    public Regional getREGIONALidREGIONAL() {
        return rEGIONALidREGIONAL;
    }

    public void setREGIONALidREGIONAL(Regional rEGIONALidREGIONAL) {
        this.rEGIONALidREGIONAL = rEGIONALidREGIONAL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCLIENTEREGIONAL != null ? idCLIENTEREGIONAL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteRegional)) {
            return false;
        }
        ClienteRegional other = (ClienteRegional) object;
        if ((this.idCLIENTEREGIONAL == null && other.idCLIENTEREGIONAL != null) || (this.idCLIENTEREGIONAL != null && !this.idCLIENTEREGIONAL.equals(other.idCLIENTEREGIONAL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClienteRegional[ idCLIENTEREGIONAL=" + idCLIENTEREGIONAL + " ]";
    }
    
}
