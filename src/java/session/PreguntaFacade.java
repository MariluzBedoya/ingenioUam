/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidades.Glosario;
import entidades.Pregunta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mariluz
 */
@Stateless
public class PreguntaFacade extends AbstractFacade<Pregunta> {

    @PersistenceContext(unitName = "ProyectoCuestionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }
    
    public List<Pregunta> buscarPreguntaPorTemaCuestionario(Integer temaId, Integer idCuestionario, Integer idtipoPregunta){
        javax.persistence.Query q=getEntityManager().createNamedQuery("Pregunta.findByTemaId", Pregunta.class);
        q.setParameter("idTema", temaId);
        q.setParameter( "idCuestionario", idCuestionario);
        q.setParameter( "idtipoPregunta", idtipoPregunta);
        return q.getResultList();
       // SELECT p FROM Pregunta p WHERE p.idTema.id = :idTema AND p.idCuestionario.id=:idCuestionario AND p.idtipoPregunta.id = :idtipoPregunta
    }
    
}
