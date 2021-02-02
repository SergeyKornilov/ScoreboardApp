package ru.kornilov.scoreboard.beans;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TestBean {
    private String text = "text from test bean";
    private static int messageQuantity = 0;

    public void incrMessageQuantity(){
        TestBean.messageQuantity = TestBean.messageQuantity + 1;
        System.out.println("messageQuantity++");
        System.out.println(TestBean.messageQuantity);
    }

    public int getMessageQuantity() {
        return messageQuantity;
    }

    public void setMessageQuantity(int messageQuantity) {
        TestBean.messageQuantity = messageQuantity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}