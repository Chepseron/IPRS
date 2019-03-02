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
 * @author pos
 */
@Entity
@Table(name = "QUERY_LOG")
@NamedQueries({
    @NamedQuery(name = "QueryLog.findAll", query = "SELECT q FROM QueryLog q"),
    @NamedQuery(name = "QueryLog.findByAgencyId", query = "SELECT q FROM QueryLog q WHERE q.agencyId = :agencyId"),
    @NamedQuery(name = "QueryLog.findByAgencyUser", query = "SELECT q FROM QueryLog q WHERE q.agencyUser = :agencyUser"),
    @NamedQuery(name = "QueryLog.findByQueryResult", query = "SELECT q FROM QueryLog q WHERE q.queryResult = :queryResult"),
    @NamedQuery(name = "QueryLog.findByQueryTime", query = "SELECT q FROM QueryLog q WHERE q.queryTime = :queryTime"),
    @NamedQuery(name = "QueryLog.findByTid", query = "SELECT q FROM QueryLog q WHERE q.tid = :tid"),
    @NamedQuery(name = "QueryLog.findByAmountUsed", query = "SELECT q FROM QueryLog q WHERE q.amountUsed = :amountUsed"),
    @NamedQuery(name = "QueryLog.findByAmountspent", query = "SELECT q FROM QueryLog q WHERE q.amountspent = :amountspent")})
public class QueryLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AGENCY_ID")
    private String agencyId;
    @Column(name = "AGENCY_USER")
    private String agencyUser;
    @Column(name = "QUERY_RESULT")
    private String queryResult;
    @Column(name = "QUERY_TIME")
    @Temporal(TemporalType.DATE)
    private Date queryTime;
    @Id
    @Basic(optional = false)
    @Column(name = "TID")
    private BigDecimal tid;
    @Column(name = "AMOUNT_USED")
    private String amountUsed;
    @Column(name = "AMOUNTSPENT")
    private String amountspent;

    public QueryLog() {
    }

    public QueryLog(BigDecimal tid) {
        this.tid = tid;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyUser() {
        return agencyUser;
    }

    public void setAgencyUser(String agencyUser) {
        this.agencyUser = agencyUser;
    }

    public String getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(String queryResult) {
        this.queryResult = queryResult;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public BigDecimal getTid() {
        return tid;
    }

    public void setTid(BigDecimal tid) {
        this.tid = tid;
    }

    public String getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(String amountUsed) {
        this.amountUsed = amountUsed;
    }

    public String getAmountspent() {
        return amountspent;
    }

    public void setAmountspent(String amountspent) {
        this.amountspent = amountspent;
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
        if (!(object instanceof QueryLog)) {
            return false;
        }
        QueryLog other = (QueryLog) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.QueryLog[tid=" + tid + "]";
    }

}
