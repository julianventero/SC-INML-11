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
@Table(name = "cliente_seccional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteSeccional.findAll", query = "SELECT c FROM ClienteSeccional c")
    , @NamedQuery(name = "ClienteSeccional.findByIdCLIENTESECCIONAL", query = "SELECT c FROM ClienteSeccional c WHERE c.idCLIENTESECCIONAL = :idCLIENTESECCIONAL")})
public class ClienteSeccional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCLIENTE_SECCIONAL")
    private Integer idCLIENTESECCIONAL;
    @JoinColumn(name = "CLIENTE_idCLIENTE", referencedColumnName = "idCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cLIENTEidCLIENTE;
    @JoinColumn(name = "SECCIONAL_idSECCIONAL", referencedColumnName = "idSECCIONAL")
    @ManyToOne(optional = false)
    private Seccional sECCIONALidSECCIONAL;

    public ClienteSeccional() {
    }

    public ClienteSeccional(Integer idCLIENTESECCIONAL) {
        this.idCLIENTESECCIONAL = idCLIENTESECCIONAL;
    }

    public Integer getIdCLIENTESECCIONAL() {
        return idCLIENTESECCIONAL;
    }

    public void setIdCLIENTESECCIONAL(Integer idCLIENTESECCIONAL) {
        this.idCLIENTESECCIONAL = idCLIENTESECCIONAL;
    }

    public Cliente getCLIENTEidCLIENTE() {
        return cLIENTEidCLIENTE;
    }

    public void setCLIENTEidCLIENTE(Cliente cLIENTEidCLIENTE) {
        this.cLIENTEidCLIENTE = cLIENTEidCLIENTE;
    }

    public Seccional getSECCIONALidSECCIONAL() {
        return sECCIONALidSECCIONAL;
    }

    public void setSECCIONALidSECCIONAL(Seccional sECCIONALidSECCIONAL) {
        this.sECCIONALidSECCIONAL = sECCIONALidSECCIONAL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCLIENTESECCIONAL != null ? idCLIENTESECCIONAL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteSeccional)) {
            return false;
        }
        ClienteSeccional other = (ClienteSeccional) object;
        if ((this.idCLIENTESECCIONAL == null && other.idCLIENTESECCIONAL != null) || (this.idCLIENTESECCIONAL != null && !this.idCLIENTESECCIONAL.equals(other.idCLIENTESECCIONAL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClienteSeccional[ idCLIENTESECCIONAL=" + idCLIENTESECCIONAL + " ]";
    }
    
}
