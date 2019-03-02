/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HUMAN")
@NamedQueries({
    @NamedQuery(name = "Human.findAll", query = "SELECT h FROM Human h"),
    @NamedQuery(name = "Human.findByRid", query = "SELECT h FROM Human h WHERE h.rid = :rid"),
    @NamedQuery(name = "Human.findByPid", query = "SELECT h FROM Human h WHERE h.pid = :pid"),
    @NamedQuery(name = "Human.findByPin", query = "SELECT h FROM Human h WHERE h.pin = :pin"),
    @NamedQuery(name = "Human.findByName", query = "SELECT h FROM Human h WHERE h.name = :name"),
    @NamedQuery(name = "Human.findBySurn", query = "SELECT h FROM Human h WHERE h.surn = :surn"),
    @NamedQuery(name = "Human.findByLastName", query = "SELECT h FROM Human h WHERE h.lastName = :lastName"),
    @NamedQuery(name = "Human.findBySex", query = "SELECT h FROM Human h WHERE h.sex = :sex"),
    @NamedQuery(name = "Human.findByYearBirth", query = "SELECT h FROM Human h WHERE h.yearBirth = :yearBirth"),
    @NamedQuery(name = "Human.findByMonthBirth", query = "SELECT h FROM Human h WHERE h.monthBirth = :monthBirth"),
    @NamedQuery(name = "Human.findByDayBirth", query = "SELECT h FROM Human h WHERE h.dayBirth = :dayBirth"),
    @NamedQuery(name = "Human.findByDateBirth", query = "SELECT h FROM Human h WHERE h.dateBirth = :dateBirth"),
    @NamedQuery(name = "Human.findByYearDeath", query = "SELECT h FROM Human h WHERE h.yearDeath = :yearDeath"),
    @NamedQuery(name = "Human.findByMonthDeath", query = "SELECT h FROM Human h WHERE h.monthDeath = :monthDeath"),
    @NamedQuery(name = "Human.findByDayDeath", query = "SELECT h FROM Human h WHERE h.dayDeath = :dayDeath"),
    @NamedQuery(name = "Human.findByEthnic", query = "SELECT h FROM Human h WHERE h.ethnic = :ethnic"),
    @NamedQuery(name = "Human.findByClan", query = "SELECT h FROM Human h WHERE h.clan = :clan"),
    @NamedQuery(name = "Human.findByFamily", query = "SELECT h FROM Human h WHERE h.family = :family"),
    @NamedQuery(name = "Human.findByOPid", query = "SELECT h FROM Human h WHERE h.oPid = :oPid"),
    @NamedQuery(name = "Human.findByCitiz", query = "SELECT h FROM Human h WHERE h.citiz = :citiz"),
    @NamedQuery(name = "Human.findByFinger01", query = "SELECT h FROM Human h WHERE h.finger01 = :finger01"),
    @NamedQuery(name = "Human.findByFinger02", query = "SELECT h FROM Human h WHERE h.finger02 = :finger02"),
    @NamedQuery(name = "Human.findByFinger03", query = "SELECT h FROM Human h WHERE h.finger03 = :finger03"),
    @NamedQuery(name = "Human.findByFinger04", query = "SELECT h FROM Human h WHERE h.finger04 = :finger04"),
    @NamedQuery(name = "Human.findByFinger05", query = "SELECT h FROM Human h WHERE h.finger05 = :finger05"),
    @NamedQuery(name = "Human.findByFinger06", query = "SELECT h FROM Human h WHERE h.finger06 = :finger06"),
    @NamedQuery(name = "Human.findByFinger07", query = "SELECT h FROM Human h WHERE h.finger07 = :finger07"),
    @NamedQuery(name = "Human.findByFinger08", query = "SELECT h FROM Human h WHERE h.finger08 = :finger08"),
    @NamedQuery(name = "Human.findByFinger09", query = "SELECT h FROM Human h WHERE h.finger09 = :finger09"),
    @NamedQuery(name = "Human.findByFinger10", query = "SELECT h FROM Human h WHERE h.finger10 = :finger10"),
    @NamedQuery(name = "Human.findByFingerMain", query = "SELECT h FROM Human h WHERE h.fingerMain = :fingerMain"),
    @NamedQuery(name = "Human.findByPhoto", query = "SELECT h FROM Human h WHERE h.photo = :photo"),
    @NamedQuery(name = "Human.findBySignature", query = "SELECT h FROM Human h WHERE h.signature = :signature"),
    @NamedQuery(name = "Human.findByDataScan", query = "SELECT h FROM Human h WHERE h.dataScan = :dataScan"),
    @NamedQuery(name = "Human.findByDateCreated", query = "SELECT h FROM Human h WHERE h.dateCreated = :dateCreated"),
    @NamedQuery(name = "Human.findByDateModified", query = "SELECT h FROM Human h WHERE h.dateModified = :dateModified"),
    @NamedQuery(name = "Human.findByModifiedBy", query = "SELECT h FROM Human h WHERE h.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Human.findByCreatedBy", query = "SELECT h FROM Human h WHERE h.createdBy = :createdBy"),
    @NamedQuery(name = "Human.findByOccup", query = "SELECT h FROM Human h WHERE h.occup = :occup"),
    @NamedQuery(name = "Human.findByDateDeath", query = "SELECT h FROM Human h WHERE h.dateDeath = :dateDeath")})
