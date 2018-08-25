/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "periodicidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodicidad.findAll", query = "SELECT p FROM Periodicidad p")
    , @NamedQuery(name = "Periodicidad.findByIdPERIODICIDAD", query = "SELECT p FROM Periodicidad p WHERE p.idPERIODICIDAD = :idPERIODICIDAD")
    , @NamedQuery(name = "Periodicidad.findByFechaInicio", query = "SELECT p FROM Periodicidad p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Periodicidad.findByFechaFin", query = "SELECT p FROM Periodicidad p WHERE p.fechaFin = :fechaFin")})
public class Periodicidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPERIODICIDAD")
    private Integer idPERIODICIDAD;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private EstadoP eSTADOidESTADO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pERIODICIDADidPERIODICIDAD")
    private List<Encuesta> encuestaList;

    public Periodicidad() {
    }

    public Periodicidad(Integer idPERIODICIDAD) {
        this.idPERIODICIDAD = idPERIODICIDAD;
    }

    public Integer getIdPERIODICIDAD() {
        return idPERIODICIDAD;
    }

    public void setIdPERIODICIDAD(Integer idPERIODICIDAD) {
        this.idPERIODICIDAD = idPERIODICIDAD;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoP getESTADOidESTADO() {
        return eSTADOidESTADO;
    }

    public void setESTADOidESTADO(EstadoP eSTADOidESTADO) {
        this.eSTADOidESTADO = eSTADOidESTADO;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPERIODICIDAD != null ? idPERIODICIDAD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodicidad)) {
            return false;
        }
        Periodicidad other = (Periodicidad) object;
        if ((this.idPERIODICIDAD == null && other.idPERIODICIDAD != null) || (this.idPERIODICIDAD != null && !this.idPERIODICIDAD.equals(other.idPERIODICIDAD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Periodicidad[ idPERIODICIDAD=" + idPERIODICIDAD + " ]";
    }
    
}
