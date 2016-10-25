/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
 * @author mariluz
 */
@Entity
@Table(name = "curso", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findById", query = "SELECT c FROM Curso c WHERE c.id = :id"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curso.findByCanTestudiante", query = "SELECT c FROM Curso c WHERE c.canTestudiante = :canTestudiante")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "canTestudiante")
    private Integer canTestudiante;
    @OneToMany(mappedBy = "idCurso")
    private Collection<Tema> temaCollection;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento idDepartamento;
    @JoinColumn(name = "cedula_profesor", referencedColumnName = "cedula")
    @ManyToOne
    private Profesor cedulaProfesor;
    @OneToMany(mappedBy = "idCurso")
    private Collection<Glosario> glosarioCollection;
    @OneToMany(mappedBy = "idCurso")
    private Collection<Cuestionario> cuestionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<CursoEstudiante> cursoEstudianteCollection;

    public Curso() {
    }

    public Curso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCanTestudiante() {
        return canTestudiante;
    }

    public void setCanTestudiante(Integer canTestudiante) {
        this.canTestudiante = canTestudiante;
    }

    @XmlTransient
    public Collection<Tema> getTemaCollection() {
        return temaCollection;
    }

    public void setTemaCollection(Collection<Tema> temaCollection) {
        this.temaCollection = temaCollection;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Profesor getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(Profesor cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    @XmlTransient
    public Collection<Glosario> getGlosarioCollection() {
        return glosarioCollection;
    }

    public void setGlosarioCollection(Collection<Glosario> glosarioCollection) {
        this.glosarioCollection = glosarioCollection;
    }

    @XmlTransient
    public Collection<Cuestionario> getCuestionarioCollection() {
        return cuestionarioCollection;
    }

    public void setCuestionarioCollection(Collection<Cuestionario> cuestionarioCollection) {
        this.cuestionarioCollection = cuestionarioCollection;
    }

    @XmlTransient
    public Collection<CursoEstudiante> getCursoEstudianteCollection() {
        return cursoEstudianteCollection;
    }

    public void setCursoEstudianteCollection(Collection<CursoEstudiante> cursoEstudianteCollection) {
        this.cursoEstudianteCollection = cursoEstudianteCollection;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nombre + "";
    }
    
}
