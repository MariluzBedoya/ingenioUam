/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidades.Glosario;
import entidades.Respuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mariluz
 */
@Stateless
public class RespuestaFacade extends AbstractFacade<Respuesta> {

    @PersistenceContext(unitName = "ProyectoCuestionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RespuestaFacade() {
        super(Respuesta.class);
    }
    
    
       public List<Respuesta> buscarRespuestaPorIdPregunta (Integer idPregunta)
    {
        javax.persistence.Query q=getEntityManager().createNamedQuery("Respuesta.findByIdPregunta", Respuesta.class);
        q.setParameter("idPregunta", idPregunta);
        return q.getResultList();
    }
   
    
}
