import java.sql.*;
import java.util.*;
import javax.faces.bean.*;
@ManagedBean
@RequestScoped
public class kayitCekm {
    
    PreparedStatement ps=null;//SQL sorgumuzu tutacak ve çalıştıracak nesne.
    Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.
    public List<AdiAlaniPojom> getMusTablosu() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//Hangi türde bir veri tabanını kullanacağını bildiriyoruz.
           con=DriverManager.getConnection("jdbc:mysql:///kitap","root","esra");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            ps=con.prepareStatement("SELECT musid,musadi,musadres FROM musteri");//Yazarlar tablosundaki herşeyi çek diyoruz.
            ResultSet rs=ps.executeQuery();//SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<AdiAlaniPojom> listem=new ArrayList<>();//AdiAlani sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu tiple ulaşacaz.
            while(rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                AdiAlaniPojom aa=new AdiAlaniPojom();//SQL Sorgusundan sütunları çekip bu değişkenin içinde Adı veya Alani kısmına atıyacağız.
                aa.setMusid(rs.getString("musid")); //ResultSet içinden o anki indisdeki "Adi" anahtar kelimesine karşı gelen değer alınıyor.
                aa.setMusadi(rs.getString("musadi")); //ResultSet içinden o anki indisdeki "Adi" anahtar kelimesine karşı gelen değer alınıyor.
                aa.setMusadres(rs.getString("musadres")); //ResultSet içinden o anki indisdeki "Alani" anahtar kelimesine karşı gelen değer alınıyor.
                listem.add(aa);//Her bir dönen sonucu listeye ekliyoruz.
            }
            return listem;//Listeyi return ediyoruz.
        } 
        catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(con!=null){ //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    con.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    }
}