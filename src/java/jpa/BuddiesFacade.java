/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Buddies;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class BuddiesFacade extends AbstractFacade<Buddies> implements BuddiesFacadeLocal {

    @PersistenceContext(unitName = "myWorldBuddies-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BuddiesFacade() {
        super(Buddies.class);
    }

    /**
     *
     * @param myID
     * @param requestedID
     * @return exist buddyentry
     */
    @Override
    public Buddies existBuddy(int myID, int requestedID) {
        try {
            return em.createNamedQuery("Buddies.buddyExist", Buddies.class).setParameter("buddie1id", myID)
                    .setParameter("buddie2id", requestedID).getSingleResult();
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Buddies> findMyBuddies(int myID) {
      try {
            return em.createNamedQuery("Buddies.findMyBuddies", Buddies.class)
                    .setParameter("buddie1id", myID).getResultList();
                    
        } catch (Exception e) {

        }
        return null;
    }

}
