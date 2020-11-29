package org.example.springrestapi.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class SendMqRestAPI {


    public static void getAll() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        String mhsString = "Requesting All Data";
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("getAlldataMahasiswa", false, false, false, null);
            channel.basicPublish("", "getAlldataMahasiswa", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }

    public static void addMahasiswa(String mhsString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("createDataMahasiswa", false, false, false, null);
            channel.basicPublish("", "createDataMahasiswa", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }


    public static void updateMahasiswa(String mhsString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("updateDataMahasiswa", false, false, false, null);
            channel.basicPublish("", "updateDataMahasiswa", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }

    public static void absensiMahasiswa(String mhsString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("doAbsensiMahasiswa", false, false, false, null);
            channel.basicPublish("", "doAbsensiMahasiswa", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }
}