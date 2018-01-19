package com.kakarot.plcenter.base;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Consumer52 {

    private final static String EXCHANGE_NAME="test_exchange_direct2";

    private final static String QUEUE_NAME="test_queue_direct_1";

    public static void main(String[] args) throws Exception {
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
//        channel.basicQos(100);
//        QueueingConsumer consumer = new QueueingConsumer(channel);
        final Consumer consumer2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    String message = new String(body, "UTF-8");

                    System.out.println("Worker2 [x] Received '" + message + "'");
                } finally {
                    System.out.println("Worker2 [x] Done");
                    // 消息处理完成确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        //监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME,false,consumer2);
    }
}
