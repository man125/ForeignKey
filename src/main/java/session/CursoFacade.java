/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Curso;

/**
 *
 * @author manuel
 */
@Stateless
public class CursoFacade extends AbstractFacade<Curso> implements CursoFacadeLocal {

    @PersistenceContext(unitName = "com.sar_mavenejb_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }
    
}
