/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fusion
 */
@Entity
@Table(name = "AGENCY_CATEGORIES")
@NamedQueries({
    @NamedQuery(name = "AgencyCategories.findAll", query = "SELECT a FROM AgencyCategories a"),
    @NamedQuery(name = "AgencyCategories.findByCategory", query = "SELECT a FROM AgencyCategories a WHERE a.category = :category")})
public class AgencyCategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;

    public AgencyCategories() {
    }

    public AgencyCategories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (category != null ? category.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgencyCategories)) {
            return false;
        }
        AgencyCategories other = (AgencyCategories) object;
        if ((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AgencyCategories[category=" + category + "]";
    }

}
