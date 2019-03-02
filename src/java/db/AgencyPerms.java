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
@Table(name = "AGENCY_PERMS")
@NamedQueries({
    @NamedQuery(name = "AgencyPerms.findAll", query = "SELECT a FROM AgencyPerms a"),
    @NamedQuery(name = "AgencyPerms.findByRid", query = "SELECT a FROM AgencyPerms a WHERE a.rid = :rid"),
    @NamedQuery(name = "AgencyPerms.findByPid", query = "SELECT a FROM AgencyPerms a WHERE a.pid = :pid"),
    @NamedQuery(name = "AgencyPerms.findByPin", query = "SELECT a FROM AgencyPerms a WHERE a.pin = :pin"),
    @NamedQuery(name = "AgencyPerms.findByName", query = "SELECT a FROM AgencyPerms a WHERE a.name = :name"),
    @NamedQuery(name = "AgencyPerms.findBySurn", query = "SELECT a FROM AgencyPerms a WHERE a.surn = :surn"),
    @NamedQuery(name = "AgencyPerms.findByLastName", query = "SELECT a FROM AgencyPerms a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "AgencyPerms.findBySex", query = "SELECT a FROM AgencyPerms a WHERE a.sex = :sex"),
    @NamedQuery(name = "AgencyPerms.findByYearBirth", query = "SELECT a FROM AgencyPerms a WHERE a.yearBirth = :yearBirth"),
    @NamedQuery(name = "AgencyPerms.findByMonthBirth", query = "SELECT a FROM AgencyPerms a WHERE a.monthBirth = :monthBirth"),
    @NamedQuery(name = "AgencyPerms.findByDayBirth", query = "SELECT a FROM AgencyPerms a WHERE a.dayBirth = :dayBirth"),
    @NamedQuery(name = "AgencyPerms.findByDateBirth", query = "SELECT a FROM AgencyPerms a WHERE a.dateBirth = :dateBirth"),
    @NamedQuery(name = "AgencyPerms.findByYearDeath", query = "SELECT a FROM AgencyPerms a WHERE a.yearDeath = :yearDeath"),
    @NamedQuery(name = "AgencyPerms.findByMonthDeath", query = "SELECT a FROM AgencyPerms a WHERE a.monthDeath = :monthDeath"),
    @NamedQuery(name = "AgencyPerms.findByDayDeath", query = "SELECT a FROM AgencyPerms a WHERE a.dayDeath = :dayDeath"),
    @NamedQuery(name = "AgencyPerms.findByEthnic", query = "SELECT a FROM AgencyPerms a WHERE a.ethnic = :ethnic"),
    @NamedQuery(name = "AgencyPerms.findByClan", query = "SELECT a FROM AgencyPerms a WHERE a.clan = :clan"),
    @NamedQuery(name = "AgencyPerms.findByFamily", query = "SELECT a FROM AgencyPerms a WHERE a.family = :family"),
    @NamedQuery(name = "AgencyPerms.findByAdrrefBirth", query = "SELECT a FROM AgencyPerms a WHERE a.adrrefBirth = :adrrefBirth"),
    @NamedQuery(name = "AgencyPerms.findByAdrrefLive", query = "SELECT a FROM AgencyPerms a WHERE a.adrrefLive = :adrrefLive"),
    @NamedQuery(name = "AgencyPerms.findByAdrrefDeath", query = "SELECT a FROM AgencyPerms a WHERE a.adrrefDeath = :adrrefDeath"),
    @NamedQuery(name = "AgencyPerms.findByOpid", query = "SELECT a FROM AgencyPerms a WHERE a.opid = :opid"),
    @NamedQuery(name = "AgencyPerms.findByCitiz", query = "SELECT a FROM AgencyPerms a WHERE a.citiz = :citiz"),
    @NamedQuery(name = "AgencyPerms.findByFinger01", query = "SELECT a FROM AgencyPerms a WHERE a.finger01 = :finger01"),
    @NamedQuery(name = "AgencyPerms.findByFinger02", query = "SELECT a FROM AgencyPerms a WHERE a.finger02 = :finger02"),
    @NamedQuery(name = "AgencyPerms.findByFinger03", query = "SELECT a FROM AgencyPerms a WHERE a.finger03 = :finger03"),
    @NamedQuery(name = "AgencyPerms.findByFinger04", query = "SELECT a FROM AgencyPerms a WHERE a.finger04 = :finger04"),
    @NamedQuery(name = "AgencyPerms.findByFinger05", query = "SELECT a FROM AgencyPerms a WHERE a.finger05 = :finger05"),
    @NamedQuery(name = "AgencyPerms.findByFinger06", query = "SELECT a FROM AgencyPerms a WHERE a.finger06 = :finger06"),
    @NamedQuery(name = "AgencyPerms.findByFinger07", query = "SELECT a FROM AgencyPerms a WHERE a.finger07 = :finger07"),
    @NamedQuery(name = "AgencyPerms.findByFinger08", query = "SELECT a FROM AgencyPerms a WHERE a.finger08 = :finger08"),
    @NamedQuery(name = "AgencyPerms.findByFinger09", query = "SELECT a FROM AgencyPerms a WHERE a.finger09 = :finger09"),
    @NamedQuery(name = "AgencyPerms.findByFinger10", query = "SELECT a FROM AgencyPerms a WHERE a.finger10 = :finger10"),
    @NamedQuery(name = "AgencyPerms.findByFingerMain", query = "SELECT a FROM AgencyPerms a WHERE a.fingerMain = :fingerMain"),
    @NamedQuery(name = "AgencyPerms.findByPhoto", query = "SELECT a FROM AgencyPerms a WHERE a.photo = :photo"),
    @NamedQuery(name = "AgencyPerms.findBySignature", query = "SELECT a FROM AgencyPerms a WHERE a.signature = :signature"),
    @NamedQuery(name = "AgencyPerms.findByDataScan", query = "SELECT a FROM AgencyPerms a WHERE a.dataScan = :dataScan"),
    @NamedQuery(name = "AgencyPerms.findByDateCreated", query = "SELECT a FROM AgencyPerms a WHERE a.dateCreated = :dateCreated"),
    @NamedQuery(name = "AgencyPerms.findByDateModified", query = "SELECT a FROM AgencyPerms a WHERE a.dateModified = :dateModified"),
    @NamedQuery(name = "AgencyPerms.findByModifiedBy", query = "SELECT a FROM AgencyPerms a WHERE a.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "AgencyPerms.findByCreatedBy", query = "SELECT a FROM AgencyPerms a WHERE a.createdBy = :createdBy"),
    @NamedQuery(name = "AgencyPerms.findByOccup", query = "SELECT a FROM AgencyPerms a WHERE a.occup = :occup"),
    @NamedQuery(name = "AgencyPerms.findByDateDeath", query = "SELECT a FROM AgencyPerms a WHERE a.dateDeath = :dateDeath"),
    @NamedQuery(name = "AgencyPerms.findByAgencyName", query = "SELECT a FROM AgencyPerms a WHERE a.agencyName = :agencyName"),
    @NamedQuery(name = "AgencyPerms.findByAgencyCategory", query = "SELECT a FROM AgencyPerms a WHERE a.agencyCategory = :agencyCategory"),
    @NamedQuery(name = "AgencyPerms.findByAgencyDescription", query = "SELECT a FROM AgencyPerms a WHERE a.agencyDescription = :agencyDescription"),
    @NamedQuery(name = "AgencyPerms.findByContactPerson", query = "SELECT a FROM AgencyPerms a WHERE a.contactPerson = :contactPerson"),
    @NamedQuery(name = "AgencyPerms.findByContactPhone", query = "SELECT a FROM AgencyPerms a WHERE a.contactPhone = :contactPhone"),
    @NamedQuery(name = "AgencyPerms.findByBill", query = "SELECT a FROM AgencyPerms a WHERE a.bill = :bill"),
    @NamedQuery(name = "AgencyPerms.findByTariff", query = "SELECT a FROM AgencyPerms a WHERE a.tariff = :tariff"),
    @NamedQuery(name = "AgencyPerms.findByAmountQueried", query = "SELECT a FROM AgencyPerms a WHERE a.amountQueried = :amountQueried"),
    @NamedQuery(name = "AgencyPerms.findByInitialpay", query = "SELECT a FROM AgencyPerms a WHERE a.initialpay = :initialpay"),
    @NamedQuery(name = "AgencyPerms.findByExpiryDate", query = "SELECT a FROM AgencyPerms a WHERE a.expiryDate = :expiryDate"),
    @NamedQuery(name = "AgencyPerms.findByDebt", query = "SELECT a FROM AgencyPerms a WHERE a.debt = :debt"),
    @NamedQuery(name = "AgencyPerms.findByBase", query = "SELECT a FROM AgencyPerms a WHERE a.base = :base"),
    @NamedQuery(name = "AgencyPerms.findByFrequency", query = "SELECT a FROM AgencyPerms a WHERE a.frequency = :frequency"),
    @NamedQuery(name = "AgencyPerms.findByTrial", query = "SELECT a FROM AgencyPerms a WHERE a.trial = :trial"),
    @NamedQuery(name = "AgencyPerms.findByTiered", query = "SELECT a FROM AgencyPerms a WHERE a.tiered = :tiered"),
    @NamedQuery(name = "AgencyPerms.findBySuspend", query = "SELECT a FROM AgencyPerms a WHERE a.suspend = :suspend"),
    @NamedQuery(name = "AgencyPerms.findByCreateDate", query = "SELECT a FROM AgencyPerms a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "AgencyPerms.findByAgencyId", query = "SELECT a FROM AgencyPerms a WHERE a.agencyId = :agencyId"),
    @NamedQuery(name = "AgencyPerms.findByUsers", query = "SELECT a FROM AgencyPerms a WHERE a.users = :users"),
    @NamedQuery(name = "AgencyPerms.findByHit", query = "SELECT a FROM AgencyPerms a WHERE a.hit = :hit")})
public class AgencyPerms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "RID")
    private String rid;
    @Column(name = "PID")
    private String pid;
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
    private String yearBirth;
    @Column(name = "MONTH_BIRTH")
    private String monthBirth;
    @Column(name = "DAY_BIRTH")
    private String dayBirth;
    @Column(name = "DATE_BIRTH")
    private String dateBirth;
    @Column(name = "YEAR_DEATH")
    private String yearDeath;
    @Column(name = "MONTH_DEATH")
    private String monthDeath;
    @Column(name = "DAY_DEATH")
    private String dayDeath;
    @Column(name = "ETHNIC")
    private String ethnic;
    @Column(name = "CLAN")
    private String clan;
    @Column(name = "FAMILY")
    private String family;
    @Column(name = "ADRREF_BIRTH")
    private String adrrefBirth;
    @Column(name = "ADRREF_LIVE")
    private String adrrefLive;
    @Column(name = "ADRREF_DEATH")
    private String adrrefDeath;
    @Column(name = "OPID")
    private String opid;
    @Column(name = "CITIZ")
    private String citiz;
    @Column(name = "FINGER_01")
    private String finger01;
    @Column(name = "FINGER_02")
    private String finger02;
    @Column(name = "FINGER_03")
    private String finger03;
    @Column(name = "FINGER_04")
    private String finger04;
    @Column(name = "FINGER_05")
    private String finger05;
    @Column(name = "FINGER_06")
    private String finger06;
    @Column(name = "FINGER_07")
    private String finger07;
    @Column(name = "FINGER_08")
    private String finger08;
    @Column(name = "FINGER_09")
    private String finger09;
    @Column(name = "FINGER_10")
    private String finger10;
    @Column(name = "FINGER_MAIN")
    private String fingerMain;
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "SIGNATURE")
    private String signature;
    @Column(name = "DATA_SCAN")
    private String dataScan;
    @Column(name = "DATE_CREATED")
    private String dateCreated;
    @Column(name = "DATE_MODIFIED")
    private String dateModified;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "OCCUP")
    private String occup;
    @Column(name = "DATE_DEATH")
    private String dateDeath;
    @Column(name = "AGENCY_NAME")
    private String agencyName;
    @Column(name = "AGENCY_CATEGORY")
    private String agencyCategory;
    @Column(name = "AGENCY_DESCRIPTION")
    private String agencyDescription;
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;
    @Column(name = "BILL")
    private String bill;
    @Column(name = "TARIFF")
    private String tariff;
    @Column(name = "AMOUNT_QUERIED")
    private BigInteger amountQueried;
    @Column(name = "INITIALPAY")
    private BigInteger initialpay;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "DEBT")
    private String debt;
    @Column(name = "BASE")
    private String base;
    @Column(name = "FREQUENCY")
    private String frequency;
    @Column(name = "TRIAL")
    private String trial;
    @Column(name = "TIERED")
    private String tiered;
    @Column(name = "SUSPEND")
    private String suspend;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Id
    @Basic(optional = false)
    @Column(name = "AGENCY_ID")
    private BigDecimal agencyId;
    @Column(name = "USERS")
    private Integer users;
    @Column(name = "HIT")
    private Integer hit;

    public AgencyPerms() {
    }

    public AgencyPerms(BigDecimal agencyId) {
        this.agencyId = agencyId;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
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

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getMonthBirth() {
        return monthBirth;
    }

    public void setMonthBirth(String monthBirth) {
        this.monthBirth = monthBirth;
    }

    public String getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(String dayBirth) {
        this.dayBirth = dayBirth;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getYearDeath() {
        return yearDeath;
    }

    public void setYearDeath(String yearDeath) {
        this.yearDeath = yearDeath;
    }

    public String getMonthDeath() {
        return monthDeath;
    }

    public void setMonthDeath(String monthDeath) {
        this.monthDeath = monthDeath;
    }

    public String getDayDeath() {
        return dayDeath;
    }

    public void setDayDeath(String dayDeath) {
        this.dayDeath = dayDeath;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
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

    public String getAdrrefBirth() {
        return adrrefBirth;
    }

    public void setAdrrefBirth(String adrrefBirth) {
        this.adrrefBirth = adrrefBirth;
    }

    public String getAdrrefLive() {
        return adrrefLive;
    }

    public void setAdrrefLive(String adrrefLive) {
        this.adrrefLive = adrrefLive;
    }

    public String getAdrrefDeath() {
        return adrrefDeath;
    }

    public void setAdrrefDeath(String adrrefDeath) {
        this.adrrefDeath = adrrefDeath;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public String getCitiz() {
        return citiz;
    }

    public void setCitiz(String citiz) {
        this.citiz = citiz;
    }

    public String getFinger01() {
        return finger01;
    }

    public void setFinger01(String finger01) {
        this.finger01 = finger01;
    }

    public String getFinger02() {
        return finger02;
    }

    public void setFinger02(String finger02) {
        this.finger02 = finger02;
    }

    public String getFinger03() {
        return finger03;
    }

    public void setFinger03(String finger03) {
        this.finger03 = finger03;
    }

    public String getFinger04() {
        return finger04;
    }

    public void setFinger04(String finger04) {
        this.finger04 = finger04;
    }

    public String getFinger05() {
        return finger05;
    }

    public void setFinger05(String finger05) {
        this.finger05 = finger05;
    }

    public String getFinger06() {
        return finger06;
    }

    public void setFinger06(String finger06) {
        this.finger06 = finger06;
    }

    public String getFinger07() {
        return finger07;
    }

    public void setFinger07(String finger07) {
        this.finger07 = finger07;
    }

    public String getFinger08() {
        return finger08;
    }

    public void setFinger08(String finger08) {
        this.finger08 = finger08;
    }

    public String getFinger09() {
        return finger09;
    }

    public void setFinger09(String finger09) {
        this.finger09 = finger09;
    }

    public String getFinger10() {
        return finger10;
    }

    public void setFinger10(String finger10) {
        this.finger10 = finger10;
    }

    public String getFingerMain() {
        return fingerMain;
    }

    public void setFingerMain(String fingerMain) {
        this.fingerMain = fingerMain;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDataScan() {
        return dataScan;
    }

    public void setDataScan(String dataScan) {
        this.dataScan = dataScan;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
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

    public String getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(String dateDeath) {
        this.dateDeath = dateDeath;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCategory() {
        return agencyCategory;
    }

    public void setAgencyCategory(String agencyCategory) {
        this.agencyCategory = agencyCategory;
    }

    public String getAgencyDescription() {
        return agencyDescription;
    }

    public void setAgencyDescription(String agencyDescription) {
        this.agencyDescription = agencyDescription;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public BigInteger getAmountQueried() {
        return amountQueried;
    }

    public void setAmountQueried(BigInteger amountQueried) {
        this.amountQueried = amountQueried;
    }

    public BigInteger getInitialpay() {
        return initialpay;
    }

    public void setInitialpay(BigInteger initialpay) {
        this.initialpay = initialpay;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getTrial() {
        return trial;
    }

    public void setTrial(String trial) {
        this.trial = trial;
    }

    public String getTiered() {
        return tiered;
    }

    public void setTiered(String tiered) {
        this.tiered = tiered;
    }

    public String getSuspend() {
        return suspend;
    }

    public void setSuspend(String suspend) {
        this.suspend = suspend;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(BigDecimal agencyId) {
        this.agencyId = agencyId;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agencyId != null ? agencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgencyPerms)) {
            return false;
        }
        AgencyPerms other = (AgencyPerms) object;
        if ((this.agencyId == null && other.agencyId != null) || (this.agencyId != null && !this.agencyId.equals(other.agencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AgencyPerms[agencyId=" + agencyId + "]";
    }

    /**
     * @return the users
     */
    public Integer getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Integer users) {
        this.users = users;
    }

    /**
     * @return the hit
     */
    public Integer getHit() {
        return hit;
    }

    /**
     * @param hit the hit to set
     */
    public void setHit(Integer hit) {
        this.hit = hit;
    }

}
