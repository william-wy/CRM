package com.lanqiao.CRM.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MQSender {

	 private String userName = "root";
	    private String password = "123456";
	    private String url = "tcp://127.0.0.1:61616";
	    
	    public static void main(String[] args) {
	        MQSender send = new MQSender();
	        send.start();
	    }
	    
	    public void start(){
	        try {
	            ConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, url);
	            Connection connection = factory.createConnection();
	            connection.start();
	            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	//连接名是"textMsg"的队列，此会话将会到该队列中，若 该队列不存在，则被创建
	            Destination destination = session.createQueue("textMsg");
	            MessageProducer producer = session.createProducer(destination);
	            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
	            TextMessage textMsg = session.createTextMessage("消息内容");
	            for(int i = 0 ; i < 10; i ++){
	                producer.send(textMsg);
	            }
	            producer.close();
	            
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	    }

}
