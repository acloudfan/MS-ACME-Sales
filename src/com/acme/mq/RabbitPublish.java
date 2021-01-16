package com.acme.mq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * For fun - https://www.cloudamqp.com/plans.html
 * https://www.rabbitmq.com/java-client.html
 * View->Tools->Gradle [Refresh]
 */

public class RabbitPublish {

    public static final String AMQP_URL="amqps://lolgkfrt:JrxrfAVFIzKhztFY4NCLTtyRwvEIaFEX@shark.rmq.cloudamqp.com/lolgkfrt";
    public static final String AMQP_PASSWORD = "JrxrfAVFIzKhztFY4NCLTtyRwvEIaFEX ";

    public static final String USER = "lolgkfrt";
    public static final String HOST = "shark.rmq.cloudamqp.com";


    public static void main(String[] args){
        System.out.println("helo");

        ConnectionFactory factory = new ConnectionFactory();
        Channel channel = null;

        try {
            factory.setUri(AMQP_URL);


            final Connection connection = factory.newConnection();
            channel  = connection.createChannel();

            channel.exchangeDeclare("acme.test", "topic", true);

            String message = "Hello Rabbit";


            channel.basicPublish("acme.test", "acme.paymentreceived",null, message.getBytes("UTF-8"));


            channel.close();
            connection.close();

        } catch(Exception e){
            e.printStackTrace();
        } finally {

        }
    }
}
