/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariluz
 */
@Entity
@Table(name = "respuesta", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findById", query = "SELECT r FROM Respuesta r WHERE r.id = :id"),
    @NamedQuery(name = "Respuesta.findByDescripcion", query = "SELECT r FROM Respuesta r WHERE r.descripcion = :descripcion"),
   @NamedQuery(name = "Respuesta.findByIdPregunta", query = "SELECT r FROM Respuesta r WHERE r.idPregunta.id = :idPregunta"),
    @NamedQuery(name = "Respuesta.findByCorrecta", query = "SELECT r FROM Respuesta r WHERE r.correcta = :correcta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    @Column(name = "correcta")
    private Integer correcta;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    @ManyToOne
    private Pregunta idPregunta;

    public Respuesta() {
    }

    public Respuesta(Integer id) {
        this.id = id;
    }
    
     public Respuesta(String descripcion, int correcta, Pregunta idPregunta) {
       this.descripcion= descripcion;
       this.correcta= correcta;
       this.idPregunta= idPregunta;
               
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Integer correcta) {
        this.correcta = correcta;
    }

    public Pregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Pregunta idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Respuesta[ id=" + id + " ]";
    }
    
}
