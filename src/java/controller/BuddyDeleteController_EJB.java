/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Buddies;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.BuddiesFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class BuddyDeleteController_EJB {
   private int myID;
   private int myBuddyID;
   
   @Inject
   private BuddiesFacadeLocal buddyFacade;
   
   //overwritten
   public void prepareBuddyDelete(String buddy){
   
   }
  
   public String deleteBuddy(){
   Buddies b=new Buddies();
   try{
   b=buddyFacade.existBuddy(getMyID(),getMyBuddyID());
    buddyFacade.remove(b);
    b=buddyFacade.existBuddy(getMyBuddyID(),getMyID());
   buddyFacade.remove(b);
   FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Buddy deleted", "deleted"));
   }catch(Exception e){
       FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Buddy not deleted", ""));
   }
       return "myBuddiesList?faces-redirect=true";
   
   }

    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public int getMyBuddyID() {
        return myBuddyID;
    }

    public void setMyBuddyID(int myBuddyID) {
        this.myBuddyID = myBuddyID;
    }
   
   
}
