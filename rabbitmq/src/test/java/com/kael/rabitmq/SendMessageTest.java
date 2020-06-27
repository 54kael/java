package com.kael.rabitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessageTest {
    @Test
    public void sendTest() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.3.2");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("kael");
        connectionFactory.setPassword("123");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();

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
         * 发布消息
         * 参数1：交换机名称
         * 参数2：队列名称
         * 参数3：传丢参数额外配置
         * 参数4：消息内容
         */
        channel.basicPublish("","hello",null,"Hello RabbitMq".getBytes());

        // 关闭通道和连接
        channel.close();
        connection.close();
    }

}
