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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "kitap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitap.findAll", query = "SELECT k FROM Kitap k"),
    @NamedQuery(name = "Kitap.findByKid", query = "SELECT k FROM Kitap k WHERE k.kid = :kid"),
    @NamedQuery(name = "Kitap.findByKadi", query = "SELECT k FROM Kitap k WHERE k.kadi = :kadi"),
    @NamedQuery(name = "Kitap.findByKfiyat", query = "SELECT k FROM Kitap k WHERE k.kfiyat = :kfiyat"),
    @NamedQuery(name = "Kitap.findByKyazar", query = "SELECT k FROM Kitap k WHERE k.kyazar = :kyazar"),
    @NamedQuery(name = "Kitap.findByStokid", query = "SELECT k FROM Kitap k WHERE k.stokid = :stokid"),
    @NamedQuery(name = "Kitap.findByYtarihi", query = "SELECT k FROM Kitap k WHERE k.ytarihi = :ytarihi"),
    @NamedQuery(name = "Kitap.findByYayinevi", query = "SELECT k FROM Kitap k WHERE k.yayinevi = :yayinevi"),
    @NamedQuery(name = "Kitap.findByYazarid", query = "SELECT k FROM Kitap k WHERE k.yazarid = :yazarid"),
    @NamedQuery(name = "Kitap.findByYayevid", query = "SELECT k FROM Kitap k WHERE k.yayevid = :yayevid"),
    @NamedQuery(name = "Kitap.findByAciklama", query = "SELECT k FROM Kitap k WHERE k.aciklama = :aciklama")})
public class Kitap implements Serializable {

    @Column(name = "stokid")
    private Integer stokid;
    @Column(name = "yazarid")
    private Integer yazarid;
    @Column(name = "yayevid")
    private Integer yayevid;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kid")
    private Integer kid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kadi")
    private String kadi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kfiyat")
    private String kfiyat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kyazar")
    private String kyazar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ytarihi")
    private String ytarihi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "yayinevi")
    private String yayinevi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aciklama")
    private String aciklama;
    @JoinTable(name = "kitap_has_uye", joinColumns = {
        @JoinColumn(name = "kitap_kid", referencedColumnName = "kid")}, inverseJoinColumns = {
        @JoinColumn(name = "uye_uyeid", referencedColumnName = "uyeid")})
    @ManyToMany
    private Collection<Uye> uyeCollection;
    @ManyToMany(mappedBy = "kitapCollection")
    private Collection<Kategori> kategoriCollection;
    @JoinTable(name = "kitap_has_musteri", joinColumns = {
        @JoinColumn(name = "kitap_kid", referencedColumnName = "kid")}, inverseJoinColumns = {
        @JoinColumn(name = "musteri_musid", referencedColumnName = "musid")})
    @ManyToMany
    private Collection<Musteri> musteriCollection;

    public Kitap() {
    }

    public Kitap(Integer kid) {
        this.kid = kid;
    }

    public Kitap(Integer kid, String kadi, String kfiyat, String kyazar, int stokid, String ytarihi, String yayinevi, int yazarid, int yayevid, String aciklama) {
        this.kid = kid;
        this.kadi = kadi;
        this.kfiyat = kfiyat;
        this.kyazar = kyazar;
        this.stokid = stokid;
        this.ytarihi = ytarihi;
        this.yayinevi = yayinevi;
        this.yazarid = yazarid;
        this.yayevid = yayevid;
        this.aciklama = aciklama;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public String getKfiyat() {
        return kfiyat;
    }

    public void setKfiyat(String kfiyat) {
        this.kfiyat = kfiyat;
    }

    public String getKyazar() {
        return kyazar;
    }

    public void setKyazar(String kyazar) {
        this.kyazar = kyazar;
    }


    public String getYtarihi() {
        return ytarihi;
    }

    public void setYtarihi(String ytarihi) {
        this.ytarihi = ytarihi;
    }

    public String getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(String yayinevi) {
        this.yayinevi = yayinevi;
    }


    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @XmlTransient
    public Collection<Uye> getUyeCollection() {
        return uyeCollection;
    }

    public void setUyeCollection(Collection<Uye> uyeCollection) {
        this.uyeCollection = uyeCollection;
    }

    
    
    //kitap tablosuna kategori ekleme kodu
   
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    //buraya kadar . kategoriController a bağlandı . Kitap-create ve list.xhtml kullanıldı . 
    
    
    @XmlTransient
    public Collection<Kategori> getKategoriCollection() {
        return kategoriCollection;
    }

    public void setKategoriCollection(Collection<Kategori> kategoriCollection) {
        this.kategoriCollection = kategoriCollection;
    }
     
    
    public String getKategori(){
        String result="";
        for(Kategori kategori: kategoriCollection){
            result+=kategori.getKateadi();
            result+=" ,";
            
        }
        if(result.length()>2){
            result=result.substring(0,result.length()-2);
        }
        return result;
    }

    @XmlTransient
    public Collection<Musteri> getMusteriCollection() {
        return musteriCollection;
    }

    public void setMusteriCollection(Collection<Musteri> musteriCollection) {
        this.musteriCollection = musteriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kid != null ? kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitap)) {
            return false;
        }
        Kitap other = (Kitap) object;
        if ((this.kid == null && other.kid != null) || (this.kid != null && !this.kid.equals(other.kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kitabim.Kitap[ kid=" + kid + " ]";
    }

    public Integer getStokid() {
        return stokid;
    }

    public void setStokid(Integer stokid) {
        this.stokid = stokid;
    }

    public Integer getYazarid() {
        return yazarid;
    }

    public void setYazarid(Integer yazarid) {
        this.yazarid = yazarid;
    }

    public Integer getYayevid() {
        return yayevid;
    }

    public void setYayevid(Integer yayevid) {
        this.yayevid = yayevid;
    }
    
}
