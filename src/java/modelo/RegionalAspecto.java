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
@Table(name = "regional_aspecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegionalAspecto.findAll", query = "SELECT r FROM RegionalAspecto r")
    , @NamedQuery(name = "RegionalAspecto.findByIdREGIONALASPECTO", query = "SELECT r FROM RegionalAspecto r WHERE r.idREGIONALASPECTO = :idREGIONALASPECTO")})
public class RegionalAspecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idREGIONAL_ASPECTO")
    private Integer idREGIONALASPECTO;
    @JoinColumn(name = "ASPECTO_idASPECTO", referencedColumnName = "idASPECTO")
    @ManyToOne(optional = false)
    private Aspecto aSPECTOidASPECTO;
    @JoinColumn(name = "REGIONAL_idREGIONAL", referencedColumnName = "idREGIONAL")
    @ManyToOne(optional = false)
    private Regional rEGIONALidREGIONAL;

    public RegionalAspecto() {
    }

    public RegionalAspecto(Integer idREGIONALASPECTO) {
        this.idREGIONALASPECTO = idREGIONALASPECTO;
    }

    public Integer getIdREGIONALASPECTO() {
        return idREGIONALASPECTO;
    }

    public void setIdREGIONALASPECTO(Integer idREGIONALASPECTO) {
        this.idREGIONALASPECTO = idREGIONALASPECTO;
    }

    public Aspecto getASPECTOidASPECTO() {
        return aSPECTOidASPECTO;
    }

    public void setASPECTOidASPECTO(Aspecto aSPECTOidASPECTO) {
        this.aSPECTOidASPECTO = aSPECTOidASPECTO;
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
        hash += (idREGIONALASPECTO != null ? idREGIONALASPECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionalAspecto)) {
            return false;
        }
        RegionalAspecto other = (RegionalAspecto) object;
        if ((this.idREGIONALASPECTO == null && other.idREGIONALASPECTO != null) || (this.idREGIONALASPECTO != null && !this.idREGIONALASPECTO.equals(other.idREGIONALASPECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegionalAspecto[ idREGIONALASPECTO=" + idREGIONALASPECTO + " ]";
    }
    
}
