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
@Table(name = "encuesta_aspecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaAspecto.findAll", query = "SELECT e FROM EncuestaAspecto e")
    , @NamedQuery(name = "EncuestaAspecto.findByIdENCUESTAASPECTO", query = "SELECT e FROM EncuestaAspecto e WHERE e.idENCUESTAASPECTO = :idENCUESTAASPECTO")})
public class EncuestaAspecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENCUESTA_ASPECTO")
    private Integer idENCUESTAASPECTO;
    @JoinColumn(name = "ASPECTO_idASPECTO", referencedColumnName = "idASPECTO")
    @ManyToOne
    private Aspecto aSPECTOidASPECTO;
    @JoinColumn(name = "ENCUESTA_idENCUESTA", referencedColumnName = "idENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta eNCUESTAidENCUESTA;

    public EncuestaAspecto() {
    }

    public EncuestaAspecto(Integer idENCUESTAASPECTO) {
        this.idENCUESTAASPECTO = idENCUESTAASPECTO;
    }

    public Integer getIdENCUESTAASPECTO() {
        return idENCUESTAASPECTO;
    }

    public void setIdENCUESTAASPECTO(Integer idENCUESTAASPECTO) {
        this.idENCUESTAASPECTO = idENCUESTAASPECTO;
    }

    public Aspecto getASPECTOidASPECTO() {
        return aSPECTOidASPECTO;
    }

    public void setASPECTOidASPECTO(Aspecto aSPECTOidASPECTO) {
        this.aSPECTOidASPECTO = aSPECTOidASPECTO;
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
        hash += (idENCUESTAASPECTO != null ? idENCUESTAASPECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaAspecto)) {
            return false;
        }
        EncuestaAspecto other = (EncuestaAspecto) object;
        if ((this.idENCUESTAASPECTO == null && other.idENCUESTAASPECTO != null) || (this.idENCUESTAASPECTO != null && !this.idENCUESTAASPECTO.equals(other.idENCUESTAASPECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EncuestaAspecto[ idENCUESTAASPECTO=" + idENCUESTAASPECTO + " ]";
    }
    
}
