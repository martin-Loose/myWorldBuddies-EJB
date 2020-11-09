/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlo0212
 */
@Entity
@Table(catalog = "myworld_buddies", schema = "")
@XmlRootElement
@NamedQueries({//named query fuer searchstring fehlt noch
    @NamedQuery(name = "Buddyrequests.findAll", query = "SELECT b FROM Buddyrequests b")
        , @NamedQuery(name = "Buddyrequests.findByStart", query = "SELECT b FROM Buddyrequests b WHERE b.id = :id")//searchKeyword+"%" means return values which starts with searchKeyword.
//"%"+searchKeyword+"%" means return values which contains searchKeyword.
    , @NamedQuery(name = "Buddyrequests.findByRequesterANDRequested", query = "SELECT b FROM Buddyrequests b WHERE b.requesterID = :requesterID AND b.requestedID = :requestedID")
    , @NamedQuery(name = "Buddyrequests.findByRequesterORRequested", query = "SELECT b FROM Buddyrequests b WHERE b.requesterID = :requesterID OR b.requestedID = :requesterID")
    , @NamedQuery(name = "Buddyrequests.findById", query = "SELECT b FROM Buddyrequests b WHERE b.id = :id")
    , @NamedQuery(name = "Buddyrequests.findByRequesterID", query = "SELECT b FROM Buddyrequests b WHERE b.requesterID = :requesterID")
    , @NamedQuery(name = "Buddyrequests.findByRequestedID", query = "SELECT b FROM Buddyrequests b WHERE b.requestedID = :requestedID")})
public class Buddyrequests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int requesterID;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int requestedID;

    public Buddyrequests() {
    }

    public Buddyrequests(Integer id) {
        this.id = id;
    }

    public Buddyrequests(Integer id, int requesterID, int requestedID) {
        this.id = id;
        this.requesterID = requesterID;
        this.requestedID = requestedID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(int requesterID) {
        this.requesterID = requesterID;
    }

    public int getRequestedID() {
        return requestedID;
    }

    public void setRequestedID(int requestedID) {
        this.requestedID = requestedID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buddyrequests)) {
            return false;
        }
        Buddyrequests other = (Buddyrequests) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Buddyrequests[ id=" + id + " ]";
    }
    
}
