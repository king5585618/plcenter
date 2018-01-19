package com.kakarot.plcenter.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Product5 {

    private final static String EXCHANGE_NAME="test_exchange_direct";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//        channel.close();
//        connection.close();
        Channel channel1 = connection.createChannel();
        channel1.exchangeDeclare(EXCHANGE_NAME, "direct");
        //消息内容
        for(int i=0;i<50;i++){
            String message = "删除商品，id = "+ i;
            channel1.basicPublish(EXCHANGE_NAME,"delete",null,message.getBytes()); //此处delete为路由键；
            System.out.println(" [x] Sent '"+ message+"'");
        }
        channel1.close();
        connection.close();
    }
}
