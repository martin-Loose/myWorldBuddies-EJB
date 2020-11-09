/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;





import entities.Buddies;
import entities.Buddyrequests;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.BuddiesFacadeLocal;
import jpa.BuddyrequestsFacadeLocal;




/**
 *
 * @author marlo0212
 */
public class BuddyRequestControllerRUD_EJB {

private Buddies newBuddie=new Buddies();
@Inject
private BuddyrequestsFacadeLocal buddyFacade;
@Inject
private BuddiesFacadeLocal buddiesFacade;
public void acceptThisRequest(int requestID,int myID,int requesterID){
   if(buddieCreated(requestID, myID, requesterID)==true){
   FacesContext.getCurrentInstance().addMessage("userTable:acceptRequest",
   new FacesMessage(FacesMessage.SEVERITY_FATAL, "Request accepted", "Buddy created and Request deleted"));
       deleteThisRequest(requestID);
   }else if(buddieCreated(requestID, myID, requesterID)==false){
    FacesContext.getCurrentInstance().addMessage("userTable:acceptRequest",
   new FacesMessage(FacesMessage.SEVERITY_FATAL, "Accept Request failure, something went wrong", "..."));
   }
 
}

public String deleteThisRequest(int requestID){
  buddyFacade.remove(buddyFacade.find(requestID));
FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Request deleted", "deleted"));
       
return "requestsList?faces-redirect=true";
}
 public boolean buddieCreated(int requestID,int myID,int requesterID){
 boolean created=false;
 
 try{
 newBuddie.setBuddie1id(buddyFacade.find(requestID).getRequestedID());
 newBuddie.setBuddie2id(buddyFacade.find(requestID).getRequesterID());
 buddiesFacade.create(newBuddie);
 newBuddie.setBuddie1id(buddyFacade.find(requestID).getRequesterID());
 newBuddie.setBuddie2id(buddyFacade.find(requestID).getRequestedID());
 buddiesFacade.create(newBuddie); 
 created=true;
 }catch(Exception e){
 }
 
 return created;
 } 

    public Buddies getNewBuddie() {
        return newBuddie;
    }

    public void setNewBuddie(Buddies newBuddie) {
        this.newBuddie = newBuddie;
    }

    public BuddyrequestsFacadeLocal getBuddyFacade() {
        return buddyFacade;
    }

    public void setBuddyFacade(BuddyrequestsFacadeLocal buddyFacade) {
        this.buddyFacade = buddyFacade;
    }

}
