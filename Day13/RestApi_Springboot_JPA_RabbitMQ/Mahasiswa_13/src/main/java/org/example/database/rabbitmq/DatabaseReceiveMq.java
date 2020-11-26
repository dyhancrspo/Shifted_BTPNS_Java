package org.example.database.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.example.database.daos.MahasiswaDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;


public class DatabaseReceiveMq {
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


    public void addMahasiswa(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("createDataMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                myMahasiswa.persist(mhsString);
                System.out.println(" [x] Received '" + mhsString + "'");
            };
            channel.basicConsume("createDataMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on addMahasiswa -dbrmq : " + e);
        }
    }

    public void updateMahasiswa(){
        try{
            connectToRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("updateDataMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery ) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                myMahasiswa.update(mhsString);
                System.out.println(" [x] Received '" + mhsString + "'");
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
                myMahasiswa.doAbsensi(idMhsString);
                System.out.println(" [x] Received '" + idMhsString + "'");
            };
            channel.basicConsume("doAbsensiMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("ERROR! on absensiMahasiswa -dbrmq : " + e);
        }
    }


}
