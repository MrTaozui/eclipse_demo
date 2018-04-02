package com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send{
	public static void main(String[] args) {
		try{
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	 
	   // channel.queueDeclare("queueDemo2", false, false, false, null); //(如果没有就)创建Queue
	    String message = "Hello World!";
	    channel.basicPublish("","queueDemo2", null, message.getBytes());//以byte的方式发布
	    System.out.println(" [x] Sent '" + message + "'");
	 
	    channel.close();
	    connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}