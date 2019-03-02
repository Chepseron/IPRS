/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "IPRS_AUDIT")
@NamedQueries({
    @NamedQuery(name = "IprsAudit.findAll", query = "SELECT i FROM IprsAudit i"),
    @NamedQuery(name = "IprsAudit.findByAction", query = "SELECT i FROM IprsAudit i WHERE i.action = :action"),
    @NamedQuery(name = "IprsAudit.findByTimestamp", query = "SELECT i FROM IprsAudit i WHERE i.timestamp = :timestamp"),
    @NamedQuery(name = "IprsAudit.findByAgencyId", query = "SELECT i FROM IprsAudit i WHERE i.agencyId = :agencyId"),
    @NamedQuery(name = "IprsAudit.findByTid", query = "SELECT i FROM IprsAudit i WHERE i.tid = :tid"),
    @NamedQuery(name = "IprsAudit.findByUserId", query = "SELECT i FROM IprsAudit i WHERE i.userId = :userId")})
public class IprsAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ACTION")
    private String action;
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "AGENCY_ID")
    private String agencyId;
    @Id
    @Basic(optional = false)
    @Column(name = "TID")
    private BigDecimal tid;
    @Column(name = "USER_ID")
    private String userId;

    public IprsAudit() {
    }

    public IprsAudit(BigDecimal tid) {
        this.tid = tid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public BigDecimal getTid() {
        return tid;
    }

    public void setTid(BigDecimal tid) {
        this.tid = tid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IprsAudit)) {
            return false;
        }
        IprsAudit other = (IprsAudit) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.IprsAudit[tid=" + tid + "]";
    }

}
