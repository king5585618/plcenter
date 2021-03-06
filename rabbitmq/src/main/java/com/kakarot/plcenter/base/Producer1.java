package com.kakarot.plcenter.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Producer1 {

    private static final String HELLO = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(HELLO, false, false, false, null);
        for(int i=0;i<10000;i++){
            String message = "Hello, World "+i;
            channel.basicPublish("",HELLO,null,message.getBytes("UTF-8"));
        }
        channel.close();
        connection.close();
    }
}
