package com.kael.rabbitmq.workquene;

import com.kael.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work",true,false,false,null);
        for (int i=0; i<20; i++) {
            channel.basicPublish("","work",null,("hello work quene:"+i).getBytes());
        }
        RabbitMqUtil.closeConnChanel(channel,connection);
    }
}
