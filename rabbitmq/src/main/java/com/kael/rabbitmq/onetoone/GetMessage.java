package com.kael.rabbitmq.onetoone;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GetMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        getMessage();
    }

    public static void getMessage() throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();

        /**
         * 通道绑定对应消息队列
         * 参数1：队列名称（没有就自动创建）
         * 参数2：队列是否持久化
         * 参数3：是否独占队列(当前队列只能被这个连接使用)
         * 参数4：是否在消费完成后自动删除队列
         */
        channel.queueDeclare("hello",false,false,false,null);

        /**
         * 消费消息
         * 参数1：消费哪个队列的消息
         * 参数2：开始消息的自动确认机制
         * 参数3： 消费时的回调接口
         */
        channel.basicConsume("hello",true,new DefaultConsumer(channel) {
            // byte[]：取出的数据
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("获取消息:"+new String(body));
            }
        });

    }
}


