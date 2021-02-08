package ru.kornilov.scoreboard;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "Consumer", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/test")
})

public class Consumer implements MessageListener {

    @EJB
    RestClient restClient;

    @Inject
    @Push(channel = "events")
    private PushContext push;


    @Override
    public void onMessage(Message message) {
        restClient.getJsonEvent();


        System.out.println("onMessage");
        push.send("someEvent");
    }
}