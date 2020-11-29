package org.example.database.application;

import org.example.database.rabbitmq.DatabaseReceiveMq;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class DatabaseMqMain {

    public static EntityManager entityManager = Persistence
            .createEntityManagerFactory("mahasiswa-unit")
            .createEntityManager();

    public static DatabaseReceiveMq receiveMq = new DatabaseReceiveMq(entityManager);

    public static void main(String[] args) {
        try{
            System.out.println(" [*] Waiting for messages...");
            receiveMq.addMahasiswa();
            receiveMq.updateMahasiswa();
            receiveMq.absensiMahasiswa();
            receiveMq.getAllMahasiswa();
        }catch (Exception e){
            System.out.println("ERROR! on DatabaseMqMain : " + e);
        }
    }

}
