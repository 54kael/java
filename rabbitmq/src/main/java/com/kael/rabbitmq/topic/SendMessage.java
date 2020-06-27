package com.kael.rabbitmq.topic;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        String exchangeName = "log_topic";
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 声明交换机为topic,可以动态匹配路由
         * 参数1：交换机名称
         * 参数2：交换机类型
         */
        channel.exchangeDeclare(exchangeName,"topic");

        String routeKey = "user.info";

        // 发送消息到交换机
        channel.basicPublish(exchangeName,routeKey,null,("路由模式["+routeKey+"]").getBytes());
        RabbitMqUtil.closeConnChanel(channel,connection);
    }
}
