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
@Table(name = "encuesta_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaCriterio.findAll", query = "SELECT e FROM EncuestaCriterio e")
    , @NamedQuery(name = "EncuestaCriterio.findByIdENCUESTACRITERIO", query = "SELECT e FROM EncuestaCriterio e WHERE e.idENCUESTACRITERIO = :idENCUESTACRITERIO")})
public class EncuestaCriterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENCUESTA_CRITERIO")
    private Integer idENCUESTACRITERIO;
    @JoinColumn(name = "CRITERIO_idCRITERIO", referencedColumnName = "idCRITERIO")
    @ManyToOne(optional = false)
    private Criterio cRITERIOidCRITERIO;
    @JoinColumn(name = "ENCUESTA_idENCUESTA", referencedColumnName = "idENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta eNCUESTAidENCUESTA;

    public EncuestaCriterio() {
    }

    public EncuestaCriterio(Integer idENCUESTACRITERIO) {
        this.idENCUESTACRITERIO = idENCUESTACRITERIO;
    }

    public Integer getIdENCUESTACRITERIO() {
        return idENCUESTACRITERIO;
    }

    public void setIdENCUESTACRITERIO(Integer idENCUESTACRITERIO) {
        this.idENCUESTACRITERIO = idENCUESTACRITERIO;
    }

    public Criterio getCRITERIOidCRITERIO() {
        return cRITERIOidCRITERIO;
    }

    public void setCRITERIOidCRITERIO(Criterio cRITERIOidCRITERIO) {
        this.cRITERIOidCRITERIO = cRITERIOidCRITERIO;
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
        hash += (idENCUESTACRITERIO != null ? idENCUESTACRITERIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaCriterio)) {
            return false;
        }
        EncuestaCriterio other = (EncuestaCriterio) object;
        if ((this.idENCUESTACRITERIO == null && other.idENCUESTACRITERIO != null) || (this.idENCUESTACRITERIO != null && !this.idENCUESTACRITERIO.equals(other.idENCUESTACRITERIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EncuestaCriterio[ idENCUESTACRITERIO=" + idENCUESTACRITERIO + " ]";
    }
    
}
