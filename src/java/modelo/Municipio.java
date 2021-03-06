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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
    , @NamedQuery(name = "Municipio.findByIdMUNICIPIO", query = "SELECT m FROM Municipio m WHERE m.idMUNICIPIO = :idMUNICIPIO")
    , @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMUNICIPIO")
    private Integer idMUNICIPIO;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mUNICIPIOidMUNICIPIO")
    private List<Encuesta> encuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mUNICIPIOidMUNICIPIO")
    private List<ClienteMunicipio> clienteMunicipioList;
    @JoinColumn(name = "SECCIONAL_idSECCIONAL", referencedColumnName = "idSECCIONAL")
    @ManyToOne(optional = false)
    private Seccional sECCIONALidSECCIONAL;

    public Municipio() {
    }

    public Municipio(Integer idMUNICIPIO) {
        this.idMUNICIPIO = idMUNICIPIO;
    }

    public Integer getIdMUNICIPIO() {
        return idMUNICIPIO;
    }

    public void setIdMUNICIPIO(Integer idMUNICIPIO) {
        this.idMUNICIPIO = idMUNICIPIO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    @XmlTransient
    public List<ClienteMunicipio> getClienteMunicipioList() {
        return clienteMunicipioList;
    }

    public void setClienteMunicipioList(List<ClienteMunicipio> clienteMunicipioList) {
        this.clienteMunicipioList = clienteMunicipioList;
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
        hash += (idMUNICIPIO != null ? idMUNICIPIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMUNICIPIO == null && other.idMUNICIPIO != null) || (this.idMUNICIPIO != null && !this.idMUNICIPIO.equals(other.idMUNICIPIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Municipio[ idMUNICIPIO=" + idMUNICIPIO + " ]";
    }
    
}
