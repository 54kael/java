package com.kael.rabbitmq.direct;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        sendTest();
    }
    public static void sendTest() throws IOException, TimeoutException {

        // 获取连接对象
        Connection connection = RabbitMqUtil.getConnection();

        // 获取通道
        Channel channel = connection.createChannel();

        /**
         * 声明对应消息队列
         * 参数1：队列名称（没有就自动创建）
         * 参数2：队列是否持久化
         * 参数3：是否独占队列(当前队列只能被这个连接使用)
         * 参数4：是否在消费完成后自动删除队列
         */
        channel.queueDeclare("hello",false,false,false,null);

        /**
         * 发布消息
         * 参数1：交换机名称,参数2：队列名称,参数3：传丢参数额外配置,参数4：消息内容
         */
        channel.basicPublish("","hello",null,"Hello RabbitMq".getBytes());

        // 关闭通道和连接
        RabbitMqUtil.closeConnChanel(channel,connection);
    }
}
