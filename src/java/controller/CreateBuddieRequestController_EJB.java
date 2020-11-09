/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import entities.Buddyrequests;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.BuddiesFacadeLocal;
import jpa.BuddyrequestsFacadeLocal;




/**
 *
 * @author marlo0212
 */
public class CreateBuddieRequestController_EJB {

  @Inject
  private BuddyrequestsFacadeLocal buddyRequestFacade;
  @Inject
  private BuddiesFacadeLocal buddiesFacade;
  
  public void createRequest(int userID,int selectedUserID){
  try{
   if(userID==selectedUserID){
    FacesContext.getCurrentInstance().addMessage("userDetail",
                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Request impossible", "No different UserID detected"));
   }

  if(userID!=selectedUserID && requestFromUserExists(userID, selectedUserID)==false 
          && requestFromRequestedExists(userID, selectedUserID)==false
          &&buddyExist(userID, selectedUserID)==false){
  Buddyrequests myRequest=new Buddyrequests();
  myRequest.setId(0);
  myRequest.setRequesterID(userID);
  myRequest.setRequestedID(selectedUserID);
  buddyRequestFacade.create(myRequest);
   FacesContext.getCurrentInstance().addMessage("userDetail",
                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Request created", "Request created"));
  }
  }catch(Exception e){
      System.err.println("error: "+e.getMessage());
  }
  }
 //

  private Boolean buddyExist(int userID,int selectedUserID){
  boolean check=true;
  try{
  check=buddiesFacade.existBuddy(userID,selectedUserID)!=null;
  if(check==true){
    FacesContext.getCurrentInstance().addMessage("userDetail",
                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Request impossible - Buddy found", "Request created"));
  }
     
  }catch(Exception e){
      
  }
      return check;
  }
  private Boolean requestFromUserExists(int requesterId, int requestedID){
  boolean check=true;
  try{
      System.err.println("reqFromUser: "+ requesterId + " -- "+requestedID);
      if(buddyRequestFacade.findByRequesterANDRequested(requesterId,requestedID)==null){//request vom user an angefragten ?
         check= false;
        
      }else if(buddyRequestFacade.findByRequesterANDRequested(requesterId,requestedID)!=null){//request vom user an angefragten ?
            FacesContext.getCurrentInstance().addMessage("userDetail:request",
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Request exist", "Request exist"));
          check=true;
        
      }
  }catch(Exception e){
  }
  
  return check;
  }
 private Boolean requestFromRequestedExists(int requesterId, int requestedID){
  boolean check=true;
  try{
      if(buddyRequestFacade.findByRequesterANDRequested(requestedID,requesterId)==null){//request vom user an angefragten ?
         check=false;
      }else if(buddyRequestFacade.findByRequesterANDRequested(requestedID,requesterId)!=null){//request vom user an angefragten ?
           FacesContext.getCurrentInstance().addMessage("detailForm:username",
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Request exist", "Your answere is needed"));
          check=true;
      }
  }catch(Exception e){
  }
  
  return check;
  }

   
 
}
