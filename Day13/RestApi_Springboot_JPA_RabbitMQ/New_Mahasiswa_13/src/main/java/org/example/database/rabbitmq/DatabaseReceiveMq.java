package org.example.database.rabbitmq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import org.example.database.entities.Mahasiswa;
import org.example.database.daos.MahasiswaDao;
import org.example.database.rabbitmq.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.List;


public class DatabaseReceiveMq {
    DatabaseSendMq send = new DatabaseSendMq();
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private MahasiswaDao myMahasiswa;

    public DatabaseReceiveMq(EntityManager entityManager) {
        this.entityManager = entityManager;
        myMahasiswa = new MahasiswaDao(entityManager);
    }

    public void connectToRabbitMQ() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }


    public void openConnJPA(){
        this.entityManager = Persistence
                .createEntityManagerFactory("mahasiswa-unit")
                .createEntityManager();
        myMahasiswa = new MahasiswaDao(entityManager);
        try {
            entityManager.getTransaction().begin();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void closeConnJPA(){
        try {
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
        }
    }


    public void addMahasiswa(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("createDataMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                openConnJPA();
                myMahasiswa.persist(mhsString);
                closeConnJPA();
            };
            channel.basicConsume("createDataMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on addMahasiswa -dbrmq : " + e);
        }
    }


    public void getAllMahasiswa() {
        try {
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("getAlldataMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                openConnJPA();
                try {
                    List<Mahasiswa> listMhs= myMahasiswa.getAllMhs();
                    send.sendToRestApi(new Gson().toJson(listMhs));
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                closeConnJPA();
            };
            channel.basicConsume("getAlldataMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error getAlldataMahasiswa = " + e);
        }
    }

    public void updateMahasiswa(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("updateDataMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                openConnJPA();
                myMahasiswa.update(mhsString);
                closeConnJPA();
            };
            channel.basicConsume("updateDataMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on updateMahasiswa -dbrmq : " + e);
        }
    }

    public void absensiMahasiswa(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("doAbsensiMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String idMhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idMhsString + "'");
                openConnJPA();
                myMahasiswa.doAbsensi(idMhsString);
                closeConnJPA();
            };
            channel.basicConsume("doAbsensiMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on absensiMahasiswa -dbrmq : " + e);
        }
    }

}
