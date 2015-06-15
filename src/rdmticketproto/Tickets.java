/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdmticketproto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Aggros the Wroth
 */
@Entity
@Table(name = "TICKETS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findByTnum", query = "SELECT t FROM Tickets t WHERE t.tnum = :tnum"),
    @NamedQuery(name = "Tickets.findBySnum", query = "SELECT t FROM Tickets t WHERE t.snum = :snum"),
    @NamedQuery(name = "Tickets.findByAda", query = "SELECT t FROM Tickets t WHERE t.ada = :ada")})
public class Tickets implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TNUM", nullable = false, length = 15)
    private String tnum;
    @Column(name = "SNUM", length = 10)
    private String snum;
    @Basic(optional = false)
    @Column(name = "ADA", nullable = false)
    private Boolean ada;

    public Tickets() {
    }

    public Tickets(String tnum) {
        this.tnum = tnum;
    }

    public Tickets(String tnum, Boolean ada) {
        this.tnum = tnum;
        this.ada = ada;
    }

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        String oldTnum = this.tnum;
        this.tnum = tnum;
        changeSupport.firePropertyChange("tnum", oldTnum, tnum);
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        String oldSnum = this.snum;
        this.snum = snum;
        changeSupport.firePropertyChange("snum", oldSnum, snum);
    }

    public Boolean getAda() {
        return ada;
    }

    public void setAda(Boolean ada) {
        Boolean oldAda = this.ada;
        this.ada = ada;
        changeSupport.firePropertyChange("ada", oldAda, ada);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tnum != null ? tnum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.tnum == null && other.tnum != null) || (this.tnum != null && !this.tnum.equals(other.tnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rdmticketproto.Tickets[ tnum=" + tnum + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
