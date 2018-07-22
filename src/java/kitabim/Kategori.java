/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitabim;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k"),
    @NamedQuery(name = "Kategori.findByKateid", query = "SELECT k FROM Kategori k WHERE k.kateid = :kateid"),
    @NamedQuery(name = "Kategori.findByKateadi", query = "SELECT k FROM Kategori k WHERE k.kateadi = :kateadi")})
public class Kategori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kateid")
    private Integer kateid;
    @Size(max = 45)
    @Column(name = "kateadi")
    private String kateadi;
    @JoinTable(name = "kitap_has_kategori", joinColumns = {
        @JoinColumn(name = "kategori_kateid", referencedColumnName = "kateid")}, inverseJoinColumns = {
        @JoinColumn(name = "kitap_kid", referencedColumnName = "kid")})
    @ManyToMany
    private Collection<Kitap> kitapCollection;

    public Kategori() {
    }

    public Kategori(Integer kateid) {
        this.kateid = kateid;
    }

    public Integer getKateid() {
        return kateid;
    }

    public void setKateid(Integer kateid) {
        this.kateid = kateid;
    }

    public String getKateadi() {
        return kateadi;
    }

    public void setKateadi(String kateadi) {
        this.kateadi = kateadi;
    }

    @XmlTransient
    public Collection<Kitap> getKitapCollection() {
        return kitapCollection;
    }

    public void setKitapCollection(Collection<Kitap> kitapCollection) {
        this.kitapCollection = kitapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kateid != null ? kateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.kateid == null && other.kateid != null) || (this.kateid != null && !this.kateid.equals(other.kateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Kategori[ kateid=" + kateid + " ]";
    }
    
}
