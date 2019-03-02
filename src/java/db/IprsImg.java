/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "IPRS_IMG")
@NamedQueries({
    @NamedQuery(name = "IprsImg.findAll", query = "SELECT i FROM IprsImg i"),
    @NamedQuery(name = "IprsImg.findByNameImg", query = "SELECT i FROM IprsImg i WHERE i.nameImg = :nameImg"),
    @NamedQuery(name = "IprsImg.findByPra", query = "SELECT i FROM IprsImg i WHERE i.pra = :pra"),
    @NamedQuery(name = "IprsImg.findByRid", query = "SELECT i FROM IprsImg i WHERE i.rid = :rid")})
public class IprsImg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME_IMG")
    private String nameImg;
    @Basic(optional = false)
    @Column(name = "PRA")
    private String pra;
    @Lob
    @Column(name = "IMG")
    private byte[] img;
    @Id
    @Basic(optional = false)
    @Column(name = "RID")
    private BigDecimal rid;

    public IprsImg() {
    }

    public IprsImg(BigDecimal rid) {
        this.rid = rid;
    }

    public IprsImg(BigDecimal rid, String nameImg, String pra) {
        this.rid = rid;
        this.nameImg = nameImg;
        this.pra = pra;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public String getPra() {
        return pra;
    }

    public void setPra(String pra) {
        this.pra = pra;
    }

    public BigDecimal getRid() {
        return rid;
    }

    public void setRid(BigDecimal rid) {
        this.rid = rid;
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
        if (!(object instanceof IprsImg)) {
            return false;
        }
        IprsImg other = (IprsImg) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.IprsImg[rid=" + rid + "]";
    }

    /**
     * @return the img
     */
    public byte[] getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(byte[] img) {
        this.img = img;
    }

    /**
     * @return the img
     */
  
    /**
     * @return the img
     */
   
}
