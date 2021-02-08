//package ru.kornilov.scoreboard.beans;
//
//import java.io.Serializable;
//import java.util.Calendar;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import org.omnifaces.cdi.Push;
//import org.omnifaces.cdi.PushContext;
//
//@Named
//@ApplicationScoped
//public class PushBean implements Serializable {
//
//
//    @Inject
//    @Push(channel = "events")
//    private PushContext push;
//
//    public void clockAction() {
//
//        push.send("updateEvent");
//    }
//
//}
