/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariluz
 */
@Entity
@Table(name = "curso_estudiante", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoEstudiante.findAll", query = "SELECT c FROM CursoEstudiante c"),
    @NamedQuery(name = "CursoEstudiante.findByCedulaEstudiante", query = "SELECT c FROM CursoEstudiante c WHERE c.cursoEstudiantePK.cedulaEstudiante = :cedulaEstudiante"),
    @NamedQuery(name = "CursoEstudiante.findByIdCurso", query = "SELECT c FROM CursoEstudiante c WHERE c.cursoEstudiantePK.idCurso = :idCurso"),
    @NamedQuery(name = "CursoEstudiante.findByFechaInscripcion", query = "SELECT c FROM CursoEstudiante c WHERE c.fechaInscripcion = :fechaInscripcion"),
    @NamedQuery(name = "CursoEstudiante.findByNota", query = "SELECT c FROM CursoEstudiante c WHERE c.nota = :nota")})
public class CursoEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoEstudiantePK cursoEstudiantePK;
    @Column(name = "fechaInscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 12)
    private Float nota;
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "cedula_estudiante", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public CursoEstudiante() {
    }

    public CursoEstudiante(CursoEstudiantePK cursoEstudiantePK) {
        this.cursoEstudiantePK = cursoEstudiantePK;
    }

    public CursoEstudiante(String cedulaEstudiante, int idCurso) {
        this.cursoEstudiantePK = new CursoEstudiantePK(cedulaEstudiante, idCurso);
    }

    public CursoEstudiantePK getCursoEstudiantePK() {
        return cursoEstudiantePK;
    }

    public void setCursoEstudiantePK(CursoEstudiantePK cursoEstudiantePK) {
        this.cursoEstudiantePK = cursoEstudiantePK;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoEstudiantePK != null ? cursoEstudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoEstudiante)) {
            return false;
        }
        CursoEstudiante other = (CursoEstudiante) object;
        if ((this.cursoEstudiantePK == null && other.cursoEstudiantePK != null) || (this.cursoEstudiantePK != null && !this.cursoEstudiantePK.equals(other.cursoEstudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CursoEstudiante[ cursoEstudiantePK=" + cursoEstudiantePK + " ]";
    }
    
}
