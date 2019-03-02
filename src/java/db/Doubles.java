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
@Table(name = "DOUBLES")
@NamedQueries({
    @NamedQuery(name = "Doubles.findAll", query = "SELECT d FROM Doubles d"),
    @NamedQuery(name = "Doubles.findByRid", query = "SELECT d FROM Doubles d WHERE d.rid = :rid"),
    @NamedQuery(name = "Doubles.findByOPid", query = "SELECT d FROM Doubles d WHERE d.oPid = :oPid"),
    @NamedQuery(name = "Doubles.findByNDoc", query = "SELECT d FROM Doubles d WHERE d.nDoc = :nDoc"),
    @NamedQuery(name = "Doubles.findByDateMade", query = "SELECT d FROM Doubles d WHERE d.dateMade = :dateMade"),
    @NamedQuery(name = "Doubles.findByYearB", query = "SELECT d FROM Doubles d WHERE d.yearB = :yearB"),
    @NamedQuery(name = "Doubles.findByMonthB", query = "SELECT d FROM Doubles d WHERE d.monthB = :monthB"),
    @NamedQuery(name = "Doubles.findByDayB", query = "SELECT d FROM Doubles d WHERE d.dayB = :dayB"),
    @NamedQuery(name = "Doubles.findBySex", query = "SELECT d FROM Doubles d WHERE d.sex = :sex"),
    @NamedQuery(name = "Doubles.findBySurn", query = "SELECT d FROM Doubles d WHERE d.surn = :surn"),
    @NamedQuery(name = "Doubles.findByName", query = "SELECT d FROM Doubles d WHERE d.name = :name"),
    @NamedQuery(name = "Doubles.findByLastName", query = "SELECT d FROM Doubles d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "Doubles.findByXmlName", query = "SELECT d FROM Doubles d WHERE d.xmlName = :xmlName"),
    @NamedQuery(name = "Doubles.findByDateIncome", query = "SELECT d FROM Doubles d WHERE d.dateIncome = :dateIncome"),
    @NamedQuery(name = "Doubles.findByStatus", query = "SELECT d FROM Doubles d WHERE d.status = :status"),
    @NamedQuery(name = "Doubles.findByDateMods", query = "SELECT d FROM Doubles d WHERE d.dateMods = :dateMods"),
    @NamedQuery(name = "Doubles.findByCreatedBy", query = "SELECT d FROM Doubles d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "Doubles.findByXmlData", query = "SELECT d FROM Doubles d WHERE d.xmlData = :xmlData"),
    @NamedQuery(name = "Doubles.findByFinger01", query = "SELECT d FROM Doubles d WHERE d.finger01 = :finger01"),
    @NamedQuery(name = "Doubles.findByFinger02", query = "SELECT d FROM Doubles d WHERE d.finger02 = :finger02"),
    @NamedQuery(name = "Doubles.findByFinger03", query = "SELECT d FROM Doubles d WHERE d.finger03 = :finger03"),
    @NamedQuery(name = "Doubles.findByFinger04", query = "SELECT d FROM Doubles d WHERE d.finger04 = :finger04"),
    @NamedQuery(name = "Doubles.findByFinger05", query = "SELECT d FROM Doubles d WHERE d.finger05 = :finger05"),
    @NamedQuery(name = "Doubles.findByFinger06", query = "SELECT d FROM Doubles d WHERE d.finger06 = :finger06"),
    @NamedQuery(name = "Doubles.findByFinger07", query = "SELECT d FROM Doubles d WHERE d.finger07 = :finger07"),
    @NamedQuery(name = "Doubles.findByFinger08", query = "SELECT d FROM Doubles d WHERE d.finger08 = :finger08"),
    @NamedQuery(name = "Doubles.findByFinger09", query = "SELECT d FROM Doubles d WHERE d.finger09 = :finger09"),
    @NamedQuery(name = "Doubles.findByFinger10", query = "SELECT d FROM Doubles d WHERE d.finger10 = :finger10"),
    @NamedQuery(name = "Doubles.findByFingerMain", query = "SELECT d FROM Doubles d WHERE d.fingerMain = :fingerMain"),
    @NamedQuery(name = "Doubles.findByPhoto", query = "SELECT d FROM Doubles d WHERE d.photo = :photo"),
    @NamedQuery(name = "Doubles.findBySignature", query = "SELECT d FROM Doubles d WHERE d.signature = :signature"),
    @NamedQuery(name = "Doubles.findByCitiz", query = "SELECT d FROM Doubles d WHERE d.citiz = :citiz")})
public class Doubles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RID")
    private BigDecimal rid;
    @Column(name = "O_PID")
    private BigInteger oPid;
    @Column(name = "N_DOC")
    private BigInteger nDoc;
    @Column(name = "DATE_MADE")
    @Temporal(TemporalType.DATE)
    private Date dateMade;
    @Column(name = "YEAR_B")
    private Short yearB;
    @Column(name = "MONTH_B")
    private Short monthB;
    @Column(name = "DAY_B")
    private Short dayB;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "SURN")
    private String surn;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "XML_NAME")
    private String xmlName;
    @Column(name = "DATE_INCOME")
    @Temporal(TemporalType.DATE)
    private Date dateIncome;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DATE_MODS")
    @Temporal(TemporalType.DATE)
    private Date dateMods;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "XML_DATA")
    private String xmlData;
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
    @Column(name = "CITIZ")
    private Short citiz;
    @JoinColumn(name = "RID_D", referencedColumnName = "RID")
    @ManyToOne
    private Human human;

    public Doubles() {
    }

    public Doubles(BigDecimal rid) {
        this.rid = rid;
    }

    public BigDecimal getRid() {
        return rid;
    }

    public void setRid(BigDecimal rid) {
        this.rid = rid;
    }

    public BigInteger getOPid() {
        return oPid;
    }

    public void setOPid(BigInteger oPid) {
        this.oPid = oPid;
    }

    public BigInteger getNDoc() {
        return nDoc;
    }

    public void setNDoc(BigInteger nDoc) {
        this.nDoc = nDoc;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

    public Short getYearB() {
        return yearB;
    }

    public void setYearB(Short yearB) {
        this.yearB = yearB;
    }

    public Short getMonthB() {
        return monthB;
    }

    public void setMonthB(Short monthB) {
        this.monthB = monthB;
    }

    public Short getDayB() {
        return dayB;
    }

    public void setDayB(Short dayB) {
        this.dayB = dayB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSurn() {
        return surn;
    }

    public void setSurn(String surn) {
        this.surn = surn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public Date getDateIncome() {
        return dateIncome;
    }

    public void setDateIncome(Date dateIncome) {
        this.dateIncome = dateIncome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateMods() {
        return dateMods;
    }

    public void setDateMods(Date dateMods) {
        this.dateMods = dateMods;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
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

    public Short getCitiz() {
        return citiz;
    }

    public void setCitiz(Short citiz) {
        this.citiz = citiz;
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
        if (!(object instanceof Doubles)) {
            return false;
        }
        Doubles other = (Doubles) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Doubles[rid=" + rid + "]";
    }

}
