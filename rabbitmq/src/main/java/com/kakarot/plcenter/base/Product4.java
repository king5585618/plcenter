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
public class Product4 {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
//        String[] routingKeys = new String[]{"quick.orange.rabbit",
//                "lazy.orange.elephant",
//                "quick.orange.fox",
//                "lazy.brown.fox",
//                "quick.brown.fox",
//                "quick.orange.male.rabbit",
//                "lazy.orange.male.rabbit",
//        "lazy.."};
        String[] routingKeys = new String[]{""};
        for(String routingKey : routingKeys) {
            String message = "From "+routingKey+" routingKey' s message!";
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
        }
        channel.close();
        connection.close();
    }
}
