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
@Table(name = "STUDENTS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findBySnum", query = "SELECT s FROM Students s WHERE s.snum = :snum")})
public class Students implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SNUM", nullable = false, length = 10)
    private String snum;

    public Students() {
    }

    public Students(String snum) {
        this.snum = snum;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        String oldSnum = this.snum;
        this.snum = snum;
        changeSupport.firePropertyChange("snum", oldSnum, snum);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (snum != null ? snum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.snum == null && other.snum != null) || (this.snum != null && !this.snum.equals(other.snum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rdmticketproto.Students[ snum=" + snum + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
