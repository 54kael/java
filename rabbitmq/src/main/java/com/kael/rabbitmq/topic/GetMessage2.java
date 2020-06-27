package com.kael.rabbitmq.topic;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GetMessage2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        String exchangeName = "log_topic";
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(exchangeName,"topic");

        // 获取临时队列
        String queue = channel.queueDeclare().getQueue();

        // 绑定交换机和队列，#匹配多个单词，*匹配单个单词
        channel.queueBind(queue,exchangeName,"user.#");

        // 消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1: "+new String(body));
            }
        });
    }
}
