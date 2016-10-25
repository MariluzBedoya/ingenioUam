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
public class EstudianteCuestionarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula_estudiante", nullable = false, length = 10)
    private String cedulaEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuestionario", nullable = false)
    private int idCuestionario;

    public EstudianteCuestionarioPK() {
    }

    public EstudianteCuestionarioPK(String cedulaEstudiante, int idCuestionario) {
        this.cedulaEstudiante = cedulaEstudiante;
        this.idCuestionario = idCuestionario;
    }

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaEstudiante != null ? cedulaEstudiante.hashCode() : 0);
        hash += (int) idCuestionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCuestionarioPK)) {
            return false;
        }
        EstudianteCuestionarioPK other = (EstudianteCuestionarioPK) object;
        if ((this.cedulaEstudiante == null && other.cedulaEstudiante != null) || (this.cedulaEstudiante != null && !this.cedulaEstudiante.equals(other.cedulaEstudiante))) {
            return false;
        }
        if (this.idCuestionario != other.idCuestionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstudianteCuestionarioPK[ cedulaEstudiante=" + cedulaEstudiante + ", idCuestionario=" + idCuestionario + " ]";
    }
    
}
