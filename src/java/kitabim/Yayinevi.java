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
@Table(name = "yayinevi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yayinevi.findAll", query = "SELECT y FROM Yayinevi y"),
    @NamedQuery(name = "Yayinevi.findByYayevid", query = "SELECT y FROM Yayinevi y WHERE y.yayevid = :yayevid"),
    @NamedQuery(name = "Yayinevi.findByYayevadi", query = "SELECT y FROM Yayinevi y WHERE y.yayevadi = :yayevadi"),
    @NamedQuery(name = "Yayinevi.findByYayevadres", query = "SELECT y FROM Yayinevi y WHERE y.yayevadres = :yayevadres"),
    @NamedQuery(name = "Yayinevi.findByYayevweb", query = "SELECT y FROM Yayinevi y WHERE y.yayevweb = :yayevweb"),
    @NamedQuery(name = "Yayinevi.findByYayevtel", query = "SELECT y FROM Yayinevi y WHERE y.yayevtel = :yayevtel")})
public class Yayinevi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "yayevid")
    private Integer yayevid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "yayevadi")
    private String yayevadi;
    @Size(max = 45)
    @Column(name = "yayevadres")
    private String yayevadres;
    @Size(max = 45)
    @Column(name = "yayevweb")
    private String yayevweb;
    @Column(name = "yayevtel")
    private Integer yayevtel;

    public Yayinevi() {
    }

    public Yayinevi(Integer yayevid) {
        this.yayevid = yayevid;
    }

    public Yayinevi(Integer yayevid, String yayevadi) {
        this.yayevid = yayevid;
        this.yayevadi = yayevadi;
    }

    public Integer getYayevid() {
        return yayevid;
    }

    public void setYayevid(Integer yayevid) {
        this.yayevid = yayevid;
    }

    public String getYayevadi() {
        return yayevadi;
    }

    public void setYayevadi(String yayevadi) {
        this.yayevadi = yayevadi;
    }

    public String getYayevadres() {
        return yayevadres;
    }

    public void setYayevadres(String yayevadres) {
        this.yayevadres = yayevadres;
    }

    public String getYayevweb() {
        return yayevweb;
    }

    public void setYayevweb(String yayevweb) {
        this.yayevweb = yayevweb;
    }

    public Integer getYayevtel() {
        return yayevtel;
    }

    public void setYayevtel(Integer yayevtel) {
        this.yayevtel = yayevtel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yayevid != null ? yayevid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yayinevi)) {
            return false;
        }
        Yayinevi other = (Yayinevi) object;
        if ((this.yayevid == null && other.yayevid != null) || (this.yayevid != null && !this.yayevid.equals(other.yayevid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Yayinevi[ yayevid=" + yayevid + " ]";
    }
    
}
