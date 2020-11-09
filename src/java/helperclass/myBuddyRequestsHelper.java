/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclass;

/**
 *
 * @author marlo0212
 */
public class myBuddyRequestsHelper {
  private String requester;
 private String requested;
 private int id;
 private int requesterID;
 private int requestED_ID;

    public myBuddyRequestsHelper() {
    }

    public myBuddyRequestsHelper(String requester, String requested, int id) {
        this.requester = requester;
        this.requested = requested;
        this.id = id;
    }

        

        public String getRequester() {
            return requester;
        }

        public void setRequester(String requester) {
            this.requester = requester;
        }

        public String getRequested() {
            return requested;
        }

        public void setRequested(String requested) {
            this.requested = requested;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public int getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(int requesterID) {
        this.requesterID = requesterID;
    }

    public int getRequestED_ID() {
        return requestED_ID;
    }

    public void setRequestED_ID(int requestED_ID) {
        this.requestED_ID = requestED_ID;
    }

    @Override
    public String toString() {
        return "\nRequester: "+getRequester()+"\n"
               + "RequesterID: "+getRequesterID()+"\n"
               + "RequestED: "+getRequested()+"\n"
                 + "RequestED_ID: "+getRequestED_ID()+"\n";
    }

  
 
        
    
}
