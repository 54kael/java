package com.kael.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtil {
    private RabbitMqUtil(){}
    private static final ConnectionFactory connectionFactory;
    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.3.2");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("kael");
        connectionFactory.setPassword("123");
    }

    // 提供连接对象
    public static Connection getConnection() throws IOException, TimeoutException {
        // 获取连接对象
       return connectionFactory.newConnection();
    }

    public static void closeConnChanel(Channel channel,Connection connection) {
        try{
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
