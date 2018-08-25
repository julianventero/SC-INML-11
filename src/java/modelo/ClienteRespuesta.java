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
@Table(name = "cliente_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteRespuesta.findAll", query = "SELECT c FROM ClienteRespuesta c")
    , @NamedQuery(name = "ClienteRespuesta.findByIdCLIENTERESPUESTA", query = "SELECT c FROM ClienteRespuesta c WHERE c.idCLIENTERESPUESTA = :idCLIENTERESPUESTA")})
public class ClienteRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCLIENTE_RESPUESTA")
    private Integer idCLIENTERESPUESTA;
    @JoinColumn(name = "CLIENTE_idCLIENTE", referencedColumnName = "idCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cLIENTEidCLIENTE;
    @JoinColumn(name = "RESPUESTA_idRESPUESTA", referencedColumnName = "idRESPUESTA")
    @ManyToOne(optional = false)
    private Respuesta rESPUESTAidRESPUESTA;

    public ClienteRespuesta() {
    }

    public ClienteRespuesta(Integer idCLIENTERESPUESTA) {
        this.idCLIENTERESPUESTA = idCLIENTERESPUESTA;
    }

    public Integer getIdCLIENTERESPUESTA() {
        return idCLIENTERESPUESTA;
    }

    public void setIdCLIENTERESPUESTA(Integer idCLIENTERESPUESTA) {
        this.idCLIENTERESPUESTA = idCLIENTERESPUESTA;
    }

    public Cliente getCLIENTEidCLIENTE() {
        return cLIENTEidCLIENTE;
    }

    public void setCLIENTEidCLIENTE(Cliente cLIENTEidCLIENTE) {
        this.cLIENTEidCLIENTE = cLIENTEidCLIENTE;
    }

    public Respuesta getRESPUESTAidRESPUESTA() {
        return rESPUESTAidRESPUESTA;
    }

    public void setRESPUESTAidRESPUESTA(Respuesta rESPUESTAidRESPUESTA) {
        this.rESPUESTAidRESPUESTA = rESPUESTAidRESPUESTA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCLIENTERESPUESTA != null ? idCLIENTERESPUESTA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteRespuesta)) {
            return false;
        }
        ClienteRespuesta other = (ClienteRespuesta) object;
        if ((this.idCLIENTERESPUESTA == null && other.idCLIENTERESPUESTA != null) || (this.idCLIENTERESPUESTA != null && !this.idCLIENTERESPUESTA.equals(other.idCLIENTERESPUESTA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClienteRespuesta[ idCLIENTERESPUESTA=" + idCLIENTERESPUESTA + " ]";
    }
    
}
