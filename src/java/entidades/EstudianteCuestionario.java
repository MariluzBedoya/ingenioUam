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
@Table(name = "estudianteCuestionario", catalog = "ingenioUam", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteCuestionario.findAll", query = "SELECT e FROM EstudianteCuestionario e"),
    @NamedQuery(name = "EstudianteCuestionario.findByCedulaEstudiante", query = "SELECT e FROM EstudianteCuestionario e WHERE e.estudianteCuestionarioPK.cedulaEstudiante = :cedulaEstudiante"),
    @NamedQuery(name = "EstudianteCuestionario.findByIdCuestionario", query = "SELECT e FROM EstudianteCuestionario e WHERE e.estudianteCuestionarioPK.idCuestionario = :idCuestionario"),
    @NamedQuery(name = "EstudianteCuestionario.findByFecha", query = "SELECT e FROM EstudianteCuestionario e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EstudianteCuestionario.findByEstado", query = "SELECT e FROM EstudianteCuestionario e WHERE e.estado = :estado")})
public class EstudianteCuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteCuestionarioPK estudianteCuestionarioPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "cedula_estudiante", referencedColumnName = "cedula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "id_cuestionario", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuestionario cuestionario;

    public EstudianteCuestionario() {
    }

    public EstudianteCuestionario(EstudianteCuestionarioPK estudianteCuestionarioPK) {
        this.estudianteCuestionarioPK = estudianteCuestionarioPK;
    }

    public EstudianteCuestionario(String cedulaEstudiante, int idCuestionario) {
        this.estudianteCuestionarioPK = new EstudianteCuestionarioPK(cedulaEstudiante, idCuestionario);
    }

    public EstudianteCuestionarioPK getEstudianteCuestionarioPK() {
        return estudianteCuestionarioPK;
    }

    public void setEstudianteCuestionarioPK(EstudianteCuestionarioPK estudianteCuestionarioPK) {
        this.estudianteCuestionarioPK = estudianteCuestionarioPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteCuestionarioPK != null ? estudianteCuestionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCuestionario)) {
            return false;
        }
        EstudianteCuestionario other = (EstudianteCuestionario) object;
        if ((this.estudianteCuestionarioPK == null && other.estudianteCuestionarioPK != null) || (this.estudianteCuestionarioPK != null && !this.estudianteCuestionarioPK.equals(other.estudianteCuestionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstudianteCuestionario[ estudianteCuestionarioPK=" + estudianteCuestionarioPK + " ]";
    }
    
}
