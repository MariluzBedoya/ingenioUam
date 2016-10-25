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
@Table(name = "cuestionario", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuestionario.findAll", query = "SELECT c FROM Cuestionario c"),
    @NamedQuery(name = "Cuestionario.findById", query = "SELECT c FROM Cuestionario c WHERE c.id = :id"),
    @NamedQuery(name = "Cuestionario.findByNombre", query = "SELECT c FROM Cuestionario c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cuestionario.findByCantPregFv", query = "SELECT c FROM Cuestionario c WHERE c.cantPregFv = :cantPregFv"),
    @NamedQuery(name = "Cuestionario.findByCantPregSm", query = "SELECT c FROM Cuestionario c WHERE c.cantPregSm = :cantPregSm"),
    @NamedQuery(name = "Cuestionario.findByCantPregAb", query = "SELECT c FROM Cuestionario c WHERE c.cantPregAb = :cantPregAb")})
public class Cuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "cant_preg_fv")
    private Integer cantPregFv;
    @Column(name = "cant_preg_sm")
    private Integer cantPregSm;
    @Column(name = "cant_preg_ab")
    private Integer cantPregAb;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento idDepartamento;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne
    private Curso idCurso;
    @JoinColumn(name = "id_tema", referencedColumnName = "id")
    @ManyToOne
    private Tema idTema;
    @JoinColumn(name = "cedula_profesor", referencedColumnName = "cedula")
    @ManyToOne
    private Profesor cedulaProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuestionario")
    private Collection<EstudianteCuestionario> estudianteCuestionarioCollection;
    @OneToMany(mappedBy = "idCuestionario")
    private Collection<Pregunta> preguntaCollection;

    public Cuestionario() {
    }

    public Cuestionario(Integer id) {
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

    public Integer getCantPregFv() {
        return cantPregFv;
    }

    public void setCantPregFv(Integer cantPregFv) {
        this.cantPregFv = cantPregFv;
    }

    public Integer getCantPregSm() {
        return cantPregSm;
    }

    public void setCantPregSm(Integer cantPregSm) {
        this.cantPregSm = cantPregSm;
    }

    public Integer getCantPregAb() {
        return cantPregAb;
    }

    public void setCantPregAb(Integer cantPregAb) {
        this.cantPregAb = cantPregAb;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Tema getIdTema() {
        return idTema;
    }

    public void setIdTema(Tema idTema) {
        this.idTema = idTema;
    }

    public Profesor getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(Profesor cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    @XmlTransient
    public Collection<EstudianteCuestionario> getEstudianteCuestionarioCollection() {
        return estudianteCuestionarioCollection;
    }

    public void setEstudianteCuestionarioCollection(Collection<EstudianteCuestionario> estudianteCuestionarioCollection) {
        this.estudianteCuestionarioCollection = estudianteCuestionarioCollection;
    }

    @XmlTransient
    public Collection<Pregunta> getPreguntaCollection() {
        return preguntaCollection;
    }

    public void setPreguntaCollection(Collection<Pregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
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
        if (!(object instanceof Cuestionario)) {
            return false;
        }
        Cuestionario other = (Cuestionario) object;
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
