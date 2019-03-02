/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByMinimum", query = "SELECT u FROM Users u WHERE u.minimum = :minimum"),
    @NamedQuery(name = "Users.findByMaximum", query = "SELECT u FROM Users u WHERE u.maximum = :maximum"),
    @NamedQuery(name = "Users.findByValue", query = "SELECT u FROM Users u WHERE u.value = :value")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Column(name = "MINIMUM")
    private Integer minimum;
    @Column(name = "MAXIMUM")
    private Integer maximum;
    @Column(name = "VALUE")
    private String value;

    public Users() {
    }

    public Users(BigDecimal userId) {
        this.userId = userId;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Users[userId=" + userId + "]";
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

}
