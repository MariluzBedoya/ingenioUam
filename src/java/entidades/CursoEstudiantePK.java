/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mariluz
 */
@Embeddable
public class CursoEstudiantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula_estudiante", nullable = false, length = 10)
    private String cedulaEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    public CursoEstudiantePK() {
    }

    public CursoEstudiantePK(String cedulaEstudiante, int idCurso) {
        this.cedulaEstudiante = cedulaEstudiante;
        this.idCurso = idCurso;
    }

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaEstudiante != null ? cedulaEstudiante.hashCode() : 0);
        hash += (int) idCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoEstudiantePK)) {
            return false;
        }
        CursoEstudiantePK other = (CursoEstudiantePK) object;
        if ((this.cedulaEstudiante == null && other.cedulaEstudiante != null) || (this.cedulaEstudiante != null && !this.cedulaEstudiante.equals(other.cedulaEstudiante))) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CursoEstudiantePK[ cedulaEstudiante=" + cedulaEstudiante + ", idCurso=" + idCurso + " ]";
    }
    
}
