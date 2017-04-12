package com.kakarot.plcenter.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by jinzj on 2017/4/10.
 * fanout
 */
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = "hello, world!";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("send " + message + " success");
        channel.close();
        connection.close();
    }
}
