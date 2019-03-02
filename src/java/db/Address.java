/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "ADDRESS")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByRid", query = "SELECT a FROM Address a WHERE a.rid = :rid"),
    @NamedQuery(name = "Address.findByCnt", query = "SELECT a FROM Address a WHERE a.cnt = :cnt"),
    @NamedQuery(name = "Address.findByProv", query = "SELECT a FROM Address a WHERE a.prov = :prov"),
    @NamedQuery(name = "Address.findByConstit", query = "SELECT a FROM Address a WHERE a.constit = :constit"),
    @NamedQuery(name = "Address.findByDistr", query = "SELECT a FROM Address a WHERE a.distr = :distr"),
    @NamedQuery(name = "Address.findByDivision", query = "SELECT a FROM Address a WHERE a.division = :division"),
    @NamedQuery(name = "Address.findByLocation", query = "SELECT a FROM Address a WHERE a.location = :location"),
    @NamedQuery(name = "Address.findBySublocat", query = "SELECT a FROM Address a WHERE a.sublocat = :sublocat"),
    @NamedQuery(name = "Address.findByVillage", query = "SELECT a FROM Address a WHERE a.village = :village"),
    @NamedQuery(name = "Address.findByHomeAdr", query = "SELECT a FROM Address a WHERE a.homeAdr = :homeAdr"),
    @NamedQuery(name = "Address.findByDateCreated", query = "SELECT a FROM Address a WHERE a.dateCreated = :dateCreated"),
    @NamedQuery(name = "Address.findByDateModified", query = "SELECT a FROM Address a WHERE a.dateModified = :dateModified"),
    @NamedQuery(name = "Address.findByModifiedBy", query = "SELECT a FROM Address a WHERE a.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Address.findByCreatedBy", query = "SELECT a FROM Address a WHERE a.createdBy = :createdBy")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RID")
    private BigDecimal rid;
    @Column(name = "CNT")
    private String cnt;
    @Column(name = "PROV")
    private String prov;
    @Column(name = "CONSTIT")
    private String constit;
    @Column(name = "DISTR")
    private String distr;
    @Column(name = "DIVISION")
    private String division;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "SUBLOCAT")
    private String sublocat;
    @Column(name = "VILLAGE")
    private String village;
    @Column(name = "HOME_ADR")
    private String homeAdr;
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.DATE)
    private Date dateModified;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @OneToMany(mappedBy = "address")
    private Collection<Human> humanCollection;
    @OneToMany(mappedBy = "address1")
    private Collection<Human> humanCollection1;
    @OneToMany(mappedBy = "address2")
    private Collection<Human> humanCollection2;

    public Address() {
    }

    public Address(BigDecimal rid) {
        this.rid = rid;
    }

    public BigDecimal getRid() {
        return rid;
    }

    public void setRid(BigDecimal rid) {
        this.rid = rid;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getConstit() {
        return constit;
    }

    public void setConstit(String constit) {
        this.constit = constit;
    }

    public String getDistr() {
        return distr;
    }

    public void setDistr(String distr) {
        this.distr = distr;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSublocat() {
        return sublocat;
    }

    public void setSublocat(String sublocat) {
        this.sublocat = sublocat;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getHomeAdr() {
        return homeAdr;
    }

    public void setHomeAdr(String homeAdr) {
        this.homeAdr = homeAdr;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Collection<Human> getHumanCollection() {
        return humanCollection;
    }

    public void setHumanCollection(Collection<Human> humanCollection) {
        this.humanCollection = humanCollection;
    }

    public Collection<Human> getHumanCollection1() {
        return humanCollection1;
    }

    public void setHumanCollection1(Collection<Human> humanCollection1) {
        this.humanCollection1 = humanCollection1;
    }

    public Collection<Human> getHumanCollection2() {
        return humanCollection2;
    }

    public void setHumanCollection2(Collection<Human> humanCollection2) {
        this.humanCollection2 = humanCollection2;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Address[rid=" + rid + "]";
    }

}
