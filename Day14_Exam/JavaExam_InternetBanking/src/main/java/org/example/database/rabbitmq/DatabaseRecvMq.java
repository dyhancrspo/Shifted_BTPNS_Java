package org.example.database.rabbitmq;

import org.example.database.entities.Nasabah;
import org.example.database.rabbitmq.DatabaseSendMq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.example.database.daos.NasabahDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DatabaseRecvMq {
     DatabaseSendMq send = new DatabaseSendMq();
     private ConnectionFactory factory;
     private Connection connection;
     private Channel channel;
     private EntityManager entityManager;
     private NasabahDao myNasabah;

    public DatabaseRecvMq (EntityManager entityManager){
        this.entityManager = entityManager;
        myNasabah = new NasabahDao(entityManager);
    }

    public void connectToRabbitMQ() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void openConnJPA(){
        this.entityManager = Persistence
                .createEntityManagerFactory("nasabah-unit")
                .createEntityManager();
        myNasabah = new NasabahDao(entityManager);
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

    public void addNasabah(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("createDataNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String nasabahString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + nasabahString + "'");
                openConnJPA();
                myNasabah.persist(nasabahString);
                closeConnJPA();
            };
            channel.basicConsume("createDataNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on addNasabah -dbrmq : " + e);
        }
    }

    public void getAllNasabah() {
        try {
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("getAlldataNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String nasabahString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + nasabahString + "'");
                openConnJPA();
                try {
                    List<Nasabah> listNasabah= myNasabah.getAllNsb();
                    send.sendToRestApi(new Gson().toJson(listNasabah));
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                closeConnJPA();
            };
            channel.basicConsume("getAlldataNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error getAlldataNasabah = " + e);
        }
    }

    public void updateNasabah(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("updateDataNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String nasabahString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + nasabahString + "'");
                openConnJPA();
                myNasabah.update(nasabahString);
                closeConnJPA();
            };
            channel.basicConsume("updateDataNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on updateNasabah -dbrmq : " + e);
        }
    }

    public void findDataById(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("findDataNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String idNsbString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idNsbString + "'");
                openConnJPA();
                try {
                    Nasabah getById = myNasabah.find(idNsbString);
                    send.sendToRestApi(new Gson().toJson(getById));
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                closeConnJPA();
            };
            channel.basicConsume("findDataNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on findDataById -dbrmq : " + e);
        }
    }

    public void deleteNasabahById(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("deleteDataNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String idNsbString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idNsbString + "'");
                openConnJPA();
                myNasabah.remove(idNsbString);
                closeConnJPA();
            };
            channel.basicConsume("deleteDataNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on deleteNasabahById -dbrmq : " + e);
        }
    }

    public void loginNasabah() {
        try {
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("doLoginNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idNsbString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idNsbString + "'");
                openConnJPA();
                myNasabah.doLogin(idNsbString);
                closeConnJPA();
            };
            channel.basicConsume("doLoginNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on loginNasabah -dbrmq : " + e);
        }
    }

    public void logoutNasabah(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("doLogoutNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String idNsbString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idNsbString + "'");
                openConnJPA();
                myNasabah.doLogout(idNsbString);
                closeConnJPA();
            };
            channel.basicConsume("doLogoutNasabah", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on logoutNasabah -dbrmq : " + e);
        }
    }



}
