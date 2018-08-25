/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "muestra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Muestra.findAll", query = "SELECT m FROM Muestra m")
    , @NamedQuery(name = "Muestra.findByIdMUESTRA", query = "SELECT m FROM Muestra m WHERE m.idMUESTRA = :idMUESTRA")
    , @NamedQuery(name = "Muestra.findByPlaneada", query = "SELECT m FROM Muestra m WHERE m.planeada = :planeada")
    , @NamedQuery(name = "Muestra.findByEjecutada", query = "SELECT m FROM Muestra m WHERE m.ejecutada = :ejecutada")})
public class Muestra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMUESTRA")
    private Integer idMUESTRA;
    @Column(name = "planeada")
    private Integer planeada;
    @Column(name = "ejecutada")
    private Integer ejecutada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mUESTRAidMUESTRA")
    private List<Encuesta> encuestaList;

    public Muestra() {
    }

    public Muestra(Integer idMUESTRA) {
        this.idMUESTRA = idMUESTRA;
    }

    public Integer getIdMUESTRA() {
        return idMUESTRA;
    }

    public void setIdMUESTRA(Integer idMUESTRA) {
        this.idMUESTRA = idMUESTRA;
    }

    public Integer getPlaneada() {
        return planeada;
    }

    public void setPlaneada(Integer planeada) {
        this.planeada = planeada;
    }

    public Integer getEjecutada() {
        return ejecutada;
    }

    public void setEjecutada(Integer ejecutada) {
        this.ejecutada = ejecutada;
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
        hash += (idMUESTRA != null ? idMUESTRA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muestra)) {
            return false;
        }
        Muestra other = (Muestra) object;
        if ((this.idMUESTRA == null && other.idMUESTRA != null) || (this.idMUESTRA != null && !this.idMUESTRA.equals(other.idMUESTRA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Muestra[ idMUESTRA=" + idMUESTRA + " ]";
    }
    
}
