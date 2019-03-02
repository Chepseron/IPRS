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
@Table(name = "WHITE_LIST")
@NamedQueries({
    @NamedQuery(name = "WhiteList.findAll", query = "SELECT w FROM WhiteList w"),
    @NamedQuery(name = "WhiteList.findByTid", query = "SELECT w FROM WhiteList w WHERE w.tid = :tid"),
    @NamedQuery(name = "WhiteList.findByName", query = "SELECT w FROM WhiteList w WHERE w.name = :name"),
    @NamedQuery(name = "WhiteList.findByIdPpt", query = "SELECT w FROM WhiteList w WHERE w.idPpt = :idPpt"),
    @NamedQuery(name = "WhiteList.findByAgencyId", query = "SELECT w FROM WhiteList w WHERE w.agencyId = :agencyId"),
    @NamedQuery(name = "WhiteList.findByDateSaved", query = "SELECT w FROM WhiteList w WHERE w.dateSaved = :dateSaved")})
public class WhiteList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TID")
    private String tid;
    @Column(name = "NAME")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PPT")
    private String idPpt;
    @Column(name = "AGENCY_ID")
    private String agencyId;
    @Column(name = "DATE_SAVED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSaved;

    public WhiteList() {
    }

    public WhiteList(String idPpt) {
        this.idPpt = idPpt;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdPpt() {
        return idPpt;
    }

    public void setIdPpt(String idPpt) {
        this.idPpt = idPpt;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public Date getDateSaved() {
        return dateSaved;
    }

    public void setDateSaved(Date dateSaved) {
        this.dateSaved = dateSaved;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPpt != null ? idPpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WhiteList)) {
            return false;
        }
        WhiteList other = (WhiteList) object;
        if ((this.idPpt == null && other.idPpt != null) || (this.idPpt != null && !this.idPpt.equals(other.idPpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.WhiteList[idPpt=" + idPpt + "]";
    }

}
