package org.example.database.daos;

import com.google.gson.Gson;
import org.example.database.entities.Mahasiswa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MahasiswaDao {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public MahasiswaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = entityManager.getTransaction();
    }

    public Mahasiswa find(long id) {
        return entityManager.find(Mahasiswa.class, id);
    }

    public void persist(String mhsString){
        beginTransaction();
        Mahasiswa mahasiswa = new Gson().fromJson(mhsString, Mahasiswa.class);
        entityManager.persist(mahasiswa);
        commitTransaction();
    }

    public void update(String mhsString){
        beginTransaction();
        Mahasiswa currentMahasiswa = new Gson().fromJson(mhsString, Mahasiswa.class);
        Mahasiswa nextMahasiswa = entityManager.find(Mahasiswa.class, currentMahasiswa.getId());
        nextMahasiswa.setFullname(currentMahasiswa.getFullname());
        nextMahasiswa.setAddress(currentMahasiswa.getAddress());
        nextMahasiswa.setStatus(currentMahasiswa.getStatus());
        entityManager.merge(nextMahasiswa);
        commitTransaction();
    }

    public void remove(long id) {
        beginTransaction();
        Mahasiswa mahasiswa = entityManager.find(Mahasiswa.class, id);
        entityManager.remove(mahasiswa);
        commitTransaction();
    }

    public void doAbsensi(String id) {
        beginTransaction();
        Mahasiswa mahasiswa = entityManager.find(Mahasiswa.class, Long.valueOf(id));
        int myAbsensi = mahasiswa.getAbsensi() + 1;
        mahasiswa.setAbsensi(myAbsensi);
        commitTransaction();
    }


    private void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void closeConn(){
        try {
            entityManager.close();
            System.out.println("Disconnected.....");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
