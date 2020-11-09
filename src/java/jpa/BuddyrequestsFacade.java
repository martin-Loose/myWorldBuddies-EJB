/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Buddyrequests;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class BuddyrequestsFacade extends AbstractFacade<Buddyrequests> implements BuddyrequestsFacadeLocal {

    @PersistenceContext(unitName = "myWorldBuddies-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BuddyrequestsFacade() {
        super(Buddyrequests.class);
    }

    @Override
    public List<Buddyrequests> findByRequesterID(int requesterID) {
       List<Buddyrequests> yourRequests=new ArrayList<>();
        try{
          return em.createNamedQuery("Buddyrequests.findByRequesterID",Buddyrequests.class)
                  .setParameter("requesterID",requesterID).getResultList();
       }catch(Exception e){
           
       }
        return yourRequests;       
    }

    @Override
    public List<Buddyrequests> findByRequestedID(int requestedID) {
       List<Buddyrequests> requestsToYou=new ArrayList<>();
        try{
          return em.createNamedQuery("Buddyrequests.findByRequestedID",Buddyrequests.class)
                  .setParameter("requestedID",requestedID).getResultList();
       }catch(Exception e){
           
       }
        return requestsToYou;       
    }

    @Override
    public Buddyrequests findByRequesterANDRequested(int requesterID, int requestedID) {
         Buddyrequests requestExists=null;
        try{
          return em.createNamedQuery("Buddyrequests.findByRequesterANDRequested",Buddyrequests.class)
                  .setParameter("requesterID",requesterID)
                  .setParameter("requestedID",requestedID).getSingleResult();
       }catch(Exception e){
           
       }
        return requestExists;       
    }
    
    @Override
    public List<Buddyrequests> findByRequesterORRequested(int requesterID) {
        System.err.println("in facade "+requesterID);
         List<Buddyrequests> requestExists=new ArrayList<>();
        try{
            requestExists=em.createNamedQuery("Buddyrequests.findByRequesterORRequested",Buddyrequests.class)
                  .setParameter("requesterID",requesterID)
                  .setParameter("requestedID",requesterID).getResultList();
          return requestExists;
       }catch(Exception e){
          System.err.println("in facade "+e.getMessage());  
       }
        return requestExists;       
    }
}
