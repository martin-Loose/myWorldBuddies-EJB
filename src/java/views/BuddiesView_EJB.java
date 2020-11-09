/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Buddies;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jpa.BuddiesFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class BuddiesView_EJB {

 private List<String>myBuddies=new ArrayList<>();
// private Users selectedBuddy;
 @Inject
 private BuddiesFacadeLocal buddiesFacade;
private int myID;

   

    public List<String> getMyBuddies() {
        try{
            return null;
        }catch(Exception e){
    }
        return myBuddies;
    }

    public void setMyBuddies(List<String> myBuddies) {
        this.myBuddies = myBuddies;
    }
/** overwritten in webapp buddiesService
    public Buddies getSelectedBuddy() {
        return selectedBuddy;
    }

    public void setSelectedBuddy(Buddies selectedBuddy) {
        this.selectedBuddy = selectedBuddy;
    }
**/
    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public BuddiesFacadeLocal getBuddiesFacade() {
        return buddiesFacade;
    }

    public void setBuddiesFacade(BuddiesFacadeLocal buddiesFacade) {
        this.buddiesFacade = buddiesFacade;
    }
 
 
}
