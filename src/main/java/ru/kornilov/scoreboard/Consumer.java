package ru.kornilov.scoreboard;

import ru.kornilov.scoreboard.beans.TestBean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "Consumer", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/test")
//                                                                             "java:/jms/queue/ExpiryQueue")
})

public class Consumer implements MessageListener {

    @EJB
    RestClient restClient;


    @Override
    public void onMessage(Message message) {
        restClient.getJsonEvent();


    }
}