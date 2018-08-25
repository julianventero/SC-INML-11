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
@Table(name = "cliente_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteMunicipio.findAll", query = "SELECT c FROM ClienteMunicipio c")
    , @NamedQuery(name = "ClienteMunicipio.findByIdCLIENTEMUNICIPIO", query = "SELECT c FROM ClienteMunicipio c WHERE c.idCLIENTEMUNICIPIO = :idCLIENTEMUNICIPIO")})
public class ClienteMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCLIENTE_MUNICIPIO")
    private Integer idCLIENTEMUNICIPIO;
    @JoinColumn(name = "CLIENTE_idCLIENTE", referencedColumnName = "idCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cLIENTEidCLIENTE;
    @JoinColumn(name = "MUNICIPIO_idMUNICIPIO", referencedColumnName = "idMUNICIPIO")
    @ManyToOne(optional = false)
    private Municipio mUNICIPIOidMUNICIPIO;

    public ClienteMunicipio() {
    }

    public ClienteMunicipio(Integer idCLIENTEMUNICIPIO) {
        this.idCLIENTEMUNICIPIO = idCLIENTEMUNICIPIO;
    }

    public Integer getIdCLIENTEMUNICIPIO() {
        return idCLIENTEMUNICIPIO;
    }

    public void setIdCLIENTEMUNICIPIO(Integer idCLIENTEMUNICIPIO) {
        this.idCLIENTEMUNICIPIO = idCLIENTEMUNICIPIO;
    }

    public Cliente getCLIENTEidCLIENTE() {
        return cLIENTEidCLIENTE;
    }

    public void setCLIENTEidCLIENTE(Cliente cLIENTEidCLIENTE) {
        this.cLIENTEidCLIENTE = cLIENTEidCLIENTE;
    }

    public Municipio getMUNICIPIOidMUNICIPIO() {
        return mUNICIPIOidMUNICIPIO;
    }

    public void setMUNICIPIOidMUNICIPIO(Municipio mUNICIPIOidMUNICIPIO) {
        this.mUNICIPIOidMUNICIPIO = mUNICIPIOidMUNICIPIO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCLIENTEMUNICIPIO != null ? idCLIENTEMUNICIPIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteMunicipio)) {
            return false;
        }
        ClienteMunicipio other = (ClienteMunicipio) object;
        if ((this.idCLIENTEMUNICIPIO == null && other.idCLIENTEMUNICIPIO != null) || (this.idCLIENTEMUNICIPIO != null && !this.idCLIENTEMUNICIPIO.equals(other.idCLIENTEMUNICIPIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClienteMunicipio[ idCLIENTEMUNICIPIO=" + idCLIENTEMUNICIPIO + " ]";
    }
    
}
