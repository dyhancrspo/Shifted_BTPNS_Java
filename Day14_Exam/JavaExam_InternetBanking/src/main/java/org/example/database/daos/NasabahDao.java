package org.example.database.daos;

import org.example.database.entities.Nasabah;

import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class NasabahDao {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public NasabahDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = entityManager.getTransaction();
    }

    public Nasabah find(String id) {
        return entityManager.find(Nasabah.class, Long.valueOf(id));
    }

    public List<Nasabah> getAllNsb(){
        return entityManager.createQuery("SELECT a FROM Nasabah a", Nasabah.class).getResultList();
    }

    public void persist(String mhsString){
        Nasabah nasabah = new Gson().fromJson(mhsString, Nasabah.class);
        entityManager.persist(nasabah);
    }

    public void update(String mhsString){
        Nasabah currentNasabah = new Gson().fromJson(mhsString, Nasabah.class);
        Nasabah nextNasabah = entityManager.find(Nasabah.class, currentNasabah.getId());
        nextNasabah.setFullname(currentNasabah.getFullname());
        nextNasabah.setPhonenumber(currentNasabah.getPhonenumber());
        nextNasabah.setUsername(currentNasabah.getUsername());
        nextNasabah.setPassword(currentNasabah.getPassword());
        nextNasabah.setStatus(currentNasabah.getStatus());
        entityManager.merge(nextNasabah);
    }

    public void remove(String id) {
        Nasabah nasabah = entityManager.find(Nasabah.class, Long.valueOf(id));
        entityManager.remove(nasabah);
    }

    public void doLogin(String id) {
        Nasabah nasabah = entityManager.find(Nasabah.class, Long.valueOf(id));
        Boolean statusLogin = true;
        nasabah.setIsLogin(statusLogin);
    }

    public void doLogout(String id) {
        Nasabah nasabah = entityManager.find(Nasabah.class, Long.valueOf(id));
        Boolean statusLogin = false;
        nasabah.setIsLogin(statusLogin);
    }


}