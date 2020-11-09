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
@NamedQueries({
    @NamedQuery(name = "Blockedbuddie.findAll", query = "SELECT b FROM Blockedbuddie b")
    , @NamedQuery(name = "Blockedbuddie.findById", query = "SELECT b FROM Blockedbuddie b WHERE b.id = :id")
    , @NamedQuery(name = "Blockedbuddie.findByBlockerID", query = "SELECT b FROM Blockedbuddie b WHERE b.blockerID = :blockerID")
    , @NamedQuery(name = "Blockedbuddie.findByBlockedID", query = "SELECT b FROM Blockedbuddie b WHERE b.blockedID = :blockedID")})
public class Blockedbuddie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int blockerID;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int blockedID;

    public Blockedbuddie() {
    }

    public Blockedbuddie(Integer id) {
        this.id = id;
    }

    public Blockedbuddie(Integer id, int blockerID, int blockedID) {
        this.id = id;
        this.blockerID = blockerID;
        this.blockedID = blockedID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBlockerID() {
        return blockerID;
    }

    public void setBlockerID(int blockerID) {
        this.blockerID = blockerID;
    }

    public int getBlockedID() {
        return blockedID;
    }

    public void setBlockedID(int blockedID) {
        this.blockedID = blockedID;
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
        if (!(object instanceof Blockedbuddie)) {
            return false;
        }
        Blockedbuddie other = (Blockedbuddie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Blockedbuddie[ id=" + id + " ]";
    }
    
}
