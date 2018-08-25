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
@Table(name = "encuesta_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaCliente.findAll", query = "SELECT e FROM EncuestaCliente e")
    , @NamedQuery(name = "EncuestaCliente.findByIdENCUESTACLIENTE", query = "SELECT e FROM EncuestaCliente e WHERE e.idENCUESTACLIENTE = :idENCUESTACLIENTE")})
public class EncuestaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENCUESTA_CLIENTE")
    private Integer idENCUESTACLIENTE;
    @JoinColumn(name = "CLIENTE_idCLIENTE", referencedColumnName = "idCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cLIENTEidCLIENTE;
    @JoinColumn(name = "ENCUESTA_idENCUESTA", referencedColumnName = "idENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta eNCUESTAidENCUESTA;

    public EncuestaCliente() {
    }

    public EncuestaCliente(Integer idENCUESTACLIENTE) {
        this.idENCUESTACLIENTE = idENCUESTACLIENTE;
    }

    public Integer getIdENCUESTACLIENTE() {
        return idENCUESTACLIENTE;
    }

    public void setIdENCUESTACLIENTE(Integer idENCUESTACLIENTE) {
        this.idENCUESTACLIENTE = idENCUESTACLIENTE;
    }

    public Cliente getCLIENTEidCLIENTE() {
        return cLIENTEidCLIENTE;
    }

    public void setCLIENTEidCLIENTE(Cliente cLIENTEidCLIENTE) {
        this.cLIENTEidCLIENTE = cLIENTEidCLIENTE;
    }

    public Encuesta getENCUESTAidENCUESTA() {
        return eNCUESTAidENCUESTA;
    }

    public void setENCUESTAidENCUESTA(Encuesta eNCUESTAidENCUESTA) {
        this.eNCUESTAidENCUESTA = eNCUESTAidENCUESTA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idENCUESTACLIENTE != null ? idENCUESTACLIENTE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaCliente)) {
            return false;
        }
        EncuestaCliente other = (EncuestaCliente) object;
        if ((this.idENCUESTACLIENTE == null && other.idENCUESTACLIENTE != null) || (this.idENCUESTACLIENTE != null && !this.idENCUESTACLIENTE.equals(other.idENCUESTACLIENTE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EncuestaCliente[ idENCUESTACLIENTE=" + idENCUESTACLIENTE + " ]";
    }
    
}
