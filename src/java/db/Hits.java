/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "HITS")
@NamedQueries({
    @NamedQuery(name = "Hits.findAll", query = "SELECT h FROM Hits h"),
    @NamedQuery(name = "Hits.findById", query = "SELECT h FROM Hits h WHERE h.id = :id"),
    @NamedQuery(name = "Hits.findByHit", query = "SELECT h FROM Hits h WHERE h.hit = :hit"),
    @NamedQuery(name = "Hits.findByValue", query = "SELECT h FROM Hits h WHERE h.value = :value"),
    @NamedQuery(name = "Hits.findByMaximum", query = "SELECT h FROM Hits h WHERE h.maximum = :maximum"),
    @NamedQuery(name = "Hits.findByMinimum", query = "SELECT h FROM Hits h WHERE h.minimum = :minimum")})
public class Hits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "HIT")
    private String hit;
    @Column(name = "VALUE")
    private String value;
    @Column(name = "MAXIMUM")
    private Integer maximum;
    @Column(name = "MINIMUM")
    private Integer minimum;

    public Hits() {
    }

    public Hits(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof Hits)) {
            return false;
        }
        Hits other = (Hits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Hits[id=" + id + "]";
    }

    /**
     * @return the maximum
     */
    public Integer getMaximum() {
        return maximum;
    }

    /**
     * @param maximum the maximum to set
     */
    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    /**
     * @return the minimum
     */
    public Integer getMinimum() {
        return minimum;
    }

    /**
     * @param minimum the minimum to set
     */
    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

}
