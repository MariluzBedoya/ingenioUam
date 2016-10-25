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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariluz
 */
@Entity
@Table(name = "estudiante", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByCedula", query = "SELECT e FROM Estudiante e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiante.findByApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Estudiante.findByCorreo", query = "SELECT e FROM Estudiante e WHERE e.correo = :correo"),
    @NamedQuery(name = "Estudiante.findByContrase\u00f1a", query = "SELECT e FROM Estudiante e WHERE e.contrase\u00f1a = :contrase\u00f1a")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido", length = 50)
    private String apellido;
    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    private String telefono;
    @Size(max = 255)
    @Column(name = "correo", length = 255)
    private String correo;
    @Size(max = 30)
    @Column(name = "contrase\u00f1a", length = 30)
    private String contraseña;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<EstudianteCuestionario> estudianteCuestionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<CursoEstudiante> cursoEstudianteCollection;
    @OneToMany(mappedBy = "cedulaEstudiante")
    private Collection<Pregunta> preguntaCollection;

    public Estudiante() {
    }

    public Estudiante(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @XmlTransient
    public Collection<EstudianteCuestionario> getEstudianteCuestionarioCollection() {
        return estudianteCuestionarioCollection;
    }

    public void setEstudianteCuestionarioCollection(Collection<EstudianteCuestionario> estudianteCuestionarioCollection) {
        this.estudianteCuestionarioCollection = estudianteCuestionarioCollection;
    }

    @XmlTransient
    public Collection<CursoEstudiante> getCursoEstudianteCollection() {
        return cursoEstudianteCollection;
    }

    public void setCursoEstudianteCollection(Collection<CursoEstudiante> cursoEstudianteCollection) {
        this.cursoEstudianteCollection = cursoEstudianteCollection;
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
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nombre + "";
    }
    
}
