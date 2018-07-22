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
@Table(name = "musteri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musteri.findAll", query = "SELECT m FROM Musteri m"),
    @NamedQuery(name = "Musteri.findByMusid", query = "SELECT m FROM Musteri m WHERE m.musid = :musid"),
    @NamedQuery(name = "Musteri.findByMusadi", query = "SELECT m FROM Musteri m WHERE m.musadi = :musadi"),
    @NamedQuery(name = "Musteri.findByMusadres", query = "SELECT m FROM Musteri m WHERE m.musadres = :musadres")})
public class Musteri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "musid")
    private Integer musid;
    @Size(max = 45)
    @Column(name = "musadi")
    private String musadi;
    @Size(max = 45)
    @Column(name = "musadres")
    private String musadres;
    @ManyToMany(mappedBy = "musteriCollection")
    private Collection<Kitap> kitapCollection;

    public Musteri() {
    }

    public Musteri(Integer musid) {
        this.musid = musid;
    }

    public Integer getMusid() {
        return musid;
    }

    public void setMusid(Integer musid) {
        this.musid = musid;
    }

    public String getMusadi() {
        return musadi;
    }

    public void setMusadi(String musadi) {
        this.musadi = musadi;
    }

    public String getMusadres() {
        return musadres;
    }

    public void setMusadres(String musadres) {
        this.musadres = musadres;
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
        hash += (musid != null ? musid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musteri)) {
            return false;
        }
        Musteri other = (Musteri) object;
        if ((this.musid == null && other.musid != null) || (this.musid != null && !this.musid.equals(other.musid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Musteri[ musid=" + musid + " ]";
    }
    
}
