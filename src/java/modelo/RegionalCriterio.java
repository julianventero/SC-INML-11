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
@Table(name = "regional_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegionalCriterio.findAll", query = "SELECT r FROM RegionalCriterio r")
    , @NamedQuery(name = "RegionalCriterio.findByIdREGIONALCRITERIO", query = "SELECT r FROM RegionalCriterio r WHERE r.idREGIONALCRITERIO = :idREGIONALCRITERIO")})
public class RegionalCriterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idREGIONAL_CRITERIO")
    private Integer idREGIONALCRITERIO;
    @JoinColumn(name = "CRITERIO_idCRITERIO", referencedColumnName = "idCRITERIO")
    @ManyToOne(optional = false)
    private Criterio cRITERIOidCRITERIO;
    @JoinColumn(name = "REGIONAL_idREGIONAL", referencedColumnName = "idREGIONAL")
    @ManyToOne(optional = false)
    private Regional rEGIONALidREGIONAL;

    public RegionalCriterio() {
    }

    public RegionalCriterio(Integer idREGIONALCRITERIO) {
        this.idREGIONALCRITERIO = idREGIONALCRITERIO;
    }

    public Integer getIdREGIONALCRITERIO() {
        return idREGIONALCRITERIO;
    }

    public void setIdREGIONALCRITERIO(Integer idREGIONALCRITERIO) {
        this.idREGIONALCRITERIO = idREGIONALCRITERIO;
    }

    public Criterio getCRITERIOidCRITERIO() {
        return cRITERIOidCRITERIO;
    }

    public void setCRITERIOidCRITERIO(Criterio cRITERIOidCRITERIO) {
        this.cRITERIOidCRITERIO = cRITERIOidCRITERIO;
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
        hash += (idREGIONALCRITERIO != null ? idREGIONALCRITERIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionalCriterio)) {
            return false;
        }
        RegionalCriterio other = (RegionalCriterio) object;
        if ((this.idREGIONALCRITERIO == null && other.idREGIONALCRITERIO != null) || (this.idREGIONALCRITERIO != null && !this.idREGIONALCRITERIO.equals(other.idREGIONALCRITERIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegionalCriterio[ idREGIONALCRITERIO=" + idREGIONALCRITERIO + " ]";
    }
    
}
