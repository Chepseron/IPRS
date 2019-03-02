/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "DOCUMS")
@NamedQueries({
    @NamedQuery(name = "Docums.findAll", query = "SELECT d FROM Docums d"),
    @NamedQuery(name = "Docums.findByRid", query = "SELECT d FROM Docums d WHERE d.rid = :rid"),
    @NamedQuery(name = "Docums.findByPid", query = "SELECT d FROM Docums d WHERE d.pid = :pid"),
    @NamedQuery(name = "Docums.findByType", query = "SELECT d FROM Docums d WHERE d.type = :type"),
    @NamedQuery(name = "Docums.findByDatProduct", query = "SELECT d FROM Docums d WHERE d.datProduct = :datProduct"),
    @NamedQuery(name = "Docums.findByBgnData", query = "SELECT d FROM Docums d WHERE d.bgnData = :bgnData"),
    @NamedQuery(name = "Docums.findByEndData", query = "SELECT d FROM Docums d WHERE d.endData = :endData"),
    @NamedQuery(name = "Docums.findByDateModified", query = "SELECT d FROM Docums d WHERE d.dateModified = :dateModified"),
    @NamedQuery(name = "Docums.findByDateCreated", query = "SELECT d FROM Docums d WHERE d.dateCreated = :dateCreated"),
    @NamedQuery(name = "Docums.findByCreatedBy", query = "SELECT d FROM Docums d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "Docums.findByModifiedBy", query = "SELECT d FROM Docums d WHERE d.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Docums.findBySerNum", query = "SELECT d FROM Docums d WHERE d.serNum = :serNum")})
public class Docums implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RID")
    private BigDecimal rid;
    @Column(name = "PID")
    private BigInteger pid;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "DAT_PRODUCT")
    @Temporal(TemporalType.DATE)
    private Date datProduct;
    @Column(name = "BGN_DATA")
    @Temporal(TemporalType.DATE)
    private Date bgnData;
    @Column(name = "END_DATA")
    @Temporal(TemporalType.DATE)
    private Date endData;
    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.DATE)
    private Date dateModified;
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Lob
    @Column(name = "DOC_REKV")
    private String docRekv;
    @Column(name = "SER_NUM")
    private String serNum;
    @JoinColumn(name = "RID_H", referencedColumnName = "RID")
    @ManyToOne
    private Human human;

    public Docums() {
    }

    public Docums(BigDecimal rid) {
        this.rid = rid;
    }

    public BigDecimal getRid() {
        return rid;
    }

    public void setRid(BigDecimal rid) {
        this.rid = rid;
    }

    public BigInteger getPid() {
        return pid;
    }

    public void setPid(BigInteger pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatProduct() {
        return datProduct;
    }

    public void setDatProduct(Date datProduct) {
        this.datProduct = datProduct;
    }

    public Date getBgnData() {
        return bgnData;
    }

    public void setBgnData(Date bgnData) {
        this.bgnData = bgnData;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docums)) {
            return false;
        }
        Docums other = (Docums) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Docums[rid=" + rid + "]";
    }

    /**
     * @return the docRekv
     */
    public String getDocRekv() {
        return docRekv;
    }

    /**
     * @param docRekv the docRekv to set
     */
    public void setDocRekv(String docRekv) {
        this.docRekv = docRekv;
    }

}
