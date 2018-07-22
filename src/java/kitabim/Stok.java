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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "stok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stok.findAll", query = "SELECT s FROM Stok s"),
    @NamedQuery(name = "Stok.findByStokid", query = "SELECT s FROM Stok s WHERE s.stokid = :stokid"),
    @NamedQuery(name = "Stok.findByAdet", query = "SELECT s FROM Stok s WHERE s.adet = :adet")})
public class Stok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "stokid")
    private Integer stokid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adet")
    private int adet;

    public Stok() {
    }

    public Stok(Integer stokid) {
        this.stokid = stokid;
    }

    public Stok(Integer stokid, int adet) {
        this.stokid = stokid;
        this.adet = adet;
    }

    public Integer getStokid() {
        return stokid;
    }

    public void setStokid(Integer stokid) {
        this.stokid = stokid;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stokid != null ? stokid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stok)) {
            return false;
        }
        Stok other = (Stok) object;
        if ((this.stokid == null && other.stokid != null) || (this.stokid != null && !this.stokid.equals(other.stokid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Stok[ stokid=" + stokid + " ]";
    }
    
}
