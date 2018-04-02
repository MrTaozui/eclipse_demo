package com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Reqv {
 public static void main(String[] args) {
	 try{
	 ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	 
	  ///  channel.queueDeclare("queueDemo2", false, false, false, null);//检查Queue是否存在  如果不存在就创建
	    	   
	    	    /* String message2 = "Hello World2!";  // 与服务器连接打开通道的时候 既可以发送也可以接收队列的消息
	    channel.basicPublish("","queueDemo2", null, message2.getBytes());//以byte的方式发布
*/
	    QueueingConsumer consumer = new QueueingConsumer(channel); //声明一个消费者
	    channel.basicConsume("queueDemo2", true, consumer);
	    while (true) {
	      QueueingConsumer.Delivery delivery = consumer.nextDelivery();//阻塞，直到接收到一条消息
	      String message = new String(delivery.getBody());
	      System.out.println(" [x] Received '" + message + "'");
	    }
	 }catch (Exception e) {
		e.printStackTrace();
	}
}
	 

}
