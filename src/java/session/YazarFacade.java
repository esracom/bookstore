/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kitabim.Yazar;

/**
 *
 * @author Hp
 */
@Stateless
public class YazarFacade extends AbstractFacade<Yazar> {

    @PersistenceContext(unitName = "kitapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public YazarFacade() {
        super(Yazar.class);
    }
    
}
