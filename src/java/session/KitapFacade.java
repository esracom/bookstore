/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kitabim.Kitap;

/**
 *
 * @author Hp
 */
@Stateless
public class KitapFacade extends AbstractFacade<Kitap> {

    @PersistenceContext(unitName = "kitapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KitapFacade() {
        super(Kitap.class);
    }
    
}
