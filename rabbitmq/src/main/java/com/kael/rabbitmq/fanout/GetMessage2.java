package com.kael.rabbitmq.fanout;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GetMessage2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs","fanout");

        // 临时队列
        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue,"logs","");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2从交换机获取消息:"+new String(body));
            }
        });
    }
}
