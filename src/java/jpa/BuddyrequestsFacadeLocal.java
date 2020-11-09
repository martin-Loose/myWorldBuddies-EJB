/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Buddyrequests;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface BuddyrequestsFacadeLocal {

    void create(Buddyrequests buddyrequests);

    void edit(Buddyrequests buddyrequests);

    void remove(Buddyrequests buddyrequests);

    Buddyrequests find(Object id);

    List<Buddyrequests> findAll();

    List<Buddyrequests> findRange(int[] range);

    int count();
    /**
     * find request by requesterID
     * find request by requestedID
     * @param requesterID
     * @return requests filtered by requesterID
     */
    List<Buddyrequests> findByRequesterID(int requesterID); // requestView - show users requests
    List<Buddyrequests> findByRequestedID(int requestedID); // requestView - show requests for user
    Buddyrequests findByRequesterANDRequested(int requesterID,int requestedID);
   List<Buddyrequests> findByRequesterORRequested(int requesterID);
}
