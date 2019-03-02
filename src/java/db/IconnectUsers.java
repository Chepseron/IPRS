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
 * @author Administrator
 */
@Entity
@Table(name = "ICONNECT_USERS")
@NamedQueries({
    @NamedQuery(name = "IconnectUsers.findAll", query = "SELECT i FROM IconnectUsers i"),
    @NamedQuery(name = "IconnectUsers.findByPassword", query = "SELECT i FROM IconnectUsers i WHERE i.password = :password"),
    @NamedQuery(name = "IconnectUsers.findByUserid", query = "SELECT i FROM IconnectUsers i WHERE i.userid = :userid"),
    @NamedQuery(name = "IconnectUsers.findByAgencyId", query = "SELECT i FROM IconnectUsers i WHERE i.agencyId = :agencyId"),
    @NamedQuery(name = "IconnectUsers.findByEmpId", query = "SELECT i FROM IconnectUsers i WHERE i.empId = :empId"),
    @NamedQuery(name = "IconnectUsers.findByCreateDate", query = "SELECT i FROM IconnectUsers i WHERE i.createDate = :createDate"),
    @NamedQuery(name = "IconnectUsers.findByExpiryDate", query = "SELECT i FROM IconnectUsers i WHERE i.expiryDate = :expiryDate"),
    @NamedQuery(name = "IconnectUsers.findByStatus", query = "SELECT i FROM IconnectUsers i WHERE i.status = :status"),
    @NamedQuery(name = "IconnectUsers.findByRoleuser", query = "SELECT i FROM IconnectUsers i WHERE i.roleuser = :roleuser"),
    @NamedQuery(name = "IconnectUsers.findByLogged", query = "SELECT i FROM IconnectUsers i WHERE i.logged = :logged")})
public class IconnectUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PASSWORD")
    private String password;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private String userid;
    @Column(name = "AGENCY_ID")
    private String agencyId;
    @Column(name = "EMP_ID")
    private String empId;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ROLEUSER")
    private String roleuser;
    @Column(name = "LOGGED")
    private String logged;

    public IconnectUsers() {
    }

    public IconnectUsers(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleuser() {
        return roleuser;
    }

    public void setRoleuser(String roleuser) {
        this.roleuser = roleuser;
    }

    public String getLogged() {
        return logged;
    }

    public void setLogged(String logged) {
        this.logged = logged;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IconnectUsers)) {
            return false;
        }
        IconnectUsers other = (IconnectUsers) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.IconnectUsers[userid=" + userid + "]";
    }

}
