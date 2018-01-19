package com.kakarot.plcenter.base;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Consumer1 {

    private static final String HELLO = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(HELLO, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("C [x] Received '" + message + "'");
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(HELLO,false,consumer);

    }
}
