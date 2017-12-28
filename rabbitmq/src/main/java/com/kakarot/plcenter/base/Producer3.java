package com.kakarot.plcenter.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Producer3 {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        for (int i=0;i<5;i++){
            String message = "Hello World! " + i;
            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes("UTF-8"));
        }
        channel.close();
        connection.close();
    }
}
