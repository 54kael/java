package com.kael.rabbitmq.fanout;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机类型为fanout,此时routeKey无效
        channel.exchangeDeclare("logs","fanout");

        // 发送消息给交换机
        channel.basicPublish("logs","",null,"fanout type message".getBytes());

        RabbitMqUtil.closeConnChanel(channel,connection);
    }
}
