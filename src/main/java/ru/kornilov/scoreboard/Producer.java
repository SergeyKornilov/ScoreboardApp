//package ru.kornilov.scoreboard;
//
//import javax.annotation.Resource;
//import javax.ejb.LocalBean;
//import javax.ejb.Schedule;
//import javax.ejb.Stateless;
//import javax.jms.*;
//
//@Stateless
//@LocalBean
//public class Producer {
//
//    @Resource(lookup = "java:/ConnectionFactory")
//    private ConnectionFactory connectionFactory;
//
//    @Resource(lookup = "java:/jms/queue/ExpiryQueue")
//    private Destination destination;
//
//    @Schedule(hour = "*", minute = "*", second = "*/1", persistent = false)
//    public void produceMessage() throws JMSException {
//
//        Connection connection = connectionFactory.createConnection();
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//        MessageProducer messageProducer = session.createProducer(destination);
//
//        TextMessage textMessage = session.createTextMessage("Hello MDB");
//
//        messageProducer.send(textMessage);
//        System.out.println("--------------------------------");
//        connection.close();
//        session.close();
//
//    }
//}
