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
@Table(name = "seccional_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeccionalCriterio.findAll", query = "SELECT s FROM SeccionalCriterio s")
    , @NamedQuery(name = "SeccionalCriterio.findByIdSECCIONALCRITERIO", query = "SELECT s FROM SeccionalCriterio s WHERE s.idSECCIONALCRITERIO = :idSECCIONALCRITERIO")})
public class SeccionalCriterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSECCIONAL_CRITERIO")
    private Integer idSECCIONALCRITERIO;
    @JoinColumn(name = "CRITERIO_idCRITERIO", referencedColumnName = "idCRITERIO")
    @ManyToOne(optional = false)
    private Criterio cRITERIOidCRITERIO;
    @JoinColumn(name = "SECCIONAL_idSECCIONAL", referencedColumnName = "idSECCIONAL")
    @ManyToOne(optional = false)
    private Seccional sECCIONALidSECCIONAL;

    public SeccionalCriterio() {
    }

    public SeccionalCriterio(Integer idSECCIONALCRITERIO) {
        this.idSECCIONALCRITERIO = idSECCIONALCRITERIO;
    }

    public Integer getIdSECCIONALCRITERIO() {
        return idSECCIONALCRITERIO;
    }

    public void setIdSECCIONALCRITERIO(Integer idSECCIONALCRITERIO) {
        this.idSECCIONALCRITERIO = idSECCIONALCRITERIO;
    }

    public Criterio getCRITERIOidCRITERIO() {
        return cRITERIOidCRITERIO;
    }

    public void setCRITERIOidCRITERIO(Criterio cRITERIOidCRITERIO) {
        this.cRITERIOidCRITERIO = cRITERIOidCRITERIO;
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
        hash += (idSECCIONALCRITERIO != null ? idSECCIONALCRITERIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionalCriterio)) {
            return false;
        }
        SeccionalCriterio other = (SeccionalCriterio) object;
        if ((this.idSECCIONALCRITERIO == null && other.idSECCIONALCRITERIO != null) || (this.idSECCIONALCRITERIO != null && !this.idSECCIONALCRITERIO.equals(other.idSECCIONALCRITERIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeccionalCriterio[ idSECCIONALCRITERIO=" + idSECCIONALCRITERIO + " ]";
    }
    
}
