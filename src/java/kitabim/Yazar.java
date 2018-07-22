/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitabim;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "yazar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yazar.findAll", query = "SELECT y FROM Yazar y"),
    @NamedQuery(name = "Yazar.findByYazarid", query = "SELECT y FROM Yazar y WHERE y.yazarid = :yazarid"),
    @NamedQuery(name = "Yazar.findByYazaradi", query = "SELECT y FROM Yazar y WHERE y.yazaradi = :yazaradi"),
    @NamedQuery(name = "Yazar.findByYazarweb", query = "SELECT y FROM Yazar y WHERE y.yazarweb = :yazarweb")})
public class Yazar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "yazarid")
    private Integer yazarid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "yazaradi")
    private String yazaradi;
    @Size(max = 45)
    @Column(name = "yazarweb")
    private String yazarweb;

    public Yazar() {
    }

    public Yazar(Integer yazarid) {
        this.yazarid = yazarid;
    }

    public Yazar(Integer yazarid, String yazaradi) {
        this.yazarid = yazarid;
        this.yazaradi = yazaradi;
    }

    public Integer getYazarid() {
        return yazarid;
    }

    public void setYazarid(Integer yazarid) {
        this.yazarid = yazarid;
    }

    public String getYazaradi() {
        return yazaradi;
    }

    public void setYazaradi(String yazaradi) {
        this.yazaradi = yazaradi;
    }

    public String getYazarweb() {
        return yazarweb;
    }

    public void setYazarweb(String yazarweb) {
        this.yazarweb = yazarweb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yazarid != null ? yazarid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yazar)) {
            return false;
        }
        Yazar other = (Yazar) object;
        if ((this.yazarid == null && other.yazarid != null) || (this.yazarid != null && !this.yazarid.equals(other.yazarid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Yazar[ yazarid=" + yazarid + " ]";
    }
    
}
