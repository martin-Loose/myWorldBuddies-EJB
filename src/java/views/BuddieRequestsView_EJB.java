/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Buddyrequests;
import helperclass.myBuddyRequestsHelper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jpa.BuddyrequestsFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class BuddieRequestsView_EJB {
  private List<myBuddyRequestsHelper>alleREquests=new ArrayList<>();
  private myBuddyRequestsHelper selectedRequest;
  private Boolean toShow=false;
  @Inject
  private BuddyrequestsFacadeLocal requestFacade;

  /**
   wird ueberschrieben
     * @return 
   **/
    public List<myBuddyRequestsHelper> getAlleREquests() {
        System.err.println("in ejb");
        return null;
    }
/**
   wird ueberschrieben
     * @param alleREquests
   **/
    public void setAlleREquests(List<myBuddyRequestsHelper> alleREquests) {
        this.alleREquests = alleREquests;
    }

    public myBuddyRequestsHelper getSelectedRequest() {
        return selectedRequest;
    }

    public void setSelectedRequest(myBuddyRequestsHelper selectedRequest) {
        setToShow(true);
        this.selectedRequest = selectedRequest;
    }

    public Boolean getToShow() {
        return toShow;
    }

    public void setToShow(Boolean toShow) {
        this.toShow = toShow;
    }
  public void reset(){
      setToShow(false);
      setSelectedRequest(null);
  }
  //****************************************************************************** 
 
}
