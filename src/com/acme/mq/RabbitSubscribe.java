package com.acme.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitSubscribe {
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

            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, "acme.test", "acme.paymentreceived");



            // Callback function
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };

            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            System.in.read();

            channel.close();
            connection.close();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("I am done");
        }
    }
}
