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
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByIdENCUESTA", query = "SELECT e FROM Encuesta e WHERE e.idENCUESTA = :idENCUESTA")
    , @NamedQuery(name = "Encuesta.findByNumeroEncuesta", query = "SELECT e FROM Encuesta e WHERE e.numeroEncuesta = :numeroEncuesta")
    , @NamedQuery(name = "Encuesta.findByFechaRealizacion", query = "SELECT e FROM Encuesta e WHERE e.fechaRealizacion = :fechaRealizacion")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENCUESTA")
    private Integer idENCUESTA;
    @Column(name = "numero_encuesta")
    private Integer numeroEncuesta;
    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<EncuestaCriterio> encuestaCriterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<ServicioForense> servicioForenseList;
    @JoinColumn(name = "MUESTRA_idMUESTRA", referencedColumnName = "idMUESTRA")
    @ManyToOne(optional = false)
    private Muestra mUESTRAidMUESTRA;
    @JoinColumn(name = "MUNICIPIO_idMUNICIPIO", referencedColumnName = "idMUNICIPIO")
    @ManyToOne(optional = false)
    private Municipio mUNICIPIOidMUNICIPIO;
    @JoinColumn(name = "PERIODICIDAD_idPERIODICIDAD", referencedColumnName = "idPERIODICIDAD")
    @ManyToOne(optional = false)
    private Periodicidad pERIODICIDADidPERIODICIDAD;
    @JoinColumn(name = "USUARIO_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuario uSUARIOcedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<EncuestaAspecto> encuestaAspectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<EncuestaCliente> encuestaClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<EncuestaPreguntas> encuestaPreguntasList;

    public Encuesta() {
    }

    public Encuesta(Integer idENCUESTA) {
        this.idENCUESTA = idENCUESTA;
    }

    public Integer getIdENCUESTA() {
        return idENCUESTA;
    }

    public void setIdENCUESTA(Integer idENCUESTA) {
        this.idENCUESTA = idENCUESTA;
    }

    public Integer getNumeroEncuesta() {
        return numeroEncuesta;
    }

    public void setNumeroEncuesta(Integer numeroEncuesta) {
        this.numeroEncuesta = numeroEncuesta;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    @XmlTransient
    public List<EncuestaCriterio> getEncuestaCriterioList() {
        return encuestaCriterioList;
    }

    public void setEncuestaCriterioList(List<EncuestaCriterio> encuestaCriterioList) {
        this.encuestaCriterioList = encuestaCriterioList;
    }

    @XmlTransient
    public List<ServicioForense> getServicioForenseList() {
        return servicioForenseList;
    }

    public void setServicioForenseList(List<ServicioForense> servicioForenseList) {
        this.servicioForenseList = servicioForenseList;
    }

    public Muestra getMUESTRAidMUESTRA() {
        return mUESTRAidMUESTRA;
    }

    public void setMUESTRAidMUESTRA(Muestra mUESTRAidMUESTRA) {
        this.mUESTRAidMUESTRA = mUESTRAidMUESTRA;
    }

    public Municipio getMUNICIPIOidMUNICIPIO() {
        return mUNICIPIOidMUNICIPIO;
    }

    public void setMUNICIPIOidMUNICIPIO(Municipio mUNICIPIOidMUNICIPIO) {
        this.mUNICIPIOidMUNICIPIO = mUNICIPIOidMUNICIPIO;
    }

    public Periodicidad getPERIODICIDADidPERIODICIDAD() {
        return pERIODICIDADidPERIODICIDAD;
    }

    public void setPERIODICIDADidPERIODICIDAD(Periodicidad pERIODICIDADidPERIODICIDAD) {
        this.pERIODICIDADidPERIODICIDAD = pERIODICIDADidPERIODICIDAD;
    }

    public Usuario getUSUARIOcedula() {
        return uSUARIOcedula;
    }

    public void setUSUARIOcedula(Usuario uSUARIOcedula) {
        this.uSUARIOcedula = uSUARIOcedula;
    }

    @XmlTransient
    public List<EncuestaAspecto> getEncuestaAspectoList() {
        return encuestaAspectoList;
    }

    public void setEncuestaAspectoList(List<EncuestaAspecto> encuestaAspectoList) {
        this.encuestaAspectoList = encuestaAspectoList;
    }

    @XmlTransient
    public List<EncuestaCliente> getEncuestaClienteList() {
        return encuestaClienteList;
    }

    public void setEncuestaClienteList(List<EncuestaCliente> encuestaClienteList) {
        this.encuestaClienteList = encuestaClienteList;
    }

    @XmlTransient
    public List<EncuestaPreguntas> getEncuestaPreguntasList() {
        return encuestaPreguntasList;
    }

    public void setEncuestaPreguntasList(List<EncuestaPreguntas> encuestaPreguntasList) {
        this.encuestaPreguntasList = encuestaPreguntasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idENCUESTA != null ? idENCUESTA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.idENCUESTA == null && other.idENCUESTA != null) || (this.idENCUESTA != null && !this.idENCUESTA.equals(other.idENCUESTA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Encuesta[ idENCUESTA=" + idENCUESTA + " ]";
    }
    
}
