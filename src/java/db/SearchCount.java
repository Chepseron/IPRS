/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
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
 * @author Ogutu
 */
@Entity
@Table(name = "SEARCH_COUNT")
@NamedQueries({
    @NamedQuery(name = "SearchCount.findAll", query = "SELECT s FROM SearchCount s"),
    @NamedQuery(name = "SearchCount.findByTid", query = "SELECT s FROM SearchCount s WHERE s.tid = :tid"),
    @NamedQuery(name = "SearchCount.findByAgencyId", query = "SELECT s FROM SearchCount s WHERE s.agencyId = :agencyId"),
    @NamedQuery(name = "SearchCount.findByAgencyUser", query = "SELECT s FROM SearchCount s WHERE s.agencyUser = :agencyUser"),
    @NamedQuery(name = "SearchCount.findBySearchDate", query = "SELECT s FROM SearchCount s WHERE s.searchDate = :searchDate"),
    @NamedQuery(name = "SearchCount.findBySessionId", query = "SELECT s FROM SearchCount s WHERE s.sessionId = :sessionId"),
    @NamedQuery(name = "SearchCount.findByDocumentId", query = "SELECT s FROM SearchCount s WHERE s.documentId = :documentId"),
    @NamedQuery(name = "SearchCount.findBySearchType", query = "SELECT s FROM SearchCount s WHERE s.searchType = :searchType"),
    @NamedQuery(name = "SearchCount.findBySearchResult", query = "SELECT s FROM SearchCount s WHERE s.searchResult = :searchResult")})
public class SearchCount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TID")
    private String tid;
    @Column(name = "AGENCY_ID")
    private String agencyId;
    @Column(name = "AGENCY_USER")
    private String agencyUser;
    @Column(name = "SEARCH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date searchDate;
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Column(name = "DOCUMENT_ID")
    private String documentId;
    @Column(name = "SEARCH_TYPE")
    private String searchType;
    @Column(name = "SEARCH_RESULT")
    private String searchResult;

    public SearchCount() {
    }

    public SearchCount(String tid) {
        this.tid = tid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
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

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
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
        if (!(object instanceof SearchCount)) {
            return false;
        }
        SearchCount other = (SearchCount) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SearchCount[tid=" + tid + "]";
    }

}