public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RID")
    private BigDecimal rid;
    @Basic(optional = false)
    @Column(name = "PID")
    private BigInteger pid;
    @Column(name = "PIN")
    private String pin;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURN")
    private String surn;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "YEAR_BIRTH")
    private Short yearBirth;
    @Column(name = "MONTH_BIRTH")
    private Short monthBirth;
    @Column(name = "DAY_BIRTH")
    private Short dayBirth;
    @Column(name = "DATE_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Column(name = "YEAR_DEATH")
    private String yearDeath;
    @Column(name = "MONTH_DEATH")
    private Short monthDeath;
    @Column(name = "DAY_DEATH")
    private BigInteger dayDeath;
    @Column(name = "ETHNIC")
    private BigInteger ethnic;
    @Column(name = "CLAN")
    private String clan;
    @Column(name = "FAMILY")
    private String family;
    @Column(name = "O_PID")
    private BigInteger oPid;
    @Column(name = "CITIZ")
    private Short citiz;
    @Column(name = "FINGER_01")
    private BigInteger finger01;
    @Column(name = "FINGER_02")
    private BigInteger finger02;
    @Column(name = "FINGER_03")
    private BigInteger finger03;
    @Column(name = "FINGER_04")
    private BigInteger finger04;
    @Column(name = "FINGER_05")
    private BigInteger finger05;
    @Column(name = "FINGER_06")
    private BigInteger finger06;
    @Column(name = "FINGER_07")
    private BigInteger finger07;
    @Column(name = "FINGER_08")
    private BigInteger finger08;
    @Column(name = "FINGER_09")
    private BigInteger finger09;
    @Column(name = "FINGER_10")
    private BigInteger finger10;
    @Column(name = "FINGER_MAIN")
    private BigInteger fingerMain;
    @Column(name = "PHOTO")
    private BigInteger photo;
    @Column(name = "SIGNATURE")
    private BigInteger signature;
    @Column(name = "DATA_SCAN")
    @Temporal(TemporalType.DATE)
    private Date dataScan;
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
    @Column(name = "OCCUP")
    private String occup;
    @Column(name = "DATE_DEATH")
    @Temporal(TemporalType.DATE)
    private Date dateDeath;
    @JoinColumn(name = "ADRREF_LIVE", referencedColumnName = "RID")
    @ManyToOne
    private Address address;
    @JoinColumn(name = "ADRREF_BIRTH", referencedColumnName = "RID")
    @ManyToOne
    private Address address1;
    @JoinColumn(name = "ADRREF_DEATH", referencedColumnName = "RID")
    @ManyToOne
    private Address address2;
    @OneToMany(mappedBy = "human")
    private Collection<Docums> documsCollection;

    public Human() {
    }

    public Human(BigDecimal rid) {
        this.rid = rid;
    }

    public Human(BigDecimal rid, BigInteger pid) {
        this.rid = rid;
        this.pid = pid;
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurn() {
        return surn;
    }

    public void setSurn(String surn) {
        this.surn = surn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Short getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(Short yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Short getMonthBirth() {
        return monthBirth;
    }

    public void setMonthBirth(Short monthBirth) {
        this.monthBirth = monthBirth;
    }

    public Short getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(Short dayBirth) {
        this.dayBirth = dayBirth;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getYearDeath() {
        return yearDeath;
    }

    public void setYearDeath(String yearDeath) {
        this.yearDeath = yearDeath;
    }

    public Short getMonthDeath() {
        return monthDeath;
    }

    public void setMonthDeath(Short monthDeath) {
        this.monthDeath = monthDeath;
    }

    public BigInteger getDayDeath() {
        return dayDeath;
    }

    public void setDayDeath(BigInteger dayDeath) {
        this.dayDeath = dayDeath;
    }

    public BigInteger getEthnic() {
        return ethnic;
    }

    public void setEthnic(BigInteger ethnic) {
        this.ethnic = ethnic;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public BigInteger getOPid() {
        return oPid;
    }

    public void setOPid(BigInteger oPid) {
        this.oPid = oPid;
    }

    public Short getCitiz() {
        return citiz;
    }

    public void setCitiz(Short citiz) {
        this.citiz = citiz;
    }

    public BigInteger getFinger01() {
        return finger01;
    }

    public void setFinger01(BigInteger finger01) {
        this.finger01 = finger01;
    }

    public BigInteger getFinger02() {
        return finger02;
    }

    public void setFinger02(BigInteger finger02) {
        this.finger02 = finger02;
    }

    public BigInteger getFinger03() {
        return finger03;
    }

    public void setFinger03(BigInteger finger03) {
        this.finger03 = finger03;
    }

    public BigInteger getFinger04() {
        return finger04;
    }

    public void setFinger04(BigInteger finger04) {
        this.finger04 = finger04;
    }

    public BigInteger getFinger05() {
        return finger05;
    }

    public void setFinger05(BigInteger finger05) {
        this.finger05 = finger05;
    }

    public BigInteger getFinger06() {
        return finger06;
    }

    public void setFinger06(BigInteger finger06) {
        this.finger06 = finger06;
    }

    public BigInteger getFinger07() {
        return finger07;
    }

    public void setFinger07(BigInteger finger07) {
        this.finger07 = finger07;
    }

    public BigInteger getFinger08() {
        return finger08;
    }

    public void setFinger08(BigInteger finger08) {
        this.finger08 = finger08;
    }

    public BigInteger getFinger09() {
        return finger09;
    }

    public void setFinger09(BigInteger finger09) {
        this.finger09 = finger09;
    }

    public BigInteger getFinger10() {
        return finger10;
    }

    public void setFinger10(BigInteger finger10) {
        this.finger10 = finger10;
    }

    public BigInteger getFingerMain() {
        return fingerMain;
    }

    public void setFingerMain(BigInteger fingerMain) {
        this.fingerMain = fingerMain;
    }

    public BigInteger getPhoto() {
        return photo;
    }

    public void setPhoto(BigInteger photo) {
        this.photo = photo;
    }

    public BigInteger getSignature() {
        return signature;
    }

    public void setSignature(BigInteger signature) {
        this.signature = signature;
    }

    public Date getDataScan() {
        return dataScan;
    }

    public void setDataScan(Date dataScan) {
        this.dataScan = dataScan;
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

    public String getOccup() {
        return occup;
    }

    public void setOccup(String occup) {
        this.occup = occup;
    }

    public Date getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(Date dateDeath) {
        this.dateDeath = dateDeath;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }

    public Collection<Docums> getDocumsCollection() {
        return documsCollection;
    }

    public void setDocumsCollection(Collection<Docums> documsCollection) {
        this.documsCollection = documsCollection;
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
        if (!(object instanceof Human)) {
            return false;
        }
        Human other = (Human) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Human[rid=" + rid + "]";
    }

}
