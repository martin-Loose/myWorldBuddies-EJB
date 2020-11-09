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
    @NamedQuery(name = "Buddies.findAll", query = "SELECT b FROM Buddies b")
, @NamedQuery(name = "Buddies.findById", query = "SELECT b FROM Buddies b WHERE b.id = :id")
, @NamedQuery(name = "Buddies.findByBuddie1id", query = "SELECT b FROM Buddies b WHERE b.buddie1id = :buddie1id")
, @NamedQuery(name = "Buddies.findMyBuddies", query = "SELECT b FROM Buddies b WHERE b.buddie1id = :buddie1id")     
, @NamedQuery(name = "Buddies.buddyExist", query = "SELECT b FROM Buddies b WHERE b.buddie1id = :buddie1id AND b.buddie2id =:buddie2id")     
, @NamedQuery(name = "Buddies.findByBuddie2id", query = "SELECT b FROM Buddies b WHERE b.buddie2id = :buddie2id")})
public class Buddies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int buddie1id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int buddie2id;

    public Buddies() {
    }

    public Buddies(Integer id) {
        this.id = id;
    }

    public Buddies(Integer id, int buddie1id, int buddie2id) {
        this.id = id;
        this.buddie1id = buddie1id;
        this.buddie2id = buddie2id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBuddie1id() {
        return buddie1id;
    }

    public void setBuddie1id(int buddie1id) {
        this.buddie1id = buddie1id;
    }

    public int getBuddie2id() {
        return buddie2id;
    }

    public void setBuddie2id(int buddie2id) {
        this.buddie2id = buddie2id;
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
        if (!(object instanceof Buddies)) {
            return false;
        }
        Buddies other = (Buddies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Buddies[ id=" + id + " ]";
    }
    
}
