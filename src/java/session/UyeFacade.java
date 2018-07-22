/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kitabim.Uye;

/**
 *
 * @author Hp
 */
@Stateless
public class UyeFacade extends AbstractFacade<Uye> {

    @PersistenceContext(unitName = "kitapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UyeFacade() {
        super(Uye.class);
    }
    
}
