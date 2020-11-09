/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Blockedbuddie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface BlockedbuddieFacadeLocal {

    void create(Blockedbuddie blockedbuddie);

    void edit(Blockedbuddie blockedbuddie);

    void remove(Blockedbuddie blockedbuddie);

    Blockedbuddie find(Object id);

    List<Blockedbuddie> findAll();

    List<Blockedbuddie> findRange(int[] range);

    int count();
    
}
