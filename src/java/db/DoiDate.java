/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
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
@Table(name = "DOI_DATE")
@NamedQueries({
    @NamedQuery(name = "DoiDate.findAll", query = "SELECT d FROM DoiDate d"),
    @NamedQuery(name = "DoiDate.findByTrackingId", query = "SELECT d FROM DoiDate d WHERE d.trackingId = :trackingId"),
    @NamedQuery(name = "DoiDate.findByPassportNo", query = "SELECT d FROM DoiDate d WHERE d.passportNo = :passportNo"),
    @NamedQuery(name = "DoiDate.findByIssueDate", query = "SELECT d FROM DoiDate d WHERE d.issueDate = :issueDate"),
    @NamedQuery(name = "DoiDate.findByExpiryDate", query = "SELECT d FROM DoiDate d WHERE d.expiryDate = :expiryDate"),
    @NamedQuery(name = "DoiDate.findByIdentityCardNo", query = "SELECT d FROM DoiDate d WHERE d.identityCardNo = :identityCardNo"),
    @NamedQuery(name = "DoiDate.findByFirstNames", query = "SELECT d FROM DoiDate d WHERE d.firstNames = :firstNames"),
    @NamedQuery(name = "DoiDate.findByLastName", query = "SELECT d FROM DoiDate d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "DoiDate.findByGender", query = "SELECT d FROM DoiDate d WHERE d.gender = :gender"),
    @NamedQuery(name = "DoiDate.findByBirthCity", query = "SELECT d FROM DoiDate d WHERE d.birthCity = :birthCity"),
    @NamedQuery(name = "DoiDate.findByBirthCountry", query = "SELECT d FROM DoiDate d WHERE d.birthCountry = :birthCountry"),
    @NamedQuery(name = "DoiDate.findByBirthDay", query = "SELECT d FROM DoiDate d WHERE d.birthDay = :birthDay"),
    @NamedQuery(name = "DoiDate.findByBirthMonth", query = "SELECT d FROM DoiDate d WHERE d.birthMonth = :birthMonth"),
    @NamedQuery(name = "DoiDate.findByBirthYear", query = "SELECT d FROM DoiDate d WHERE d.birthYear = :birthYear"),
    @NamedQuery(name = "DoiDate.findByBirthDate", query = "SELECT d FROM DoiDate d WHERE d.birthDate = :birthDate"),
    @NamedQuery(name = "DoiDate.findByResidenceCountry", query = "SELECT d FROM DoiDate d WHERE d.residenceCountry = :residenceCountry"),
    @NamedQuery(name = "DoiDate.findByOccupation", query = "SELECT d FROM DoiDate d WHERE d.occupation = :occupation"),
    @NamedQuery(name = "DoiDate.findByResidenceLineOne", query = "SELECT d FROM DoiDate d WHERE d.residenceLineOne = :residenceLineOne"),
    @NamedQuery(name = "DoiDate.findByCitizenshipStatus", query = "SELECT d FROM DoiDate d WHERE d.citizenshipStatus = :citizenshipStatus"),
    @NamedQuery(name = "DoiDate.findByFatherName", query = "SELECT d FROM DoiDate d WHERE d.fatherName = :fatherName"),
    @NamedQuery(name = "DoiDate.findByFatherIdentityCardNo", query = "SELECT d FROM DoiDate d WHERE d.fatherIdentityCardNo = :fatherIdentityCardNo"),
    @NamedQuery(name = "DoiDate.findByFatherPassportNo", query = "SELECT d FROM DoiDate d WHERE d.fatherPassportNo = :fatherPassportNo"),
    @NamedQuery(name = "DoiDate.findByFatherBirthPlace", query = "SELECT d FROM DoiDate d WHERE d.fatherBirthPlace = :fatherBirthPlace"),
    @NamedQuery(name = "DoiDate.findByMotherName", query = "SELECT d FROM DoiDate d WHERE d.motherName = :motherName"),
    @NamedQuery(name = "DoiDate.findByMotherIdentityCardNo", query = "SELECT d FROM DoiDate d WHERE d.motherIdentityCardNo = :motherIdentityCardNo"),
    @NamedQuery(name = "DoiDate.findByMotherPassportNo", query = "SELECT d FROM DoiDate d WHERE d.motherPassportNo = :motherPassportNo"),
    @NamedQuery(name = "DoiDate.findByMotherBirthPlace", query = "SELECT d FROM DoiDate d WHERE d.motherBirthPlace = :motherBirthPlace"),
    @NamedQuery(name = "DoiDate.findByMaritalStatus", query = "SELECT d FROM DoiDate d WHERE d.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "DoiDate.findBySpouseName", query = "SELECT d FROM DoiDate d WHERE d.spouseName = :spouseName"),
    @NamedQuery(name = "DoiDate.findByWifeMaidenName", query = "SELECT d FROM DoiDate d WHERE d.wifeMaidenName = :wifeMaidenName"),
    @NamedQuery(name = "DoiDate.findByMarriageDate", query = "SELECT d FROM DoiDate d WHERE d.marriageDate = :marriageDate"),
    @NamedQuery(name = "DoiDate.findByMarriagePlace", query = "SELECT d FROM DoiDate d WHERE d.marriagePlace = :marriagePlace"),
    @NamedQuery(name = "DoiDate.findBySpouseIdentityCardNo", query = "SELECT d FROM DoiDate d WHERE d.spouseIdentityCardNo = :spouseIdentityCardNo"),
    @NamedQuery(name = "DoiDate.findByFirstKinName", query = "SELECT d FROM DoiDate d WHERE d.firstKinName = :firstKinName"),
    @NamedQuery(name = "DoiDate.findByFirstKinDivision", query = "SELECT d FROM DoiDate d WHERE d.firstKinDivision = :firstKinDivision"),
    @NamedQuery(name = "DoiDate.findByFirstKinLocation", query = "SELECT d FROM DoiDate d WHERE d.firstKinLocation = :firstKinLocation"),
    @NamedQuery(name = "DoiDate.findByFirstKinRelation", query = "SELECT d FROM DoiDate d WHERE d.firstKinRelation = :firstKinRelation"),
    @NamedQuery(name = "DoiDate.findByFirstKinIdentityCardNo", query = "SELECT d FROM DoiDate d WHERE d.firstKinIdentityCardNo = :firstKinIdentityCardNo"),
    @NamedQuery(name = "DoiDate.findBySecondKinName", query = "SELECT d FROM DoiDate d WHERE d.secondKinName = :secondKinName"),
    @NamedQuery(name = "DoiDate.findBySecondKinDivision", query = "SELECT d FROM DoiDate d WHERE d.secondKinDivision = :secondKinDivision"),
    @NamedQuery(name = "DoiDate.findBySecondKinLocation", query = "SELECT d FROM DoiDate d WHERE d.secondKinLocation = :secondKinLocation"),
    @NamedQuery(name = "DoiDate.findBySecondKinRelation", query = "SELECT d FROM DoiDate d WHERE d.secondKinRelation = :secondKinRelation"),
    @NamedQuery(name = "DoiDate.findBySecondKinIdentityCardNo", query = "SELECT d FROM DoiDate d WHERE d.secondKinIdentityCardNo = :secondKinIdentityCardNo"),
    @NamedQuery(name = "DoiDate.findByPhotograph", query = "SELECT d FROM DoiDate d WHERE d.photograph = :photograph")})
public class DoiDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TRACKING_ID")
    private BigInteger trackingId;
    @Column(name = "PASSPORT_NO")
    private String passportNo;
    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "IDENTITY_CARD_NO")
    private String identityCardNo;
    @Column(name = "FIRST_NAMES")
    private String firstNames;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "BIRTH_CITY")
    private String birthCity;
    @Column(name = "BIRTH_COUNTRY")
    private String birthCountry;
    @Column(name = "BIRTH_DAY")
    private Short birthDay;
    @Column(name = "BIRTH_MONTH")
    private Short birthMonth;
    @Column(name = "BIRTH_YEAR")
    private Short birthYear;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "RESIDENCE_COUNTRY")
    private String residenceCountry;
    @Column(name = "OCCUPATION")
    private String occupation;
    @Column(name = "RESIDENCE_LINE_ONE")
    private String residenceLineOne;
    @Column(name = "CITIZENSHIP_STATUS")
    private String citizenshipStatus;
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Column(name = "FATHER_IDENTITY_CARD_NO")
    private String fatherIdentityCardNo;
    @Column(name = "FATHER_PASSPORT_NO")
    private String fatherPassportNo;
    @Column(name = "FATHER_BIRTH_PLACE")
    private String fatherBirthPlace;
    @Column(name = "MOTHER_NAME")
    private String motherName;
    @Column(name = "MOTHER_IDENTITY_CARD_NO")
    private String motherIdentityCardNo;
    @Column(name = "MOTHER_PASSPORT_NO")
    private String motherPassportNo;
    @Column(name = "MOTHER_BIRTH_PLACE")
    private String motherBirthPlace;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "SPOUSE_NAME")
    private String spouseName;
    @Column(name = "WIFE_MAIDEN_NAME")
    private String wifeMaidenName;
    @Column(name = "MARRIAGE_DATE")
    @Temporal(TemporalType.DATE)
    private Date marriageDate;
    @Column(name = "MARRIAGE_PLACE")
    private String marriagePlace;
    @Column(name = "SPOUSE_IDENTITY_CARD_NO")
    private String spouseIdentityCardNo;
    @Column(name = "FIRST_KIN_NAME")
    private String firstKinName;
    @Column(name = "FIRST_KIN_DIVISION")
    private String firstKinDivision;
    @Column(name = "FIRST_KIN_LOCATION")
    private String firstKinLocation;
    @Column(name = "FIRST_KIN_RELATION")
    private String firstKinRelation;
    @Column(name = "FIRST_KIN_IDENTITY_CARD_NO")
    private String firstKinIdentityCardNo;
    @Column(name = "SECOND_KIN_NAME")
    private String secondKinName;
    @Column(name = "SECOND_KIN_DIVISION")
    private String secondKinDivision;
    @Column(name = "SECOND_KIN_LOCATION")
    private String secondKinLocation;
    @Column(name = "SECOND_KIN_RELATION")
    private String secondKinRelation;
    @Column(name = "SECOND_KIN_IDENTITY_CARD_NO")
    private String secondKinIdentityCardNo;
    @Id
    @Basic(optional = false)
    @Column(name = "PHOTOGRAPH")
    private String photograph;

    public DoiDate() {
    }

    public DoiDate(String photograph) {
        this.photograph = photograph;
    }

    public BigInteger getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(BigInteger trackingId) {
        this.trackingId = trackingId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Short getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Short birthDay) {
        this.birthDay = birthDay;
    }

    public Short getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Short birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Short getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Short birthYear) {
        this.birthYear = birthYear;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getResidenceLineOne() {
        return residenceLineOne;
    }

    public void setResidenceLineOne(String residenceLineOne) {
        this.residenceLineOne = residenceLineOne;
    }

    public String getCitizenshipStatus() {
        return citizenshipStatus;
    }

    public void setCitizenshipStatus(String citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherIdentityCardNo() {
        return fatherIdentityCardNo;
    }

    public void setFatherIdentityCardNo(String fatherIdentityCardNo) {
        this.fatherIdentityCardNo = fatherIdentityCardNo;
    }

    public String getFatherPassportNo() {
        return fatherPassportNo;
    }

    public void setFatherPassportNo(String fatherPassportNo) {
        this.fatherPassportNo = fatherPassportNo;
    }

    public String getFatherBirthPlace() {
        return fatherBirthPlace;
    }

    public void setFatherBirthPlace(String fatherBirthPlace) {
        this.fatherBirthPlace = fatherBirthPlace;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherIdentityCardNo() {
        return motherIdentityCardNo;
    }

    public void setMotherIdentityCardNo(String motherIdentityCardNo) {
        this.motherIdentityCardNo = motherIdentityCardNo;
    }

    public String getMotherPassportNo() {
        return motherPassportNo;
    }

    public void setMotherPassportNo(String motherPassportNo) {
        this.motherPassportNo = motherPassportNo;
    }

    public String getMotherBirthPlace() {
        return motherBirthPlace;
    }

    public void setMotherBirthPlace(String motherBirthPlace) {
        this.motherBirthPlace = motherBirthPlace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getWifeMaidenName() {
        return wifeMaidenName;
    }

    public void setWifeMaidenName(String wifeMaidenName) {
        this.wifeMaidenName = wifeMaidenName;
    }

    public Date getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getMarriagePlace() {
        return marriagePlace;
    }

    public void setMarriagePlace(String marriagePlace) {
        this.marriagePlace = marriagePlace;
    }

    public String getSpouseIdentityCardNo() {
        return spouseIdentityCardNo;
    }

    public void setSpouseIdentityCardNo(String spouseIdentityCardNo) {
        this.spouseIdentityCardNo = spouseIdentityCardNo;
    }

    public String getFirstKinName() {
        return firstKinName;
    }

    public void setFirstKinName(String firstKinName) {
        this.firstKinName = firstKinName;
    }

    public String getFirstKinDivision() {
        return firstKinDivision;
    }

    public void setFirstKinDivision(String firstKinDivision) {
        this.firstKinDivision = firstKinDivision;
    }

    public String getFirstKinLocation() {
        return firstKinLocation;
    }

    public void setFirstKinLocation(String firstKinLocation) {
        this.firstKinLocation = firstKinLocation;
    }

    public String getFirstKinRelation() {
        return firstKinRelation;
    }

    public void setFirstKinRelation(String firstKinRelation) {
        this.firstKinRelation = firstKinRelation;
    }

    public String getFirstKinIdentityCardNo() {
        return firstKinIdentityCardNo;
    }

    public void setFirstKinIdentityCardNo(String firstKinIdentityCardNo) {
        this.firstKinIdentityCardNo = firstKinIdentityCardNo;
    }

    public String getSecondKinName() {
        return secondKinName;
    }

    public void setSecondKinName(String secondKinName) {
        this.secondKinName = secondKinName;
    }

    public String getSecondKinDivision() {
        return secondKinDivision;
    }

    public void setSecondKinDivision(String secondKinDivision) {
        this.secondKinDivision = secondKinDivision;
    }

    public String getSecondKinLocation() {
        return secondKinLocation;
    }

    public void setSecondKinLocation(String secondKinLocation) {
        this.secondKinLocation = secondKinLocation;
    }

    public String getSecondKinRelation() {
        return secondKinRelation;
    }

    public void setSecondKinRelation(String secondKinRelation) {
        this.secondKinRelation = secondKinRelation;
    }

    public String getSecondKinIdentityCardNo() {
        return secondKinIdentityCardNo;
    }

    public void setSecondKinIdentityCardNo(String secondKinIdentityCardNo) {
        this.secondKinIdentityCardNo = secondKinIdentityCardNo;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photograph != null ? photograph.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoiDate)) {
            return false;
        }
        DoiDate other = (DoiDate) object;
        if ((this.photograph == null && other.photograph != null) || (this.photograph != null && !this.photograph.equals(other.photograph))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.DoiDate[photograph=" + photograph + "]";
    }

}
