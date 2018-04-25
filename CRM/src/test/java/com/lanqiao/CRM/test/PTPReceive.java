package com.lanqiao.CRM.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PTPReceive {

	 private String userName = "root";
	    private String password = "123456";
	    private String url = "tcp://127.0.0.1:61616";
	    public static void main(String[] args) {
	        PTPReceive receive = new PTPReceive();
	        receive.start();
	    }
	    
	    public void start(){
	        try {
	            ConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, url);
	            Connection connection = factory.createConnection();
	            connection.start();
	            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            Destination destination = session.createQueue("textMsg");
	            MessageConsumer consumer = session.createConsumer(destination);
	            consumer.setMessageListener(new MessageListener() {
	                @Override
	                public void onMessage(Message message) {
	                    try {
	                        String text = ((TextMessage)message).getText();
	                        System.out.println(text);
	                    } catch (JMSException e) {
	                        e.printStackTrace();
	                    }
	                }
	            });
	            consumer.close();
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	    }

}
