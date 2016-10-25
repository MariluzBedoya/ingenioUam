/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariluz
 */
@Entity
@Table(name = "pregunta", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findById", query = "SELECT p FROM Pregunta p WHERE p.id = :id"),
    @NamedQuery(name = "Pregunta.findByTemaId", query = "SELECT p FROM Pregunta p WHERE p.idTema.id = :idTema AND p.idCuestionario.id=:idCuestionario AND p.idtipoPregunta.id = :idtipoPregunta"),
    @NamedQuery(name = "Pregunta.findByEnunciado", query = "SELECT p FROM Pregunta p WHERE p.enunciado = :enunciado")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 400)
    @Column(name = "enunciado", length = 400)
    private String enunciado;
    @OneToMany(mappedBy = "idPregunta")
    private Collection<Respuesta> respuestaCollection;
    @JoinColumn(name = "cedula_estudiante", referencedColumnName = "cedula")
    @ManyToOne
    private Estudiante cedulaEstudiante;
    @JoinColumn(name = "id_cuestionario", referencedColumnName = "id")
    @ManyToOne
    private Cuestionario idCuestionario;
    @JoinColumn(name = "id_tema", referencedColumnName = "id")
    @ManyToOne
    private Tema idTema;
    @JoinColumn(name = "id_tipoPregunta", referencedColumnName = "id")
    @ManyToOne
    private TipoPregunta idtipoPregunta;

    public Pregunta() {
    }

    public Pregunta(Integer id) {
        this.id = id;
    }

    public Pregunta( String enunciado, TipoPregunta tipo_pregunta, Cuestionario id_cuestionario, Tema idTema) {
        
        this.enunciado= enunciado;
        this.idtipoPregunta= tipo_pregunta;
        this.idCuestionario= id_cuestionario;
        this.idTema= idTema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    public Estudiante getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Estudiante cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public Cuestionario getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Cuestionario idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Tema getIdTema() {
        return idTema;
    }

    public void setIdTema(Tema idTema) {
        this.idTema = idTema;
    }

    public TipoPregunta getIdtipoPregunta() {
        return idtipoPregunta;
    }

    public void setIdtipoPregunta(TipoPregunta idtipoPregunta) {
        this.idtipoPregunta = idtipoPregunta;
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
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pregunta[ id=" + id + " ]";
    }

}
