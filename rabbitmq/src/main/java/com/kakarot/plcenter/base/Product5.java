package com.kakarot.plcenter.base;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Product5 {

    private final static String EXCHANGE_NAME="test_exchange_direct2";

    private static Channel channel3 = null;

    private static Channel getChannel3(Connection connection) throws IOException {
        if(channel3 == null) {
            channel3 = connection.createChannel();
            channel3.confirmSelect();
            channel3.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("ack-------------------------------------");
                }
                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("nack------------------------------");
                }

            });
        }
        return channel3;
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("192.168.23.132");
        factory.setUsername("jin");
        factory.setPassword("jin");
        Address address = new Address("192.168.23.132",5672);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        Connection connection = factory.newConnection(addresses);
//        Channel channel = connection.createChannel();
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//        channel.close();
//        connection.close();
//        Channel channel1 = connection.createChannel();
        Channel channel1 = getChannel3(connection);
        channel1.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //消息内容
        for(int i=0;i<1;i++){
            String message = "删除商品，id = "+ i;
            channel1.basicPublish(EXCHANGE_NAME,"delete",null,message.getBytes()); //此处delete为路由键；
            System.out.println(" [x] Sent '"+ message+"'");
        }
//        channel1.close();
//        connection.close();
    }
}
