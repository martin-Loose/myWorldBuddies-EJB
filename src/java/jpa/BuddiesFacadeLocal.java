/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Buddies;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface BuddiesFacadeLocal {

    void create(Buddies buddies);

    void edit(Buddies buddies);

    void remove(Buddies buddies);

    Buddies find(Object id);

    List<Buddies> findAll();

    List<Buddies> findRange(int[] range);

    int count();
    Buddies existBuddy(int myID, int requestedID);
    List<Buddies> findMyBuddies(int myID);
}
