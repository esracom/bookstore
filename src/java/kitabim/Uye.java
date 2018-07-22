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
@Table(name = "uye")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name="Uye.control", query="SELECT u FROM Uye u WHERE u.uyeadi = :uyeadi and u.uyecol = :uyecol"),
    @NamedQuery(name = "Uye.findAll", query = "SELECT u FROM Uye u"),
    @NamedQuery(name = "Uye.findByUyeid", query = "SELECT u FROM Uye u WHERE u.uyeid = :uyeid"),
    @NamedQuery(name = "Uye.findByUyeadi", query = "SELECT u FROM Uye u WHERE u.uyeadi = :uyeadi"),
    @NamedQuery(name = "Uye.findByUyeadres", query = "SELECT u FROM Uye u WHERE u.uyeadres = :uyeadres"),
    @NamedQuery(name = "Uye.findByUyecol", query = "SELECT u FROM Uye u WHERE u.uyecol = :uyecol")})
public class Uye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uyeid")
    private Integer uyeid;
    @Size(max = 45)
    @Column(name = "uyeadi")
    private String uyeadi;
    @Size(max = 45)
    @Column(name = "uyeadres")
    private String uyeadres;
    @Size(max = 45)
    @Column(name = "uyecol")
    private String uyecol;
    @ManyToMany(mappedBy = "uyeCollection")
    private Collection<Kitap> kitapCollection;

    public Uye() {
    }

    public Uye(Integer uyeid) {
        this.uyeid = uyeid;
    }

    public Integer getUyeid() {
        return uyeid;
    }

    public void setUyeid(Integer uyeid) {
        this.uyeid = uyeid;
    }

    public String getUyeadi() {
        return uyeadi;
    }

    public void setUyeadi(String uyeadi) {
        this.uyeadi = uyeadi;
    }

    public String getUyeadres() {
        return uyeadres;
    }

    public void setUyeadres(String uyeadres) {
        this.uyeadres = uyeadres;
    }

    public String getUyecol() {
        return uyecol;
    }

    public void setUyecol(String uyecol) {
        this.uyecol = uyecol;
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
        hash += (uyeid != null ? uyeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uye)) {
            return false;
        }
        Uye other = (Uye) object;
        if ((this.uyeid == null && other.uyeid != null) || (this.uyeid != null && !this.uyeid.equals(other.uyeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Uye[ uyeid=" + uyeid + " ]";
    }
    
}
