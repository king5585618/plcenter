package com.kakarot.plcenter.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Consumer51 {

    private final static String EXCHANGE_NAME="test_exchange_direct";

    private final static String QUEUE_NAME="test_queue_direct_1";

    public static void main(String[] args) throws IOException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定队列到交换机;
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"update");  //匹配路由键为update
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"delete");  //匹配路由键是delete
        //同一时刻服务器只会发送一条消息给消费者;
        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME,false,consumer);
        //获取消息
        while (true)
        {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("前台系统：'"+message+"'");
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }
}
