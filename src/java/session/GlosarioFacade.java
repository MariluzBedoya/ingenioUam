/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidades.Glosario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mariluz
 */
@Stateless
public class GlosarioFacade extends AbstractFacade<Glosario> {

    @PersistenceContext(unitName = "ProyectoCuestionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GlosarioFacade() {
        super(Glosario.class);
    }
    
    public List<Glosario> buscarGlosarioPorTema(Integer temaId){
        javax.persistence.Query q=getEntityManager().createNamedQuery("Glosario.findByTemaId", Glosario.class);
        q.setParameter("idTema", temaId);
        return q.getResultList();
    }
    
    public Object buscarGlosarioPorId(Integer id)
    {
        javax.persistence.Query q=getEntityManager().createNamedQuery("Glosario.findById", Glosario.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }
}
