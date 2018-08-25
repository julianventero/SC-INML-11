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
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByIdRESPUESTA", query = "SELECT r FROM Respuesta r WHERE r.idRESPUESTA = :idRESPUESTA")
    , @NamedQuery(name = "Respuesta.findByRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuesta = :respuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRESPUESTA")
    private Integer idRESPUESTA;
    @Size(max = 255)
    @Column(name = "respuesta")
    private String respuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rESPUESTAidRESPUESTA")
    private List<ClienteRespuesta> clienteRespuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rESPUESTAidRESPUESTA")
    private List<EncuestaPreguntas> encuestaPreguntasList;
    @JoinColumn(name = "PARAMETROS_MEDICION_idPARAMETROS_MEDICION", referencedColumnName = "idPARAMETROS_MEDICION")
    @ManyToOne(optional = false)
    private ParametrosMedicion pARAMETROSMEDICIONidPARAMETROSMEDICION;

    public Respuesta() {
    }

    public Respuesta(Integer idRESPUESTA) {
        this.idRESPUESTA = idRESPUESTA;
    }

    public Integer getIdRESPUESTA() {
        return idRESPUESTA;
    }

    public void setIdRESPUESTA(Integer idRESPUESTA) {
        this.idRESPUESTA = idRESPUESTA;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @XmlTransient
    public List<ClienteRespuesta> getClienteRespuestaList() {
        return clienteRespuestaList;
    }

    public void setClienteRespuestaList(List<ClienteRespuesta> clienteRespuestaList) {
        this.clienteRespuestaList = clienteRespuestaList;
    }

    @XmlTransient
    public List<EncuestaPreguntas> getEncuestaPreguntasList() {
        return encuestaPreguntasList;
    }

    public void setEncuestaPreguntasList(List<EncuestaPreguntas> encuestaPreguntasList) {
        this.encuestaPreguntasList = encuestaPreguntasList;
    }

    public ParametrosMedicion getPARAMETROSMEDICIONidPARAMETROSMEDICION() {
        return pARAMETROSMEDICIONidPARAMETROSMEDICION;
    }

    public void setPARAMETROSMEDICIONidPARAMETROSMEDICION(ParametrosMedicion pARAMETROSMEDICIONidPARAMETROSMEDICION) {
        this.pARAMETROSMEDICIONidPARAMETROSMEDICION = pARAMETROSMEDICIONidPARAMETROSMEDICION;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRESPUESTA != null ? idRESPUESTA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRESPUESTA == null && other.idRESPUESTA != null) || (this.idRESPUESTA != null && !this.idRESPUESTA.equals(other.idRESPUESTA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Respuesta[ idRESPUESTA=" + idRESPUESTA + " ]";
    }
    
}
