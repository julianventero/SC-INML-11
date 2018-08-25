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
@Table(name = "seccional_aspecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeccionalAspecto.findAll", query = "SELECT s FROM SeccionalAspecto s")
    , @NamedQuery(name = "SeccionalAspecto.findByIdSECCIONALASPECTO", query = "SELECT s FROM SeccionalAspecto s WHERE s.idSECCIONALASPECTO = :idSECCIONALASPECTO")})
public class SeccionalAspecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSECCIONAL_ASPECTO")
    private Integer idSECCIONALASPECTO;
    @JoinColumn(name = "ASPECTO_idASPECTO", referencedColumnName = "idASPECTO")
    @ManyToOne(optional = false)
    private Aspecto aSPECTOidASPECTO;
    @JoinColumn(name = "SECCIONAL_idSECCIONAL", referencedColumnName = "idSECCIONAL")
    @ManyToOne(optional = false)
    private Seccional sECCIONALidSECCIONAL;

    public SeccionalAspecto() {
    }

    public SeccionalAspecto(Integer idSECCIONALASPECTO) {
        this.idSECCIONALASPECTO = idSECCIONALASPECTO;
    }

    public Integer getIdSECCIONALASPECTO() {
        return idSECCIONALASPECTO;
    }

    public void setIdSECCIONALASPECTO(Integer idSECCIONALASPECTO) {
        this.idSECCIONALASPECTO = idSECCIONALASPECTO;
    }

    public Aspecto getASPECTOidASPECTO() {
        return aSPECTOidASPECTO;
    }

    public void setASPECTOidASPECTO(Aspecto aSPECTOidASPECTO) {
        this.aSPECTOidASPECTO = aSPECTOidASPECTO;
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
        hash += (idSECCIONALASPECTO != null ? idSECCIONALASPECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionalAspecto)) {
            return false;
        }
        SeccionalAspecto other = (SeccionalAspecto) object;
        if ((this.idSECCIONALASPECTO == null && other.idSECCIONALASPECTO != null) || (this.idSECCIONALASPECTO != null && !this.idSECCIONALASPECTO.equals(other.idSECCIONALASPECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeccionalAspecto[ idSECCIONALASPECTO=" + idSECCIONALASPECTO + " ]";
    }
    
}
