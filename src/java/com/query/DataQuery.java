/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import kitabim.Uye;

/**
 *
 * @author Hp
 */
public class DataQuery {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public DataQuery(){
        emf=Persistence.createEntityManagerFactory("kitapPU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public boolean Uye(String uyeadi, String uyecol){
        try{
            
            Uye u=em.createNamedQuery("Uye.control",Uye.class).setParameter("uyeadi", uyeadi).setParameter("uyecol",uyecol).getSingleResult();
            if(u!=null){
                return true;
            
        }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
